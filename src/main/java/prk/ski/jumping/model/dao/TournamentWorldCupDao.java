package prk.ski.jumping.model.dao;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;
import java.util.Optional;

/**
 * @author RadosławParol
 */

public interface TournamentWorldCupDao {
    TournamentWorldCup create(TournamentWorldCup cup) throws DataBaseException;

    Optional<TournamentWorldCup> getById(long id) throws DataBaseException;

    List<TournamentWorldCup> getAll() throws DataBaseException;

    void update(TournamentWorldCup cup, long id) throws DataBaseException;

    void delete(TournamentWorldCup cup, long id) throws DataBaseException;
}
