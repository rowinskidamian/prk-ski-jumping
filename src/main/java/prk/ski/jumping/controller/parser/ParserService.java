package prk.ski.jumping.controller.parser;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.exception.ParsingException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.domain.TournamentJumperResult;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.io.IOException;
import java.util.List;

/**
 * @author DamianRowinski
 */

public class ParserService {

    private final ResultParser resultParser;
    private final TournamentParser tournamentParser;
    private TournamentWorldCupDao tournamentWorldCupDao;
    private TournamentJumperResultDao tournamentJumperResultDao;

    public ParserService() {
        this.resultParser = new ResultParser();
        this.tournamentParser = new TournamentParser();
    }

    public void printTournamentWorldCupList() throws DataBaseException {
        List<TournamentWorldCup> databaseRecordList = tournamentWorldCupDao.getAll();
        databaseRecordList.forEach(System.out::println);
    }

    public void addResultListForTournament(TournamentWorldCup tournamentWorldCup) throws ParsingException, DataBaseException {
        List<TournamentJumperResult> tournamentJumperResultList = resultParser.getResultListFor(tournamentWorldCup);
        for (TournamentJumperResult tjr : tournamentJumperResultList) {
            tournamentJumperResultDao.create(tjr);
        }
    }

    public void addSmallTournamentListByURL(String URL, int noOfMaxResults) throws DataBaseException {
        List<TournamentWorldCup> tournamentWorldCupList = null;
        try {
            tournamentWorldCupList = tournamentParser.getSmallTournamentList(URL, noOfMaxResults);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (TournamentWorldCup twc : tournamentWorldCupList) {
            tournamentWorldCupDao.create(twc);
        }
    }

    public void addTournamentListByURL(String URL) throws DataBaseException {
        List<TournamentWorldCup> tournamentWorldCupList = null;
        try {
            tournamentWorldCupList = tournamentParser.getTournamentList(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (TournamentWorldCup twc : tournamentWorldCupList) {
            tournamentWorldCupDao.create(twc);
        }
    }

    public void addResultListByTournamentURL(String tournamentURL, Long tournamentId) throws DataBaseException {
        try {
            List<TournamentJumperResult> tournamentJumperResultList = resultParser.getResultListFor(tournamentURL);
            for (TournamentJumperResult tjr : tournamentJumperResultList) {
                tjr.setTournamentId(tournamentId);
                tournamentJumperResultDao.create(tjr);
            }
        } catch (ParsingException e) {
            e.printStackTrace();
        }
    }

    public void addResultListByTournamentURL(String tournamentURL) throws DataBaseException {
        try {
            List<TournamentJumperResult> tournamentJumperResultList = resultParser.getResultListFor(tournamentURL);
            for (TournamentJumperResult tjr : tournamentJumperResultList) {
                tournamentJumperResultDao.create(tjr);
            }
        } catch (ParsingException e) {
            e.printStackTrace();
        }
    }

    public void printTournamentResultListFromDatabase() throws DataBaseException {
        List<TournamentJumperResult> database = tournamentJumperResultDao.getAll();
        database.forEach(System.out::println);
    }

    public void setTournamentWorldCupDao(TournamentWorldCupDao tournamentWorldCupDao) {
        this.tournamentWorldCupDao = tournamentWorldCupDao;
    }

    public void setTournamentJumperResultDao(TournamentJumperResultDao tournamentJumperResultDao) {
        this.tournamentJumperResultDao = tournamentJumperResultDao;
    }
}
