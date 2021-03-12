package prk.ski.jumping.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class HistorySearchDB {

    private static long currentDbIndex = 0;
    private static HashMap<Long, TournamentJumperResult> database;

    public HistorySearchDB() {
        if (database == null) database = new HashMap<>();
    }

    public void create(TournamentJumperResult tjr) {
        tjr.setDatabaseId(currentDbIndex);
        database.put(currentDbIndex, tjr);
        currentDbIndex++;
    }

    public Optional<TournamentJumperResult> getById(long id) {
        boolean isPresent = database.containsKey(id);
        return isPresent ? Optional.of(database.get(id)) : Optional.empty();
    }

    public List<TournamentJumperResult> getAll() {
        return database.keySet().stream()
                .map(database::get)
                .collect(Collectors.toList());
    }

    public void update(TournamentJumperResult tjr, long id) {
        Optional<TournamentJumperResult> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.put(id, tjr);
    }

    public void delete(TournamentJumperResult tjr, long id) {
        Optional<TournamentJumperResult> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.remove(id, tjr);
    }

}
