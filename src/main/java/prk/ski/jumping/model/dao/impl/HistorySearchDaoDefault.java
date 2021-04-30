package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.domain.HistorySearch;

import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class HistorySearchDaoDefault implements HistorySearchDao {


    @Override
    public HistorySearch create(HistorySearch historySearch) throws DataBaseException {
        return null;
    }

    @Override
    public Optional<HistorySearch> getById(long id) throws DataBaseException {
        return Optional.empty();
    }

    @Override
    public List<HistorySearch> getAll() throws DataBaseException {
        return null;
    }

    @Override
    public void update(HistorySearch historySearch) throws DataBaseException {

    }

    @Override
    public void delete(long id) throws DataBaseException {

    }
}
