package prk.ski.jumping.controller.analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import prk.ski.jumping.model.domain.Country;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class CountryAnalyzerTest {
    private CountryAnalyzer analyzer;
    private List<TournamentJumperResult> tjrList;
    private Map<String, Country> countryMap;
    private String currentCountry;
    private List<Country> countryList;
    private List<String> countries;

    @BeforeEach
    void createData() {
        analyzer = new CountryAnalyzer();
        tjrList = new ArrayList<>();
        countries = new ArrayList<>();


        countryList = new ArrayList<>();
        countryList.add(new Country(2, "POL", 2, 1, 0, 0, 2400.1));
        countryList.add(new Country(4, "SLO", 1, 1, 2, 0, 2100.2));
        countryList.add(new Country(9, "GER", 1, 2, 0, 0, 2200.6));
        countryList.add(new Country(5, "JPN", 1, 2, 0, 0, 2300.6));
    }

    //getCountryListForTournaments() test
    @Test
    void methodReturnsCorrectSetOfCountries() {
        Set<String> expectedOrigins = new HashSet<String>();
        expectedOrigins.add("GER");
        expectedOrigins.add("POL");
        expectedOrigins.add("JPN");
        expectedOrigins.add("SLO");

        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 424.2, 2);
        TournamentJumperResult result2 = new TournamentJumperResult(2, 1, "JPN", "KOBAYASHI Ryoyu", 452.5, 2);
        TournamentJumperResult result3 = new TournamentJumperResult(3, 3, "POL", "ZYLA Piotr", 410.5, 2);
        TournamentJumperResult result4 = new TournamentJumperResult(4, 4, "SLO", "PAVLOVCIC Bor", 400.2, 2);
        tjrList.add(result1);
        tjrList.add(result2);
        tjrList.add(result3);
        tjrList.add(result4);

        Set<String> analyzedSet = analyzer.getCountryListForTournaments(tjrList);

        assertEquals(expectedOrigins, analyzedSet);
    }

    @Test
    void methodReturnsCorrectSetOfCountriesNoMatterDuplicateCountries() {
        Set<String> expectedOrigins = new HashSet<String>();
        expectedOrigins.add("GER");
        expectedOrigins.add("POL");
        expectedOrigins.add("JPN");
        expectedOrigins.add("SLO");

        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 424.2, 2);
        TournamentJumperResult result2 = new TournamentJumperResult(2, 1, "JPN", "KOBAYASHI Ryoyu", 452.5, 2);
        TournamentJumperResult result3 = new TournamentJumperResult(3, 3, "POL", "ZYLA Piotr", 410.5, 2);
        TournamentJumperResult result4 = new TournamentJumperResult(4, 4, "SLO", "PAVLOVCIC Bor", 400.2, 2);
        TournamentJumperResult duplicate = new TournamentJumperResult();
        duplicate.setOrigin("SLO");

        tjrList.add(result1);
        tjrList.add(result2);
        tjrList.add(result3);
        tjrList.add(result4);
        tjrList.add(duplicate);

        Set<String> analyzedSet = analyzer.getCountryListForTournaments(tjrList);

        assertEquals(expectedOrigins, analyzedSet);
    }

    @Test
    void methodReturnsCorrectSetSizeOfCountries() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 424.2, 2);
        TournamentJumperResult result2 = new TournamentJumperResult(2, 1, "JPN", "KOBAYASHI Ryoyu", 452.5, 2);
        TournamentJumperResult result3 = new TournamentJumperResult(3, 3, "POL", "ZYLA Piotr", 410.5, 2);
        TournamentJumperResult result4 = new TournamentJumperResult(4, 4, "SLO", "PAVLOVCIC Bor", 400.2, 2);
        tjrList.add(result1);
        tjrList.add(result2);
        tjrList.add(result3);
        tjrList.add(result4);

        int expected = 4;

        Set<String> analyzedSet = analyzer.getCountryListForTournaments(tjrList);
        int actual = analyzedSet.size();

        assertEquals(expected, actual);
    }


    //getCountryAnalysis() test

    @Test
    void methodReturnsCorrectListSize() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 424.2, 2);
        TournamentJumperResult result2 = new TournamentJumperResult(2, 1, "JPN", "KOBAYASHI Ryoyu", 452.5, 2);
        TournamentJumperResult result3 = new TournamentJumperResult(3, 3, "POL", "ZYLA Piotr", 410.5, 2);
        TournamentJumperResult result4 = new TournamentJumperResult(4, 4, "SLO", "PAVLOVCIC Bor", 400.2, 2);
        tjrList.add(result1);
        tjrList.add(result2);
        tjrList.add(result3);
        tjrList.add(result4);

        countries.add("NOR");
        countries.add("AUT");
        countries.add("GER");
        countries.add("SLO");
        List<Country> analyzedList = analyzer.getCountryAnalysis(tjrList, countries);
        int actual = analyzedList.size();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    void methodReturnsCorrectCountries() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 424.2, 2);
        TournamentJumperResult result2 = new TournamentJumperResult(2, 1, "JPN", "KOBAYASHI Ryoyu", 452.5, 2);
        TournamentJumperResult result3 = new TournamentJumperResult(3, 3, "POL", "ZYLA Piotr", 410.5, 2);
        TournamentJumperResult result4 = new TournamentJumperResult(4, 4, "SLO", "PAVLOVCIC Bor", 400.2, 2);
        tjrList.add(result1);
        tjrList.add(result2);
        tjrList.add(result3);
        tjrList.add(result4);


        countries.add("GER");
        countries.add("JPN");
        List<Country> analyzedList = analyzer.getCountryAnalysis(tjrList, countries);

        assertAll(() -> assertTrue(analyzedList.stream().filter(o -> o.getName().equals("GER")).findFirst().isPresent()),
                () -> assertTrue(analyzedList.stream().filter(o -> o.getName().equals("JPN")).findFirst().isPresent()),
                () -> assertTrue(!analyzedList.stream().filter(o -> o.getName().equals("POL")).findFirst().isPresent()),
                () -> assertTrue(!analyzedList.stream().filter(o -> o.getName().equals("SLO")).findFirst().isPresent()));

    }

    @Test
    void methodReturnsListLengthEqualToNumberOfDifferentCountriesPassed() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 424.2, 2);
        TournamentJumperResult result2 = new TournamentJumperResult(2, 1, "GER", "EISENBICHLER Markus", 452.5, 2);
        TournamentJumperResult result3 = new TournamentJumperResult(3, 3, "POL", "ZYLA Piotr", 410.5, 2);
        TournamentJumperResult result4 = new TournamentJumperResult(2, 1, "JPN", "KOBAYASHI Ryoyu", 452.5, 2);
        tjrList.add(result1);
        tjrList.add(result2);
        tjrList.add(result3);
        tjrList.add(result4);

        countries.add("GER");
        countries.add("JPN");
        countries.add("POL");
        List<Country> analyzedList = analyzer.getCountryAnalysis(tjrList, countries);
        int actual = analyzedList.size();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    void methodReturnsListLengthZeroWhenCountryListDoesNotMatchTjrList() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 424.2, 2);
        TournamentJumperResult result2 = new TournamentJumperResult(2, 1, "JPN", "KOBAYASHI Ryoyu", 452.5, 2);
        TournamentJumperResult result3 = new TournamentJumperResult(3, 3, "POL", "ZYLA Piotr", 410.5, 2);
        tjrList.add(result1);
        tjrList.add(result2);
        tjrList.add(result3);

        countries.add("AUT");
        countries.add("NOR");
        countries.add("RUS");
        List<Country> analyzedList = analyzer.getCountryAnalysis(tjrList, countries);
        int actual = analyzedList.size();
        int expected = 0;

        assertEquals(expected, actual);
    }

    @Test
    void goldMedalsSumsToCorrectValue() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 1, "GER", "GEIGER Karl", 424.2, 1);
        tjrList.add(result1);
        tjrList.add(result1);

        countries.add("GER");
        List<Country> analyzedList = analyzer.getCountryAnalysis(tjrList, countries);
        int actual = analyzedList.get(0).getGoldMedals();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    void silverMedalsSumsToCorrectValue() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 424.2, 1);
        tjrList.add(result1);
        tjrList.add(result1);
        tjrList.add(result1);

        countries.add("GER");
        List<Country> analyzedList = analyzer.getCountryAnalysis(tjrList, countries);
        int actual = analyzedList.get(0).getSilverMedals();
        int expected = 3;

        assertEquals(expected, actual);
    }

    @Test
    void bronzeMedalsSumsToCorrectValue() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 3, "GER", "GEIGER Karl", 424.2, 1);
        tjrList.add(result1);
        tjrList.add(result1);
        tjrList.add(result1);
        tjrList.add(result1);

        countries.add("GER");
        List<Country> analyzedList = analyzer.getCountryAnalysis(tjrList, countries);
        int actual = analyzedList.get(0).getBronzeMedals();
        int expected = 4;

        assertEquals(expected, actual);
    }

    @Test
    void listIsSortedByTotalPoints() {
        TournamentJumperResult result1 = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 100, 2);
        TournamentJumperResult result2 = new TournamentJumperResult(2, 1, "JPN", "KOBAYASHI Ryoyu", 300, 2);
        TournamentJumperResult result3 = new TournamentJumperResult(3, 3, "POL", "ZYLA Piotr", 50, 2);
        tjrList.add(result1);
        tjrList.add(result2);
        tjrList.add(result3);

        countries.add("GER");
        countries.add("JPN");
        countries.add("POL");
        List<Country> analyzedList = analyzer.getCountryAnalysis(tjrList, countries);
        double firstResult = analyzedList.get(0).getTotalPoints();
        double secondResult = analyzedList.get(1).getTotalPoints();
        double thirdResult = analyzedList.get(2).getTotalPoints();

        assertAll (() -> assertTrue(firstResult > secondResult),
                () -> assertTrue(secondResult > thirdResult));
    }


    //getCurrentCountry() test

    @Test
    void methodSumsGoldMedals() {
        countryMap = new HashMap<>();
        countryMap.put("GER", new Country(9, "GER", 1, 2, 0, 0, 100));
        currentCountry = "GER";
        TournamentJumperResult result = new TournamentJumperResult(1, 1, "GER", "GEIGER Karl", 100, 2);

        int actual = analyzer.getCurrentCountry(countryMap, result, currentCountry).getGoldMedals();
        int expected = 2;
        assertEquals(expected, actual);
    }
    @Test
    void methodSumsSilverMedals() {
        countryMap = new HashMap<>();
        countryMap.put("GER", new Country(9, "GER", 1, 2, 0, 0, 100));
        currentCountry = "GER";
        TournamentJumperResult result = new TournamentJumperResult(1, 2, "GER", "GEIGER Karl", 100, 2);

        int actual = analyzer.getCurrentCountry(countryMap, result, currentCountry).getSilverMedals();
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    void methodSumsBronzeMedals() {
        countryMap = new HashMap<>();
        countryMap.put("GER", new Country(9, "GER", 1, 2, 0, 0, 100));
        currentCountry = "GER";
        TournamentJumperResult result = new TournamentJumperResult(1, 3, "GER", "GEIGER Karl", 100, 2);

        int actual = analyzer.getCurrentCountry(countryMap, result, currentCountry).getBronzeMedals();
        int expected = 1;
        assertEquals(expected, actual);
    }
    @Test
    void methodSumsTotalPoints() {
        countryMap = new HashMap<>();
        countryMap.put("GER", new Country(9, "GER", 1, 2, 0, 0, 100));
        currentCountry = "GER";
        TournamentJumperResult result = new TournamentJumperResult(1, 3, "GER", "GEIGER Karl", 200, 2);

        double actual = analyzer.getCurrentCountry(countryMap, result, currentCountry).getTotalPoints();
        double expected = 300;
        assertEquals(expected, actual);
    }

    //addCountryToMapIfNotPresent() test

    @Test
    void methodAddsCountryToMapWhenItDoesNotContainIt() {
        countryMap = new HashMap<>();
        countryMap.put("GER", new Country(9, "GER", 1, 2, 0, 0, 100));
        currentCountry = "POL";

        analyzer.addCountryToMapIfNotPresent(countryMap, currentCountry);

        assertTrue(countryMap.containsKey("POL"));
    }
    @Test
    void methodDoNotAddCountryToMapWhenItContainIt() {
        countryMap = new HashMap<>();
        countryMap.put("GER", new Country(9, "GER", 1, 2, 0, 0, 100));
        currentCountry = "GER";

        analyzer.addCountryToMapIfNotPresent(countryMap, currentCountry);

        assertTrue(countryMap.size() == 1);
    }

    @Test
    void methodHasCorrectLengthAfterAddingCountryThatIsNotPresent() {
        countryMap = new HashMap<>();
        countryMap.put("GER", new Country(9, "GER", 1, 2, 0, 0, 100));
        currentCountry = "POL";

        analyzer.addCountryToMapIfNotPresent(countryMap, currentCountry);
        int expected = 2;
        int actual = countryMap.size();
        assertEquals(expected, actual);
    }


}
