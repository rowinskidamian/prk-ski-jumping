package prk.ski.jumping.testing.addDB;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.dao.impl.TournamentJumperResultDaoDefault;
import prk.ski.jumping.model.domain.TournamentJumperResult;

public class AddTournamentJumperToBase {

    static TournamentJumperResultDao tjr = new TournamentJumperResultDaoDefault();

    public static void main(String[] args) throws DataBaseException {

        TournamentJumperResult tjrAdd = new TournamentJumperResult();
        tjrAdd.setAthleteName("Damian");
        tjrAdd.setTotalPoints(100);
        tjrAdd.setOrigin("Polska");
        tjrAdd.setTournamentId(2);
        tjrAdd.setRank(3);

        tjr.create(tjrAdd);

    }
}
