package prk.ski.jumping.controller.analyzer;

import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author DamianRowinski
 */

public class JumperAnalyzer {

    public Set<String> getJumperNamesListForTournament(List<TournamentJumperResult> tournamentParticipantsResults) {
        return tournamentParticipantsResults.stream()
                .map(TournamentJumperResult::getAthleteName)
                .collect(Collectors.toSet());
    }

    public List<Jumper> getJumperAnalysisFor(List<TournamentJumperResult> resultTournamentList, List<String> jumperNamesList) {
        Map<String, Jumper> jumperMap = new HashMap<>();

        for (TournamentJumperResult tournamentJumperResult : resultTournamentList) {
            String athleteName = tournamentJumperResult.getAthleteName();
            boolean isCurrentJumperInList = jumperNamesList.contains(athleteName);

            if (isCurrentJumperInList) {
                addJumperToMapIfNotPresent(jumperMap, athleteName);
                Jumper currentJumper = getCurrentJumper(jumperMap, tournamentJumperResult, athleteName);
                jumperMap.put(athleteName, currentJumper);
            }
        }

        return jumperMap.keySet().stream()
                .map(jumperMap::get)
                .collect(Collectors.toList());
    }

    private Jumper getCurrentJumper(Map<String, Jumper> jumperMap, TournamentJumperResult tournamentJumperResult, String athleteName) {
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
        return currentJumper;
    }

    private void addJumperToMapIfNotPresent(Map<String, Jumper> jumperMap, String athleteName) {
        boolean containsJumper = jumperMap.containsKey(athleteName);
        if (!containsJumper) {
            Jumper jumper = new Jumper();
            jumper.setAthleteName(athleteName);
            jumperMap.put(athleteName, jumper);
        }
    }

}
