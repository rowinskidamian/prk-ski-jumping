package prk.ski.jumping.controller.parser;

import prk.ski.jumping.exception.ParsingException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.domain.TournamentJumperResult;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;

public class ParserService {

    private ResultParser resultParser;
    private TournamentParser tournamentParser;
    private TournamentWorldCupDao tournamentWorldCupDao;
    private TournamentJumperResultDao tournamentJumperResultDao;

    public ParserService() {
        this.resultParser = new ResultParser();
        this.tournamentParser = new TournamentParser();
    }

    public void addTournamentListToDatabase() {
        List<TournamentWorldCup> tournamentWorldCupList = tournamentParser.getAll();
        for (TournamentWorldCup twc : tournamentWorldCupList) {
            tournamentWorldCupDao.create(twc);
        }
    }

    public void printTournamentWorldCupList() {
        List<TournamentWorldCup> databaseRecordList = tournamentWorldCupDao.getAll();
        databaseRecordList.forEach(System.out::println);
    }

    public void addResultListForTournament(TournamentWorldCup tournamentWorldCup) throws ParsingException {
        List<TournamentJumperResult> tournamentJumperResultList = resultParser.getResultListFor(tournamentWorldCup);
        for (TournamentJumperResult tjr : tournamentJumperResultList) {
            tournamentJumperResultDao.create(tjr);
        }
    }

    public void addTournamentListByURL(String URL) {
        List<TournamentWorldCup> tournamentWorldCupList = null;
        try {
            tournamentWorldCupList = tournamentParser.getTournamentList(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (TournamentWorldCup twc : tournamentWorldCupList) {
            tournamentWorldCupDao.create(twc);
            //Parser test below
            System.out.println(twc.getId() + " " + twc.getPlace() + " " + twc.getDate() + "\n link: " + twc.getLink());
        }
    }

    public void addResultListByTournamentURL(String tournamentURL) {
        try {
            List<TournamentJumperResult> tournamentJumperResultList = resultParser.getResultListFor(tournamentURL);
            for (TournamentJumperResult tjr : tournamentJumperResultList) {
                tournamentJumperResultDao.create(tjr);
            }
        } catch (ParsingException e) {
            e.printStackTrace();
        }
    }

    public void printTournamentResultListFromDatabase() {
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
