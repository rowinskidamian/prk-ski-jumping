package prk.ski.jumping.testing.addDB;

import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.dao.impl.TournamentWorldCupDaoDefault;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;

public class AddTournamentResultToBase {

    public static void main(String[] args) throws DataBaseException {
        ParserService parserService = new ParserService();
        parserService.setTournamentJumperResultDao(new TournamentJumperResultDaoDefault());

        TournamentWorldCupDao twcDao = new TournamentWorldCupDaoDefault();
        List<TournamentWorldCup> twcList = twcDao.getAll();

//        parserService.addResultListByTournamentURL(twcList.get(1).getLink(), twcList.get(1).getId());
//        parserService.addResultListByTournamentURL(twcList.get(2).getLink(), twcList.get(2).getId());
//        parserService.addResultListByTournamentURL(twcList.get(3).getLink(), twcList.get(3).getId());

        for (TournamentWorldCup t : twcList) {
            long twcId = t.getId();
            String twcLink = t.getLink();

            parserService.addResultListByTournamentURL(twcLink, twcId);
        }

    }

}
