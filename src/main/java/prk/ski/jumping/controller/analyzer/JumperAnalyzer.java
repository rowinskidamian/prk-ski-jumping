package prk.ski.jumping.controller.analyzer;

import prk.ski.jumping.model.domain.Jumper;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author DamianRowinski
 * @version 1.0.0
 */

public class JumperAnalyzer {

    /**
     * Method allows you to get filtered list of ski jumpers names from provided results list. List can have duplicated
     * ski jumpers names which can be results for one jumper from few tournaments. Method is used in application to show
     * user jumpers list from which he can select users for analysis.
     * @param tournamentParticipantsResults is a list of results from
     * @return Set String with unique ski jumpers names.
     */
    public Set<String> getJumperNamesListForTournament(List<TournamentJumperResult> tournamentParticipantsResults) {
        return tournamentParticipantsResults.stream()
                .map(TournamentJumperResult::getAthleteName)
                .collect(Collectors.toSet());
    }

    /**
     * Essential method which makes analysis from provided tournament results for chosen jumpers. First it checks
     * if jumper from resultTournamentList is present in provided jumperNamesList. Then it uses
     * {@link JumperAnalyzer#addJumperToMapIfNotPresent(Map, String)} to populate auxiliary jumperMap and also
     * {@link JumperAnalyzer#updateCurrentJumper(Map, TournamentJumperResult, String)} method which updates auxiliary
     * jumperMap with current jumper from provided resultTournamentList.
     *
     * @param resultTournamentList is a list of results for jumpers from tournaments.
     * @param jumperNamesList is a list of jumpers for whom the analysis will be conducted.
     * @return list of jumpers updated by results from tournament result list.
     */
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

    /**
     * Method which generates ski jumper with updated fields by provided results from tournament result list. Used by:
     * {@link JumperAnalyzer#makeJumperAnalysis(List, List)} which is method used to show application user analysed outcome.
     *
     * @param currentJumpersMap is a auxiliary map which will be updated by new or updated jumper
     * @param providedJumperData jumper is updated by this provided data
     * @param jumperNamePresentInMap is a String name for jumper present in map which will be updated by new results
     * @return Optional updated jumper, if jumper is not present in map it returns empty optional.
     */
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

    /**
     * Auxiliary method, populates given jumperMap with new Jumper object created with provided athleteName if jumper for given name
     * is not currently present in map. It is used by:
     * {@link JumperAnalyzer#makeJumperAnalysis(List, List)} which is method used to show application user analysed outcome.
     *
     * @param jumperMap provided map with jumper objects organized by key as athleteNames
     * @param athleteName is a String jumper (most likely first and last name).
     */
    void addJumperToMapIfNotPresent(Map<String, Jumper> jumperMap, String athleteName) {
        boolean containsJumper = jumperMap.containsKey(athleteName);
        if (!containsJumper) {
            Jumper jumper = new Jumper();
            jumper.setAthleteName(athleteName);
            jumperMap.put(athleteName, jumper);
        }
    }

}
