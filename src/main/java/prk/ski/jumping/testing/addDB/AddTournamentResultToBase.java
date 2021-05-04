package prk.ski.jumping.testing.addDB;

import prk.ski.jumping.controller.parser.ParserService;
import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;

public class AddTournamentResultToBase {

    public static void main(String[] args) throws DataBaseException {
        ParserService parserService = new ParserService();
        parserService.setTournamentJumperResultDao(new TournamentJumperResultDaoDefault());
        parserService.addResultListByTournamentURL("https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=5837", 1L);
        parserService.addResultListByTournamentURL("https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=5823", 2L);
        parserService.addResultListByTournamentURL("https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=5809", 3L);
        parserService.addResultListByTournamentURL("https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=6017", 4L);
        parserService.addResultListByTournamentURL("https://www.fis-ski.com/DB/general/results.html?sectorcode=JP&raceid=5803", 5L);
    }

}
