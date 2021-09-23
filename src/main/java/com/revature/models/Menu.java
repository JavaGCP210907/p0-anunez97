package com.revature.models;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.dao.PcEntryDao;
import com.revature.dao.PokedexEntryDao;
import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonTypeDao;

public class Menu {
	
	private boolean display = true;
	private boolean encounter = false;
	
	// Dao objects
	PokedexEntryDao pokedexDao = new PokedexEntryDao();
	PokemonTypeDao typeDao = new PokemonTypeDao();
	PcEntryDao pcDao = new PcEntryDao();
	PokemonDao pDao = new PokemonDao();
	
	Scanner scan = new Scanner(System.in);
	Logger log = LogManager.getLogger(Menu.class);
	
	// displays the menu
	public void displayMenu() {
		
		System.out.println("===========================================");
		System.out.println("POKEDEX POWERING ON ... WELCOME!");
		System.out.println("===========================================");
		
		while(display) {
			System.out.println("CHOOSE AN OPTION: \n");
			
			// options
			System.out.println("pokedex -> GET A LIST OF ALL POKEDEX RECORDS");
			System.out.println("pokedexPage -> GET A PAGE OF 10 ENTRIES FROM YOUR POKEDEX");
			System.out.println("encounterPokemon -> ENCOUNTER A WILD POKEMON"); 
			System.out.println("caughtPokemon -> GET A LIST OF CAUGHT POKEMON");
			System.out.println("seenPokemon -> GET A LIST OF SEEN POKEMON");
			System.out.println("pokemonByType -> GET A LIST OF CAUGHT POKEMON BY TYPE");
			System.out.println("pokemonByTypes -> GET A LIST OF CAUGHT POKEMON BY TWO TYPES");
			System.out.println("types -> GET A LIST OF ALL POKEMON TYPES");
			System.out.println("pc -> GET A LIST OF POKEMON IN YOUR PC");
			System.out.println("releasePokemon -> RELEASE A POKEMON FROM YOUR PC");
			System.out.println("exit -> EXIT POKEDEX");
			
			String input = scan.nextLine();
			
			selectMenuOption(input);
		}
		scan.close();
		System.out.println("POKEDEX POWERING OFF ...");
	}
	
	// parse the menu input
	private void selectMenuOption(String input) {
		List<PokedexEntry> pokedex;
		List<PokemonType> types;
		List<PcEntry> pc;
		Pokemon poke;
		
		int i = 0; // used for adding line breaks when displaying lists
		
		switch(input) {
		case "pokedex":
			pokedex = pokedexDao.getPokedex();
			
			System.out.println("======================================================================================");
			System.out.println("POKEDEX: ");
			
			i = 0;
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
				
				i++;
				
				// adds a line break every 10 entries (hopefully a little easier on the eyes)
				if(i % 10 == 0) {
					System.out.println("");
					i = 0;
				}
				
			}
			
			System.out.println("======================================================================================");
			System.out.println("");
			
			log.info("USER RETRIEVED LIST OF POKEDEX RECORDS");
			
			break;
		case "pokedexPage":
			System.out.println("======================================================================================");
			System.out.println("WHAT PAGE DO YOU WANT TO SEE? (1 - 16)");
			
			int page = scan.nextInt();
			scan.nextLine();
			
			pokedex = pokedexDao.getPokedexPage(page);
			
			System.out.println("PAGE " + page + ":");
			
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
			}
			System.out.println("======================================================================================");
			System.out.println("");
			
			log.info("USER RETRIEVED POKEDEX PAGE");
			
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
			
			System.out.println("CAUGHT POKEMON: ");
			i = 0;
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
				
