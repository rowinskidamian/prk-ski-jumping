package prk.ski.jumping.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

public class CountryDB {

    private static long currentDbIndex = 0;
    private static HashMap<Long, Country> database;

    public CountryDB() { if (database == null) database = new HashMap<>(); }

    public void create(Country country) {
        country.setId(currentDbIndex);
        database.put(currentDbIndex, country);
        currentDbIndex++;
    }

    public Optional<Country> getById(long id) {
        boolean isPresent = database.containsKey(id);
        return isPresent ? Optional.of(database.get(id)) : Optional.empty();
    }

    public List<Country> getAll() {
        return database.keySet().stream()
                .map(database::get)
                .collect(Collectors.toList());
    }

    public void update(Country country, long id) {
        Optional<Country> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.put(id, country);
    }

    public void delete(Country country, long id) {
        Optional<Country> optionalResult = getById(id);
        optionalResult.orElseThrow(() -> new NoSuchElementException("There is no record for given id."));
        database.remove(id, country);
    }
}
