package prk.ski.jumping.controller.analyzer;

import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.*;
import java.util.stream.Collectors;

public class JumperAnalyzer {

    public Set<String> getAthleteListForTournaments(List<TournamentJumperResult> tjr) {
        return new HashSet<>();
    }

    public List<Jumper> getJumperAnalysis(List<TournamentJumperResult> resultTournamentList, Set<String> athletesNames) {
        Map<String, Jumper> jumperMap = new HashMap<>();
        List<Jumper> jumperList = new ArrayList<>();

        for (TournamentJumperResult tournamentJumperResult : resultTournamentList) {
            String athleteName = tournamentJumperResult.getAthleteName();
            boolean containsJumper = jumperMap.containsKey(athleteName);

            if(!containsJumper) {
                Jumper jumper = new Jumper();
                jumper.setAthleteName(athleteName);
            }

            Jumper currentJumper = jumperMap.get(athleteName);

            int rank = tournamentJumperResult.getRank();
            switch (rank) {
                case 1:
                    int goldMedals = currentJumper.getGoldMedals();
                    goldMedals++;
                    currentJumper.setGoldMedals(goldMedals);
                case 2:
                    int silverMedals = currentJumper.getSilverMedals();
                    silverMedals++;
                    currentJumper.setSilverMedals(silverMedals);
                case 3:
                    int bronzeMedals = currentJumper.getBronzeMedals();
                    bronzeMedals++;
                    currentJumper.setBronzeMedals(bronzeMedals);
            }

            double totalPoints = currentJumper.getTotalPoints();
            double pointsFromTournament = tournamentJumperResult.getTotalPoints();
            totalPoints += pointsFromTournament;
            currentJumper.setTotalPoints(totalPoints);

            jumperMap.put(athleteName, currentJumper);
        }

        return jumperMap.keySet().stream()
                .map(jumperMap::get)
                .collect(Collectors.toList());
    }

}
