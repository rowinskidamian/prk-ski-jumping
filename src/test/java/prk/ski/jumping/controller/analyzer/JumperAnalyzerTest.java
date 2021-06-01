package prk.ski.jumping.controller.analyzer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author DamianRowinski
 */

class JumperAnalyzerTest {
    private JumperAnalyzer jumperAnalyzer;
    private Jumper givenJumper;
    private String athleteName;
    private Map<String, Jumper> jumperMap;

    @BeforeEach
    void init() {
        jumperAnalyzer = new JumperAnalyzer();
        givenJumper = new Jumper();
        athleteName = "Kamil Stoch";
        givenJumper.setAthleteName(athleteName);
        jumperMap = new HashMap<>();
    }


    @Nested
    class GetJumperNamesListForTournament {

        @Test
        void givenResultListShouldReturnJumperSet() {
            TournamentJumperResult tjr1 = new TournamentJumperResult();
            tjr1.setAthleteName(athleteName);

            String athleteName2 = "ATHLETE 2";
            TournamentJumperResult tjr2 = new TournamentJumperResult();
            tjr2.setAthleteName(athleteName2);

            String athleteName3 = "ATHLETE 3";
            TournamentJumperResult tjr3 = new TournamentJumperResult();
            tjr3.setAthleteName(athleteName3);

            List<TournamentJumperResult> jumperResultList = List.of(tjr1, tjr2, tjr3);
            Set<String> expectedSet = Set.of(athleteName, athleteName2, athleteName3);

            Set<String> returnedJumperNameSet = jumperAnalyzer.getJumperNamesListForTournament(jumperResultList);

            assertEquals(expectedSet, returnedJumperNameSet);
        }

        @Test
        void givenFewResultsForOneJumperShouldReturnOneElementSet() {
            TournamentJumperResult tjr1 = new TournamentJumperResult();
            tjr1.setAthleteName(athleteName);

            TournamentJumperResult tjr2 = new TournamentJumperResult();
            tjr2.setAthleteName(athleteName);
            List<TournamentJumperResult> givenResultList = List.of(tjr1, tjr2);
            Set<String> expectedSet = Set.of(athleteName);

            Set<String> outcomeSet = jumperAnalyzer.getJumperNamesListForTournament(givenResultList);

            assertEquals(expectedSet, outcomeSet);

        }

    }

    @Nested
    class MakeJumperAnalysisTests {

        @Test
        void givenOneResultForOneJumperShouldReturnOneElementList() {
            TournamentJumperResult tjr1 = new TournamentJumperResult();
            tjr1.setAthleteName(athleteName);
            List<TournamentJumperResult> tournamentJumperResultList = List.of(tjr1);
            List<String> jumperList = List.of(athleteName);

            List<Jumper> expectedJumperList = List.of(givenJumper);

            List<Jumper> returnedJumperAnalysis = jumperAnalyzer.makeJumperAnalysis(tournamentJumperResultList, jumperList);

            assertEquals(expectedJumperList, returnedJumperAnalysis);
        }

        @Test
        void givenTwoResultsForTwoJumpersOneIsPresentInListShouldReturnOneElementList() {
            TournamentJumperResult tjr1 = new TournamentJumperResult();
            tjr1.setAthleteName(athleteName);
            TournamentJumperResult tjr2 = new TournamentJumperResult();
            tjr2.setAthleteName("Noriaki Kasai");

            List<TournamentJumperResult> tournamentJumperResultList = List.of(tjr1, tjr2);
            List<String> jumperList = List.of(athleteName);

            List<Jumper> expectedJumperList = List.of(givenJumper);

            List<Jumper> returnedJumperAnalysis = jumperAnalyzer.makeJumperAnalysis(tournamentJumperResultList, jumperList);

            assertEquals(expectedJumperList, returnedJumperAnalysis);
        }

    }

    @Nested
    class UpdateCurrentJumperTests {

        @Test
        void givenJumperNameResultsShouldUpdateJumperFromMap() {
            jumperMap.put(athleteName, givenJumper);

            TournamentJumperResult providedJumperData = new TournamentJumperResult();
            providedJumperData.setAthleteName(athleteName);
            providedJumperData.setTotalPoints(1000);
            providedJumperData.setRank(1);
            providedJumperData.setOrigin("POLSKA");

            Jumper expectedJumper = new Jumper();
            expectedJumper.setAthleteName(athleteName);
            expectedJumper.setTotalPoints(1000);
            expectedJumper.setGoldMedals(1);
            expectedJumper.setOrigin("POLSKA");

            Jumper returnedJumper = null;
            Optional<Jumper> optionalJumper = jumperAnalyzer.updateCurrentJumper(jumperMap, providedJumperData, athleteName);
            if (optionalJumper.isPresent()) {
                returnedJumper = optionalJumper.get();
            }
            assertEquals(expectedJumper, returnedJumper);
        }

