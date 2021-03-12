package prk.ski.jumping.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class HistorySearchDB {

    private static long currentDbIndex = 0;
    private static HashMap<Long, HistorySearch> database;

    public HistorySearchDB() {
        if (database == null) database = new HashMap<>();
    }

    public void create(HistorySearch historySearch) {
        historySearch.setId(currentDbIndex);
        database.put(currentDbIndex, historySearch);
        currentDbIndex++;
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

    public void update(HistorySearch historySearch, long id) {
        Optional<HistorySearch> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.put(id, historySearch);
    }

    public void delete(HistorySearch historySearch, long id) {
        Optional<HistorySearch> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.remove(id, historySearch);
    }

}
