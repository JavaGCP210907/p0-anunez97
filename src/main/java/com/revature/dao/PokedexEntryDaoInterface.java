package com.revature.dao;

import java.util.List;

import com.revature.models.PokedexEntry;

public interface PokedexEntryDaoInterface {
	
	public List<PokedexEntry> getPokedex(); //returns a List of all pokedex entries (select *)
	
	public List<PokedexEntry> getPokedexPage(int pagenum); //this will get pokedex entries within a range (10 * pagenum - 10 * pagenum + 10)
}
