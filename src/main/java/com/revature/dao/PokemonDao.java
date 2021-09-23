package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.PcEntry;
import com.revature.models.PokedexEntry;
import com.revature.models.Pokemon;
import com.revature.utils.ConnectionUtil;

public class PokemonDao implements PokemonDaoInterface {

	@Override
	public Pokemon getRandomPokemon() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pokemon order by random() limit 1";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<Pokemon> p = new ArrayList<>();
			
			while (rs.next()) {
				Pokemon poke = new Pokemon(
						rs.getString("name"),
						rs.getInt("pokedex_id_fk"),
						rs.getInt("type_1_id_fk"),
						rs.getInt("type_2_id_fk")
						);
				p.add(poke);
			}
			
			return p.get(0);
		}
		catch (SQLException e) {
			System.out.println("Something went wrong in finding a wild pokemon!");
			e.printStackTrace();
		}
		return null;
	}

}
