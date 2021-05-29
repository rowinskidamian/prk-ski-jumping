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

    public List<Jumper> makeJumperAnalysis(List<TournamentJumperResult> resultTournamentList,
                                           List<String> jumperNamesList) {
        Map<String, Jumper> jumperMap = new HashMap<>();

        for (TournamentJumperResult tournamentJumperResult : resultTournamentList) {
            String athleteName = tournamentJumperResult.getAthleteName();
            boolean isCurrentJumperInList = jumperNamesList.contains(athleteName);

            if (isCurrentJumperInList) {
                addJumperToMapIfNotPresent(jumperMap, athleteName);
                Optional<Jumper> optionalJumper = updateCurrentJumper(jumperMap, tournamentJumperResult, athleteName);
                optionalJumper.ifPresent(currentJumper -> jumperMap.put(athleteName, currentJumper));
            }
        }

        return jumperMap.keySet().stream()
                .map(jumperMap::get)
                .sorted(Comparator.comparingDouble(Jumper::getTotalPoints))
                .collect(Collectors.toList());
    }

    Optional<Jumper> updateCurrentJumper(Map<String, Jumper> currentJumpersMap, TournamentJumperResult providedJumperData,
                               String jumperNamePresentInMap) {
        Jumper currentJumperToUpdate = currentJumpersMap.get(jumperNamePresentInMap);

        if(currentJumperToUpdate == null) return Optional.empty();

        if (currentJumperToUpdate.getOrigin() == null)
            currentJumperToUpdate.setOrigin(providedJumperData.getOrigin());

        int rank = providedJumperData.getRank();
        switch (rank) {
            case 1:
                int goldMedals = currentJumperToUpdate.getGoldMedals();
                goldMedals++;
                currentJumperToUpdate.setGoldMedals(goldMedals);
                break;
            case 2:
                int silverMedals = currentJumperToUpdate.getSilverMedals();
                silverMedals++;
                currentJumperToUpdate.setSilverMedals(silverMedals);
                break;
            case 3:
                int bronzeMedals = currentJumperToUpdate.getBronzeMedals();
                bronzeMedals++;
                currentJumperToUpdate.setBronzeMedals(bronzeMedals);
                break;
        }

        double totalPoints = currentJumperToUpdate.getTotalPoints();
        double pointsFromTournament = providedJumperData.getTotalPoints();
        totalPoints += pointsFromTournament;
        currentJumperToUpdate.setTotalPoints(totalPoints);


        return Optional.of(currentJumperToUpdate);
    }

    void addJumperToMapIfNotPresent(Map<String, Jumper> jumperMap, String athleteName) {
        boolean containsJumper = jumperMap.containsKey(athleteName);
        if (!containsJumper) {
            Jumper jumper = new Jumper();
            jumper.setAthleteName(athleteName);
            jumperMap.put(athleteName, jumper);
        }
    }

}
