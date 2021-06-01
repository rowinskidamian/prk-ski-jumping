package prk.ski.jumping.model.dao.impl;

import java.util.List;
import java.util.Optional;

import prk.ski.jumping.model.dao.CountryDao;
import prk.ski.jumping.model.domain.Country;
import prk.ski.jumping.model.domain.memory.CountryDB;

/**
 * @author RadosławParol
 */

public class CountryDaoDefault implements CountryDao {

	private CountryDB countryDB;

	public CountryDaoDefault() {
		countryDB = new CountryDB();
	}

	@Override
	public void create(Country country) { countryDB.create(country); }
	@Override
	public Optional<Country> getById(long id) { return countryDB.getById(id); }
	@Override
	public List<Country> getAll() { return countryDB.getAll();}
	@Override
	public void update(Country country, long id) { countryDB.update(country, id);}
	@Override
	public void delete(Country country, long id) { countryDB.delete(country, id);}

}
