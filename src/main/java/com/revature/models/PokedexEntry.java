package com.revature.models;

public class PokedexEntry {
	
	private int pokedex_id;
	private String name;
	private String type1;
	private String type2;
	private int seenCount;
	private int caughtCount;
	
	public PokedexEntry(int pokedex_id, String name, String type1, String type2, int seenCount, int caughtCount) {
		super();
		this.pokedex_id = pokedex_id;
		this.name = name;
		this.type1 = type1;
		this.type2 = type2;
		this.seenCount = seenCount;
		this.caughtCount = caughtCount;
	}
	
	@Override
	public String toString() {
		String base = "Pokedex Number: " + pokedex_id + " | Name: " + name + " | Type: " + type1;
		
		// if the second type is not null, add the second type to the string
		if(type2 != null) {
			base = base + "/" + type2;
		}
		
		base = base + " | Seen: " + seenCount + " | Caught:" + caughtCount;
		
		return base;
	}

	public int getPokedex_id() {
		return pokedex_id;
	}

	public void setPokedex_id(int pokedex_id) {
		this.pokedex_id = pokedex_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType1() {
		return type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public int getSeenCount() {
		return seenCount;
	}

	public void setSeenCount(int seenCount) {
		this.seenCount = seenCount;
	}

	public int getCaughtCount() {
		return caughtCount;
	}

	public void setCaughtCount(int caughtCount) {
		this.caughtCount = caughtCount;
	}
}
