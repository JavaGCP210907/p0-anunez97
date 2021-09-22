package com.revature.models;

public class PcEntry {
	
	private int pc_id;
	private String pokemonName;
	
	public PcEntry(int pc_id, String pokemon_name) {
		super();
		this.pc_id = pc_id;
		this.pokemonName = pokemon_name;
	}

	@Override
	public String toString() {
		return "PC ID: " + pc_id + " | Name: " + pokemonName;
	}

	public int getPc_id() {
		return pc_id;
	}

	public void setPc_id(int pc_id) {
		this.pc_id = pc_id;
	}

	public String getPokemonName() {
		return pokemonName;
	}

	public void setPokemon_name(String pokemon_name) {
		this.pokemonName = pokemon_name;
	}
	
	
}
