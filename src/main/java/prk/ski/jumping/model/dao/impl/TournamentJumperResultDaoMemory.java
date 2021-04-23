package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.model.dao.TournamentJumperResultDao;
import prk.ski.jumping.model.domain.TournamentJumperResult;
import prk.ski.jumping.model.domain.TournamentJumperResultDB;

import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class TournamentJumperResultDaoMemory implements TournamentJumperResultDao {

    private TournamentJumperResultDB tournamentJumperResultDB;

    public TournamentJumperResultDaoMemory() {tournamentJumperResultDB = new TournamentJumperResultDB();
    }

    @Override
    public TournamentJumperResult create(TournamentJumperResult tournamentJumperResult) {
        return tournamentJumperResultDB.create(tournamentJumperResult);
    }

    @Override
    public Optional<TournamentJumperResult> getById(long id) {
        return tournamentJumperResultDB.getById(id);
    }

    @Override
    public List<TournamentJumperResult> getAll() {
        return tournamentJumperResultDB.getAll();
    }

    @Override
    public void update(TournamentJumperResult tjr, long id) {
        tournamentJumperResultDB.update(tjr, id);
    }

    @Override
    public void delete(TournamentJumperResult tjr, long id) {
        tournamentJumperResultDB.delete(tjr, id);
    }
}
