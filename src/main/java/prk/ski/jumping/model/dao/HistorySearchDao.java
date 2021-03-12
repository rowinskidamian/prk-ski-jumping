package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.HistorySearch;

import java.util.List;
import java.util.Optional;

public interface HistorySearchDao {

    public void create(HistorySearch historySearch);
    public Optional<HistorySearch> getById(long id);
    public List<HistorySearch> getAll();
    public void update(HistorySearch historySearch, long id);
    public void delete(HistorySearch historySearch, long id);

}
