package prk.ski.jumping.model.dao;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.domain.HistorySearch;

import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public interface HistorySearchDao {

    HistorySearch create(HistorySearch historySearch) throws DataBaseException;
    Optional<HistorySearch> getById(long id) throws DataBaseException;
    List<HistorySearch> getAll() throws DataBaseException;
    void update(HistorySearch historySearch) throws DataBaseException;
    void delete(long id) throws DataBaseException;

}
