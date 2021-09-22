package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.PokedexEntryDao;

public class Menu {
	
	private boolean display = true;
	PokedexEntryDao pokedexDao = new PokedexEntryDao();
	
	// displays the menu
	public void displayMenu() {
		
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("===========================================");
		System.out.println("Pokedex powering on ... Welcome!");
		System.out.println("===========================================");
		
		while(display) {
			System.out.println("CHOOSE AN OPTION: ");
			
			// options
			System.out.println("pokedex -> get a list of all recorded pokemon");
			System.out.println("pokedexPage -> get a page from the pokedex");
			System.out.println("encounterPokemon -> encounter a wild pokemon");
			System.out.println("caughtPokemon -> get a list of caught pokemon");
			System.out.println("seenPokemon -> get a list of seen pokemon");
			System.out.println("pokemonByType -> get a list of all caught pokemon by type");
			System.out.println("pokemonByTypes -> get a list of all caught pokemon by types");
			System.out.println("pc -> get a list of the pokemon in your pc");
			System.out.println("releasePokemon -> release a pokemon from your pc");
			System.out.println("exit -> exit application");
			
			String input = scan.nextLine();
			
			selectMenuOption(input);
		}
		scan.close();
		System.out.println("Pokedex powering off ...");
	}
	
	private void selectMenuOption(String input) {
		switch(input) {
		case "pokedex":
			List<PokedexEntry> pokedex = pokedexDao.getPokedex();
			
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
			}
			break;
		case "pokedexPage":
			break;
		case "encounterPokemon":
			break;
		case "caughtPokemon":
			break;
		case "seenPokemon":
			break;
		case "pokemonByType":
			break;
		case "pokemonByTypes":
			break;
		case "pc":
			break;
		case "releasePokemon":
			break;
		case "exit":
			display = false;
			break;
		default:
			System.out.println("I didn't get that, try again ...");
			break;
		}
	}
}
