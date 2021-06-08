package prk.ski.jumping.model.domain.memory;

import prk.ski.jumping.model.domain.Jumper;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author RadosławParol
 */

public class JumperDB {
    private static long currentDbIndex = 0;
    private static HashMap<Long, Jumper> database;

    public JumperDB() { if (database == null) database = new HashMap<>(); }

    public void create(Jumper jumper) {
        jumper.setId(currentDbIndex);
        database.put(currentDbIndex, jumper);
        currentDbIndex++;
    }

    public Optional<Jumper> getById(long id) {
        boolean isPresent = database.containsKey(id);
        return isPresent ? Optional.of(database.get(id)) : Optional.empty();
    }

    public List<Jumper> getAll() {
        return database.keySet().stream()
                .map(database::get)
                .collect(Collectors.toList());
    }

    public void update(Jumper jumper, long id) {
        Optional<Jumper> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.put(id, jumper);
    }

    public void delete(Jumper jumper, long id) {
        Optional<Jumper> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.remove(id, jumper);
    }
}
