package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.PokemonType;
import com.revature.utils.ConnectionUtil;

public class PokemonTypeDao implements PokemonTypeDaoInterface{

	@Override
	public List<PokemonType> getTypes() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pokemon_types";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<PokemonType> types = new ArrayList<>();
			
			while (rs.next()) {
				PokemonType pt = new PokemonType(
						rs.getInt("type_id"),
						rs.getString("name")
						);
				types.add(pt);
			}
			
			return types;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong in displaying your pokedex!");
			e.printStackTrace();
		}
		
		return null;
	}

}
