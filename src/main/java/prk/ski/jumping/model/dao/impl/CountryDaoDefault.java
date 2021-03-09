package main.java.prk.ski.jumping.model.dao.impl;

import java.util.List;

import main.java.prk.ski.jumping.model.dao.CountryDao;
import main.java.prk.ski.jumping.model.domain.Country;
import main.java.prk.ski.jumping.model.domain.CountryDB;

public class CountryDaoDefault implements CountryDao {
	
	private CountryDB countryDB;

	@Override
	public void create(Country country) {
//		countryDB.create(country);
	}

	@Override
	public Country getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Country country, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Country country, long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Country> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
