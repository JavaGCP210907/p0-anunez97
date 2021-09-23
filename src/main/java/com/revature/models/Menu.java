package com.revature.models;

import java.util.List;
import java.util.Scanner;

import com.revature.dao.PcEntryDao;
import com.revature.dao.PokedexEntryDao;
import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonTypeDao;

public class Menu {
	
	private boolean display = true;
	private boolean encounter = false;
	
	PokedexEntryDao pokedexDao = new PokedexEntryDao();
	PokemonTypeDao typeDao = new PokemonTypeDao();
	PcEntryDao pcDao = new PcEntryDao();
	PokemonDao pDao = new PokemonDao();
	
	Scanner scan = new Scanner(System.in);
	
	// displays the menu
	public void displayMenu() {
		
		
		System.out.println("===========================================");
		System.out.println("Pokedex powering on ... Welcome!");
		System.out.println("===========================================");
		
		while(display) {
			System.out.println("CHOOSE AN OPTION: ");
			
			// options
			System.out.println("pokedex -> get a list of all pokedex records"); // done
			System.out.println("pokedexPage -> get a page from the pokedex"); // done
			System.out.println("encounterPokemon -> encounter a wild pokemon"); 
			System.out.println("caughtPokemon -> get a list of caught pokemon"); // done
			System.out.println("seenPokemon -> get a list of seen pokemon"); // done
			System.out.println("pokemonByType -> get a list of all caught pokemon by type"); // done
			System.out.println("pokemonByTypes -> get a list of all caught pokemon by types"); // done
			System.out.println("types -> get a list of all pokemon types"); // done
			System.out.println("pc -> get a list of the pokemon in your pc"); // done
			System.out.println("releasePokemon -> release a pokemon from your pc"); // done
			System.out.println("exit -> exit application"); // done
			
			String input = scan.nextLine();
			
			selectMenuOption(input);
		}
		scan.close();
		System.out.println("Pokedex powering off ...");
	}
	
	private void selectMenuOption(String input) {
		List<PokedexEntry> pokedex;
		List<PokemonType> types;
		List<PcEntry> pc;
		Pokemon poke;
		
		switch(input) {
		case "pokedex":
			pokedex = pokedexDao.getPokedex();
			
			System.out.println("======================================================================================");
			System.out.println("Pokedex: ");
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
			}
			System.out.println("======================================================================================");
			System.out.println("");
			
			break;
		case "pokedexPage":
			System.out.println("======================================================================================");
			System.out.println("What page do you want to see? (1 - 16)");
			int page = scan.nextInt();
			scan.nextLine();
			
			pokedex = pokedexDao.getPokedexPage(page);
			
			System.out.println("Page " + page + ":");
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
			}
			System.out.println("======================================================================================");
			System.out.println("");
			
			break;
		case "encounterPokemon":
			System.out.println("======================================================================================");
			poke = pDao.getRandomPokemon();
			
			selectEncounterOption(poke);
			System.out.println("======================================================================================");
			System.out.println("");
			break;
		case "caughtPokemon":
			System.out.println("======================================================================================");
			pokedex = pokedexDao.getCaughtPokemon();
			
			System.out.println("Caught Pokemon: ");
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
			}
			System.out.println("======================================================================================");
			break;
		case "seenPokemon":
			System.out.println("======================================================================================");
			pokedex = pokedexDao.getSeenPokemon();
			
			System.out.println("Seen Pokemon: ");
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
			}
			System.out.println("======================================================================================");
			
			break;
		case "pokemonByType":
			System.out.println("Which type?");
			String type = scan.nextLine();
			
			System.out.println("======================================================================================");
			
			pokedex = pokedexDao.getPokemonByType(type);
			
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
			}
			System.out.println("======================================================================================");
			System.out.println("");
			break;
		case "pokemonByTypes":
			System.out.println("What is the name of the first type?");
			String type1 = scan.nextLine();
			
			System.out.println("What is the name of the second type?");
			String type2 = scan.nextLine();
			
			System.out.println("======================================================================================");
			pokedex = pokedexDao.getPokemonByTypes(type1, type2);
			
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
			}
			System.out.println("======================================================================================");
			System.out.println("");
			break;
		case "types":
			System.out.println("======================================================================================");
			System.out.println("Types:");
			types = typeDao.getTypes();
			
			for(PokemonType t : types) {
				System.out.println(t.toString());
			}
			
			System.out.println("======================================================================================");
			System.out.println("");
			break;
		case "pc":
			System.out.println("======================================================================================");
			System.out.println("Your PC: ");
			pc = pcDao.getPc();
			
			for(PcEntry p : pc) {
				System.out.println(p);
			}
			
			System.out.println("======================================================================================");
			System.out.println("");
			break;
		case "releasePokemon":
			System.out.println("======================================================================================");
			pc = pcDao.getPc();
			
			for(PcEntry p : pc) {
				System.out.println(p);
			}
			
			System.out.println("What is the id of the pokemon you want to release?");
			int id = scan.nextInt();
			scan.nextLine();
			
			System.out.println("======================================================================================");
			
			pcDao.releasePokemon(id);
			
			System.out.println("======================================================================================");
			System.out.println("");
			break;
		case "exit":
			display = false;
			break;
		default:
			System.out.println("I didn't get that, try again ...");
			break;
		}
	}
	
	private void selectEncounterOption(Pokemon poke) {
		
		encounter = true;
		while (encounter) {
			System.out.println("You encountered a wild " + poke.getName() + "!");
			System.out.println("What do you want to do?");
			System.out.println("throwPokeball -> try to catch the pokemon");
			System.out.println("run -> run away");
			
			String action = scan.nextLine();
			
			switch(action) {
			case "throwPokeball":
				pcDao.addPokemon(poke);
				pokedexDao.caughtPokemon(poke);
				
				encounter = false;
				break;
			case "run":
				pokedexDao.seenPokemon(poke);
				encounter = false;
				break;
			default:
				System.out.println("I didn't get that, try again ...");
				break;
			}
		}
	}
}
