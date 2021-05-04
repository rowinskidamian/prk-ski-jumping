package prk.ski.jumping.testing.addDB;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.impl.HistorySearchDaoDefault;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.domain.HistorySearch;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.List;

public class GetTournamentHistoryFromDB {

    private static TournamentJumperResultDao tjrDao = new TournamentJumperResultDaoDefault();
    private static HistorySearchDao hsDao = new HistorySearchDaoDefault();

    public static void main(String[] args) {
        try {
            List<TournamentJumperResult> all = tjrDao.getAll();
            all.forEach(System.out::println);

            List<HistorySearch> hsList = hsDao.getAll();
            hsList.forEach(System.out::println);

        } catch (DataBaseException e) {
            e.printStackTrace();
        }




    }
}
