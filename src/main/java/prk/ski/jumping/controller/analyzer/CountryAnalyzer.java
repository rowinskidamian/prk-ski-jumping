package prk.ski.jumping.controller.analyzer;

import prk.ski.jumping.model.domain.Country;
import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author RadosławParol
 */
public class CountryAnalyzer {

    public Set<String> getCountryListForTournaments(List<TournamentJumperResult> tournamentParticipantsResults) {
        return tournamentParticipantsResults.stream()
                .map(TournamentJumperResult::getOrigin)
                .collect(Collectors.toSet());
    }

    public List<Country> getCountryAnalysis(List<TournamentJumperResult> resultTournamentList, List<String> countries) {
        Map<String, Country> countryMap = new HashMap<>();

        for (TournamentJumperResult tjr : resultTournamentList) {
            String countryName = tjr.getOrigin();
            boolean isCurrentJumperInList = countries.contains(countryName);

            if (isCurrentJumperInList) {
                addCountryToMapIfNotPresent(countryMap, countryName);
                Country currentCountry = getCurrentCountry(countryMap, tjr, countryName);
                countryMap.put(countryName, currentCountry);
            }
        }

        return countryMap.keySet().stream()
                .map(countryMap::get)
                .collect(Collectors.toList());


    }

    private Country getCurrentCountry(Map<String, Country> countryMap, TournamentJumperResult tournamentJumperResult, String countryName) {
        Country currentCountry = countryMap.get(countryName);

        int rank = tournamentJumperResult.getRank();
        if (rank == 1) {
            currentCountry.setGoldMedals(currentCountry.getGoldMedals() + 1);
        } else if (rank == 2) {
            currentCountry.setSilverMedals(currentCountry.getSilverMedals() + 1);
        } else if (rank == 3) {
            currentCountry.setBronzeMedals(currentCountry.getBronzeMedals() + 1);
        }

        double totalPoints = currentCountry.getTotalPoints();
        double pointsFromTournament = tournamentJumperResult.getTotalPoints();
        totalPoints += pointsFromTournament;
        currentCountry.setTotalPoints(totalPoints);

        return currentCountry;
    }

    private void addCountryToMapIfNotPresent(Map<String, Country> countryMap, String countryName) {
        boolean containsCountry = countryMap.containsKey(countryName);
        if (!containsCountry) {
            Country country = new Country();
            country.setName(countryName);
            countryMap.put(countryName, country);
        }
    }
}
