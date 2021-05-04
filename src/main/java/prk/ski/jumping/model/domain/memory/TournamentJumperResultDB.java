package prk.ski.jumping.model.domain.memory;

import prk.ski.jumping.model.domain.TournamentJumperResult;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author DamianRowinski
 */

public class TournamentJumperResultDB {

    private static long currentDbIndex = 0;
    private static HashMap<Long, TournamentJumperResult> database;

    public TournamentJumperResultDB() {
        if(database == null) database = new HashMap<>();
    }

    public TournamentJumperResult create(TournamentJumperResult tjr) {
        tjr.setId(currentDbIndex);
        database.put(currentDbIndex, tjr);
        currentDbIndex++;
        return tjr;
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

    public void update(TournamentJumperResult tjr) {
        Optional<TournamentJumperResult> optionalResult = getById(tjr.getId());
        optionalResult.orElseThrow(() -> new NoSuchElementException
                ("Nie można usunąć z bazy. Nie ma rekordu o podanym id."));
        database.put(tjr.getId(), tjr);
    }

    public void delete(long id) {
        Optional<TournamentJumperResult> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException
                ("Nie można usunąć z bazy. Nie ma rekordu o podanym id."));
        database.remove(id);
    }

}
