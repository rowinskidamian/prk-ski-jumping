package prk.ski.jumping.model.dao;

import java.util.List;

import prk.ski.jumping.model.domain.Country;

public interface CountryDao {
	
	public void create(Country country);
	public Country getById(long id);
	public List<Country> getAll();
	public void update(Country country, long id);
	public void delete(Country country, long id);	

}
