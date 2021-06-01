package prk.ski.jumping.model.dao;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.List;
import java.util.Optional;

/**
 * @author RadosławParol
 */

public interface TournamentWorldCupDao {
    public TournamentWorldCup create(TournamentWorldCup cup) throws DataBaseException;;
    public Optional<TournamentWorldCup> getById(long id) throws DataBaseException;;
    public List<TournamentWorldCup> getAll() throws DataBaseException;;
    public void update(TournamentWorldCup cup, long id) throws DataBaseException;;
    public void delete(TournamentWorldCup cup, long id) throws DataBaseException;;
}
