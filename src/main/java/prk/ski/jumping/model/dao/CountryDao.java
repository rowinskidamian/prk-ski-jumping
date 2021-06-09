package prk.ski.jumping.model.dao;

import java.util.List;
import java.util.Optional;

import prk.ski.jumping.model.domain.Country;

/**
 * @author RadosławParol
 */

public interface CountryDao {
	
	void create(Country country);
	Optional<Country> getById(long id);
	List<Country> getAll();
	void update(Country country, long id);
	void delete(Country country, long id);

}
