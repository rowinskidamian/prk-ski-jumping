package prk.ski.jumping.controller.parser;

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

    public ParserService(TournamentWorldCupDao tournamentWorldCupDao,
                         TournamentJumperResultDao tournamentJumperResultDao) {
        this.resultParser = new ResultParser();
        this.tournamentParser = new TournamentParser();
        this.tournamentWorldCupDao = tournamentWorldCupDao;
        this.tournamentJumperResultDao = tournamentJumperResultDao;
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

    public void addResultListForTournament(TournamentWorldCup tournamentWorldCup) {
        List<TournamentJumperResult> tournamentJumperResultList = resultParser.getResultListFor(tournamentWorldCup);
        for (TournamentJumperResult tjr : tournamentJumperResultList) {
            tournamentJumperResultDao.create(tjr);
        }
    }

    public void printTournamentResultListFromDatabase() {
        List<TournamentJumperResult> database = tournamentJumperResultDao.getAll();
        database.forEach(System.out::println);
    }


}
