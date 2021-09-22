package com.revature.dao;

import java.util.List;

import com.revature.models.PokemonType;

public interface PokemonTypeDaoInterface {

	List<PokemonType> getTypes(); // returns a list of all types with their id
}
