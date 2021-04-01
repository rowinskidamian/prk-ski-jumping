package prk.ski.jumping.controller.analyzer;

import prk.ski.jumping.model.domain.Country;
import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.*;

/**
 * @author RadosławParol
 */
public class CountryAnalyzer {

    public Set<String> getCountryListForTournaments(List<TournamentJumperResult> tjr) {
        return new HashSet<>();
    }

    public List<Country> getCountryAnalysis(List<TournamentJumperResult> resultTournamentList) {
        List<Country> countryList = new ArrayList<>();
        Map<String, Country> countryMap = new HashMap<>();

        for (TournamentJumperResult tjr : resultTournamentList) {
            String countryName = tjr.getOrigin();
            Country currentCountry;

            if (!countryMap.containsKey(countryName)) {
                currentCountry = new Country();
                currentCountry.setName(countryName);
            } else {
                currentCountry = countryMap.get(countryName);
            }



            //setting medals medals

            if (tjr.getRank() == 1) {
                currentCountry.setGoldMedals(currentCountry.getGoldMedals() + 1);
            } else if (tjr.getRank() == 2) {
                currentCountry.setSilverMedals(currentCountry.getSilverMedals() + 1);
            } else if (tjr.getRank() == 3) {
                currentCountry.setBronzeMedals(currentCountry.getBronzeMedals() + 1);
            }
//            switch (tjr.getRank()) {
//                case 1: currentCountry.setGoldMedals(currentCountry.getGoldMedals() + 1);
//                case 2: currentCountry.setSilverMedals(currentCountry.getSilverMedals() + 1);
//                case 3: currentCountry.setBronzeMedals(currentCountry.getBronzeMedals() + 1);
//            }

            //setting total points
            currentCountry.setTotalPoints(currentCountry.getTotalPoints() + tjr.getTotalPoints());

            countryMap.put(countryName, currentCountry);
        }

        for (Map.Entry<String, Country> entry : countryMap.entrySet()) {
            Country country = new Country();
            country.setName(entry.getValue().getName());
            country.setGoldMedals(entry.getValue().getGoldMedals());
            country.setSilverMedals(entry.getValue().getSilverMedals());
            country.setBronzeMedals(entry.getValue().getBronzeMedals());
            country.setTotalPoints(entry.getValue().getTotalPoints());
            countryList.add(entry.getValue());
        }

        return countryList;

    }
}