        @Test
        void givenJumperNotPresentInMapShouldNotUpdateJumperFromMap() {
            jumperMap.put(athleteName, givenJumper);

            TournamentJumperResult providedJumperData = new TournamentJumperResult();
            providedJumperData.setAthleteName(athleteName);
            providedJumperData.setTotalPoints(1000);
            providedJumperData.setRank(1);
            providedJumperData.setOrigin("POLSKA");

            String athleteNameNotPresent = "Noriaki Kasai";

            Jumper expectedJumper = new Jumper();
            expectedJumper.setAthleteName(athleteName);

            jumperAnalyzer.updateCurrentJumper(jumperMap, providedJumperData, athleteNameNotPresent);
            Jumper jumperOutcomeFromMap = jumperMap.get(athleteName);

            assertEquals(expectedJumper, jumperOutcomeFromMap);
        }

        @Test
        void givenJumperMapWithFewElementsShouldUpdateRightJumper() {
            jumperMap.put(athleteName, givenJumper);
            Jumper jumper1 = new Jumper();
            String jumper1Name = "Dawid Kubacki";
            jumper1.setAthleteName(jumper1Name);

            Jumper jumper2 = new Jumper();
            String jumper2Name = "Simon Ammann";
            jumper2.setAthleteName(jumper2Name);

            Jumper expectedJumper1 = new Jumper();
            expectedJumper1.setAthleteName(jumper1Name);

            Jumper expectedJumper2 = new Jumper();
            expectedJumper2.setAthleteName(jumper2Name);

            jumperMap.put(jumper1Name, jumper1);
            jumperMap.put(jumper2Name, jumper2);

            TournamentJumperResult providedJumperData = new TournamentJumperResult();
            providedJumperData.setAthleteName(athleteName);
            providedJumperData.setTotalPoints(1000);
            providedJumperData.setRank(1);
            providedJumperData.setOrigin("POLSKA");

            Jumper expectedJumper = new Jumper();
            expectedJumper.setAthleteName(athleteName);
            expectedJumper.setTotalPoints(1000);
            expectedJumper.setGoldMedals(1);
            expectedJumper.setOrigin("POLSKA");

            Optional<Jumper> optionalJumper = jumperAnalyzer.updateCurrentJumper(jumperMap, providedJumperData, athleteName);
            Jumper returnedJumper = optionalJumper.orElseThrow();

            assertAll(() -> assertEquals(expectedJumper1, jumperMap.get(jumper1Name)),
                    () -> assertEquals(expectedJumper2, jumperMap.get(jumper2Name)),
                    () -> assertEquals(expectedJumper, returnedJumper));
        }
    }

    @Nested
    class AddJumperToMapIfNotPresentTests {

        @Test
        void givenMapAndAthleteNameShouldReturnMapWithJumper() {
            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);
            Jumper jumperAdded = jumperMap.get(athleteName);

            assertEquals(givenJumper, jumperAdded);
        }

        @Test
        void givenEmptyMapShouldReturnMapWithOneJumper() {
            int expectedSize = 1;

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);
            int returnedMapSize = jumperMap.size();

            assertEquals(expectedSize, returnedMapSize);
        }

        @ParameterizedTest(name = "Given jumperMap size = {0} adding Jumper NOT present in map should return map size: {1}")
        @CsvSource({"2,3",
                "5,6",
                "10,11",
                "20,21"})
        void settingStartSizeJumperMapWhenAddingJumperShouldReturnIncrementedMap(int mapSize, int expectedMapSize) {
            for (int i = 0; i < mapSize; i++) {
                Jumper j = new Jumper();
                String currentKeyName = String.valueOf(i);
                j.setAthleteName(currentKeyName);
                jumperMap.put(currentKeyName, j);
            }

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);
            int outcomeSize = jumperMap.size();
            assertEquals(expectedMapSize, outcomeSize);
        }

        @ParameterizedTest(name = "Given jumperMap size = {0} adding Jumper present in map should return map size: {0}")
        @CsvSource({"3", "9", "7", "10"})
        void addingJumperPresentInPopulatedMapShouldNotAddJumper(int mapSize) {
            for (int i = 0; i < mapSize - 1; i++) {
                Jumper j = new Jumper();
                String currentKeyName = String.valueOf(i);
                j.setAthleteName(currentKeyName);
                jumperMap.put(currentKeyName, j);
            }
            jumperMap.put(athleteName, givenJumper);

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);
            int outcomeSize = jumperMap.size();
            assertEquals(mapSize, outcomeSize);
        }

        @Test
        void givenMapWithSameJumperNameShouldNotReplaceCurrentJumper() {
            jumperMap.put(athleteName, givenJumper);
            Jumper addedJumper = new Jumper();
            addedJumper.setOrigin("TEST ORIGIN");
            addedJumper.setAthleteName(athleteName);

            jumperAnalyzer.addJumperToMapIfNotPresent(jumperMap, athleteName);

            Jumper jumperPresentInMap = jumperMap.get(athleteName);

            assertNotEquals(addedJumper, jumperPresentInMap);
        }
    }
}