package prk.ski.jumping.model.dao;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public interface TournamentJumperResultDao {

    TournamentJumperResult create(TournamentJumperResult tournamentJumperResult) throws DataBaseException;
    Optional<TournamentJumperResult> getById(long id) throws DataBaseException;
    List<TournamentJumperResult> getByTournamentId(long id) throws DataBaseException;
    List<TournamentJumperResult> getAll() throws DataBaseException;
    void update(TournamentJumperResult tjr) throws DataBaseException;
    void delete(long id) throws DataBaseException;

}
