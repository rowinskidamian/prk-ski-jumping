package prk.ski.jumping.model.domain.memory;

import prk.ski.jumping.model.domain.HistorySearch;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author DamianRowinski
 */

public class HistorySearchDB {

    private static long currentDbIndex = 0;
    private static HashMap<Long, HistorySearch> database;

    public HistorySearchDB() {
        if (database == null) database = new HashMap<>();
    }

    public HistorySearch create(HistorySearch historySearch) {
        historySearch.setId(currentDbIndex);
        database.put(currentDbIndex, historySearch);
        currentDbIndex++;
        return historySearch;
    }

    public Optional<HistorySearch> getById(long id) {
        boolean isPresent = database.containsKey(id);
        return isPresent ? Optional.of(database.get(id)) : Optional.empty();
    }

    public List<HistorySearch> getAll() {
        return database.keySet().stream()
                .map(database::get)
                .collect(Collectors.toList());
    }

    public void update(HistorySearch historySearch) {
        Optional<HistorySearch> optionalResult = getById(historySearch.getId());
        optionalResult.orElseThrow(() -> new NoSuchElementException("Brak rekordu w bazie o podanym id."));
        database.put(historySearch.getId(), historySearch);
    }

    public void delete(long id) {
        Optional<HistorySearch> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("Brak rekordu w bazie o podanym id."));
        database.remove(id);
    }

}
