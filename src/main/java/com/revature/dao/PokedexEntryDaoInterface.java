package com.revature.dao;

import java.util.List;

import com.revature.models.PokedexEntry;
import com.revature.models.Pokemon;

public interface PokedexEntryDaoInterface {
	
	public List<PokedexEntry> getPokedex(); //returns a List of all pokedex entries (select *)
	
	public List<PokedexEntry> getPokedexPage(int pagenum); //this will get pokedex entries within a range (10 * pagenum - 10 * pagenum + 10)
	
	public List<PokedexEntry> getSeenPokemon(); // returns a list of seen pokemon
	
	public List<PokedexEntry> getCaughtPokemon(); // returns a list of caught pokemon
	
	public List<PokedexEntry> getPokemonByType(String type); // returns a list of pokemon that have the given types
	
	public List<PokedexEntry> getPokemonByTypes(String type1, String type2); // returns a list of Pokemon that have both given types
	
	public void seenPokemon(Pokemon p); // updates the pokedex to record the seen pokemon
	
	public void caughtPokemon(Pokemon p); // updates the pokedex to record the caught pokemon
}
