package prk.ski.jumping.model.domain.memory;

import prk.ski.jumping.model.domain.TournamentWorldCup;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RadosławParol
 */

public class TournamentWorldCupDB {
    private static long currentDbIndex = 0;
    private static HashMap<Long, TournamentWorldCup> database;

    public TournamentWorldCupDB() { if (database == null) database = new HashMap<>(); }

    public void create(TournamentWorldCup cup) {
        cup.setId(currentDbIndex);
        database.put(currentDbIndex, cup);
        currentDbIndex++;
    }

    public Optional<TournamentWorldCup> getById(long id) {
        boolean isPresent = database.containsKey(id);
        return isPresent ? Optional.of(database.get(id)) : Optional.empty();
    }

    public List<TournamentWorldCup> getAll() {
        return database.keySet().stream()
                .map(database::get)
                .collect(Collectors.toList());
    }

    public void update(TournamentWorldCup cup, long id) {
        Optional<TournamentWorldCup> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.put(id, cup);
    }

    public void delete(TournamentWorldCup cup, long id) {
        Optional<TournamentWorldCup> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.remove(id, cup);
    }
}
