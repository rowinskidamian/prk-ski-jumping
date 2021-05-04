package prk.ski.jumping.model.dao.impl.memory;

import prk.ski.jumping.exception.DataBaseException;
import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.domain.HistorySearch;
import prk.ski.jumping.model.domain.memory.HistorySearchDB;

import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class HistorySearchDaoMemory implements HistorySearchDao {

    private HistorySearchDB historySearchDB;

    public HistorySearchDaoMemory() {
        historySearchDB = new HistorySearchDB();
    }

    @Override
    public HistorySearch create(HistorySearch historySearch) throws DataBaseException {
        return historySearchDB.create(historySearch);
    }

    @Override
    public Optional<HistorySearch> getById(long id) throws DataBaseException {
        return historySearchDB.getById(id);
    }

    @Override
    public List<HistorySearch> getAll() throws DataBaseException {
        return historySearchDB.getAll();
    }

    @Override
    public void update(HistorySearch historySearch) throws DataBaseException {
        historySearchDB.update(historySearch);
    }

    @Override
    public void delete(long id) throws DataBaseException {
        historySearchDB.delete(id);
    }

}
