package com.revature.dao;

import java.util.List;

import com.revature.models.PcEntry;
import com.revature.models.Pokemon;

public interface PcEntryDaoInterface {

	public List<PcEntry> getPc(); // returns a list of the pokemon in the pc
	
	public void addPokemon(Pokemon p); // add a pokemon to the pc
	
	public void releasePokemon(int id); // releases a pokemon from the pc
}
