package prk.ski.jumping.model.dao.impl.memory;

import prk.ski.jumping.exception.DataBaseException;
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
    public TournamentJumperResult create(TournamentJumperResult tournamentJumperResult) throws DataBaseException {
        return tournamentJumperResultDB.create(tournamentJumperResult);
    }

    @Override
    public Optional<TournamentJumperResult> getById(long id) throws DataBaseException {
        return tournamentJumperResultDB.getById(id);
    }

    @Override
    public List<TournamentJumperResult> getAll() throws DataBaseException {
        return tournamentJumperResultDB.getAll();
    }

    @Override
    public void update(TournamentJumperResult tjr) throws DataBaseException {
        tournamentJumperResultDB.update(tjr);
    }

    @Override
    public void delete(long id) throws DataBaseException {
        tournamentJumperResultDB.delete(id);
    }
}
