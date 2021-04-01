package prk.ski.jumping.model.dao;

import prk.ski.jumping.model.domain.HistorySearch;

import java.util.List;
import java.util.Optional;

/**
 * @author DamianRowinski
 */

public interface HistorySearchDao {

    void create(HistorySearch historySearch);
    Optional<HistorySearch> getById(long id);
    List<HistorySearch> getAll();
    void update(HistorySearch historySearch, long id);
    void delete(HistorySearch historySearch, long id);

}
