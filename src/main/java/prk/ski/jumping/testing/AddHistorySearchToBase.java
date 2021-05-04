package prk.ski.jumping.testing;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.dao.impl.HistorySearchDaoDefault;
import prk.ski.jumping.model.domain.HistorySearch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddHistorySearchToBase {
    private static HistorySearchDao historySearchDao = new HistorySearchDaoDefault();

    public static void main(String[] args) {
        HistorySearch historySearch = new HistorySearch();
        List<String> athletes = new ArrayList<>();
        athletes.add("Noriaki Kasai");
        athletes.add("Kamil Stoch");
        athletes.add("Piotr Żyła");

        List<Long> tournamentList = new ArrayList<>();
        tournamentList.add(101L);
        tournamentList.add(102L);

        historySearch.setAthleteCountryList(athletes);
        historySearch.setTournamentIdList(tournamentList);

        historySearch.setSearchName("Wyszukiwanie 1");
        historySearch.setSearchDate(LocalDate.now());
        historySearch.setSearchType("skoczkowie");
        historySearch.setTournamentAmount(2);

        try {
            HistorySearch historySearchCreated = historySearchDao.create(historySearch);
            System.out.println("Dodano do bazy:");
            System.out.println(historySearchCreated.toString());
        } catch (DataBaseException e) {
            System.err.println(e.getMessage());
        }

    }
}
