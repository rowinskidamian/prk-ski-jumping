package prk.ski.jumping.model.dao.impl;

import prk.ski.jumping.model.dao.HistorySearchDao;
import prk.ski.jumping.model.domain.HistorySearch;
import prk.ski.jumping.model.domain.HistorySearchDB;

import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public class HistorySearchDaoDefault implements HistorySearchDao {

    private HistorySearchDB historySearchDB;

    public HistorySearchDaoDefault() {
        historySearchDB = new HistorySearchDB();
    }

    @Override
    public void create(HistorySearch historySearch) {
        historySearchDB.create(historySearch);
    }

    @Override
    public Optional<HistorySearch> getById(long id) {
        return historySearchDB.getById(id);
    }

    @Override
    public List<HistorySearch> getAll() {
        return historySearchDB.getAll();
    }

    @Override
    public void update(HistorySearch historySearch, long id) {
        historySearchDB.update(historySearch, id);
    }

    @Override
    public void delete(HistorySearch historySearch, long id) {
        historySearchDB.delete(historySearch, id);
    }

}
