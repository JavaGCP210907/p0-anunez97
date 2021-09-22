package com.revature.models;

public class PokemonType {
	private int type_id;
	private String name;
	
	public PokemonType(int type_id, String name) {
		super();
		this.type_id = type_id;
		this.name = name;
	}

	public int getType_id() {
		return type_id;
	}

	public void setType_id(int type_id) {
		this.type_id = type_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pokemon Type ID: " + type_id + "| Name:" + name;
	}
	
	
}