				i++;
				// adds a line break every 10 entries (hopefully a little easier on the eyes)
				if(i % 10 == 0) {
					System.out.println("");
					i = 0;
				}
			}
			System.out.println("======================================================================================");
			break;
		case "seenPokemon":
			System.out.println("======================================================================================");
			
			pokedex = pokedexDao.getSeenPokemon();
			
			System.out.println("Seen Pokemon: ");
			
			i = 0;
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
				
				i++;
				// adds a line break every 10 entries (hopefully a little easier on the eyes)
				if(i % 10 == 0) {
					System.out.println("");
					i = 0;
				}
			}
			
			System.out.println("======================================================================================");
			
			break;
		case "pokemonByType":
			System.out.println("WHICH TYPE?");
			
			String type = scan.nextLine();
			
			System.out.println("======================================================================================");
			
			pokedex = pokedexDao.getPokemonByType(type);
			
			i = 0;
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
				
				i++;
				// adds a line break every 10 entries (hopefully a little easier on the eyes)
				if(i % 10 == 0) {
					System.out.println("");
					i = 0;
				}
			}
			
			System.out.println("======================================================================================");
			System.out.println("");
			
			break;
		case "pokemonByTypes":
			System.out.println("WHAT IS THE NAME OF THE FIRST TYPE?");
			String type1 = scan.nextLine();
			
			System.out.println("WHAT IS THE NAME OF THE SECOND TYPE?");
			String type2 = scan.nextLine();
			
			System.out.println("======================================================================================");
			
			pokedex = pokedexDao.getPokemonByTypes(type1, type2);
			
			i = 0;
			for(PokedexEntry p : pokedex) {
				System.out.println(p);
				
				i++;
				// adds a line break every 10 entries (hopefully a little easier on the eyes)
				if(i % 10 == 0) {
					System.out.println("");
					i = 0;
				}
			}
			
			System.out.println("======================================================================================");
			System.out.println("");
			
			break;
		case "types":
			System.out.println("======================================================================================");
			System.out.println("TYPES:");
			
			types = typeDao.getTypes();
			
			for(PokemonType t : types) {
				System.out.println(t.toString());
			}
			
			System.out.println("======================================================================================");
			System.out.println("");
			
			break;
		case "pc":
			System.out.println("======================================================================================");
			System.out.println("YOUR PC: ");
			
			pc = pcDao.getPc();
			
			i = 0;
			for(PcEntry p : pc) {
				System.out.println(p);
				
				i++;
				// adds a line break every 10 entries (hopefully a little easier on the eyes)
				if(i % 10 == 0) {
					System.out.println("");
					i = 0;
				}
			}
			
			System.out.println("======================================================================================");
			System.out.println("");
			
			log.info("USER ACCESSED THEIR PC");
			
			break;
		case "releasePokemon":
			System.out.println("======================================================================================");
			
			pc = pcDao.getPc();
			
			for(PcEntry p : pc) {
				System.out.println(p);
			}
			
			System.out.println("WHAT IS THE ID OF THE POKEMON YOU WANT TO RELEASE?");
			int id = scan.nextInt();
			scan.nextLine();
			
			System.out.println("======================================================================================");
			
			pcDao.releasePokemon(id);
			
			System.out.println("======================================================================================");
			System.out.println("");
			
			log.warn("USER RELEASED A POKEMON");
			
			break;
		case "exit":
			display = false;
			break;
		default:
			System.out.println("I DIDN'T GET THAT, TRY AGAIN ...");
			break;
		}
	}
	
	private void selectEncounterOption(Pokemon poke) {
		
		encounter = true;
		while (encounter) {
			System.out.println("YOU ENCOUNTERED A WILD " + poke.getName() + "!");
			System.out.println("WHAT DO YOU WANT TO DO?");
			System.out.println("throwPokeball -> TRY TO CATCH THE POKEMON");
			System.out.println("run -> RUN AWAY");
			
			String action = scan.nextLine();
			
			switch(action) {
			case "throwPokeball":
				pcDao.addPokemon(poke);
				pokedexDao.caughtPokemon(poke);
				
				encounter = false;
				
				log.info("USER CAUGHT A POKEMON");
				break;
			case "run":
				pokedexDao.seenPokemon(poke);
				encounter = false;
				
				break;
			default:
				System.out.println("I DIDN'T GET THAT, TRY AGAIN ...");
				break;
			}
		}
	}
}
