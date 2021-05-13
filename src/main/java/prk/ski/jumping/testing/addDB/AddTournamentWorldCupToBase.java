package prk.ski.jumping.testing.addDB;

import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentWorldCupDao;
import prk.ski.jumping.model.dao.impl.TournamentWorldCupDaoDefault;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;

public class AddTournamentWorldCupToBase {
    private static TournamentWorldCupDao twcDao = new TournamentWorldCupDaoDefault();
    public static void main(String[] args) throws DataBaseException {
        String url = "https://www.fis-ski.com/DB/general/statistics.html?sectorcode=JP";

        ParserService parserService = new ParserService();
        parserService.setTournamentWorldCupDao(new TournamentWorldCupDaoDefault());
        parserService.addTournamentListByURL(url);
    }
}
