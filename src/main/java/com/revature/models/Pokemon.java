package com.revature.models;

public class Pokemon {
	private String name;
	private int pokedex_id;
	private int type1Id;
	private int type2Id;
	

	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", pokedex_id=" + pokedex_id + ", type1Id=" + type1Id + ", type2Id=" + type2Id
				+ "]";
	}

	public Pokemon(String name, int pokedex_id, int type1Id, int type2Id) {
		super();
		this.name = name;
		this.pokedex_id = pokedex_id;
		this.type1Id = type1Id;
		this.type2Id = type2Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPokedex_id() {
		return pokedex_id;
	}

	public void setPokedex_id(int pokedex_id) {
		this.pokedex_id = pokedex_id;
	}

	public int getType1Id() {
		return type1Id;
	}

	public void setType1Id(int type1Id) {
		this.type1Id = type1Id;
	}

	public int getType2Id() {
		return type2Id;
	}

	public void setType2Id(int type2Id) {
		this.type2Id = type2Id;
	}
	
	
}
