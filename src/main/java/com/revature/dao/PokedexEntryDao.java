package com.revature.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.PokedexEntry;
import com.revature.utils.ConnectionUtil;

public class PokedexEntryDao implements PokedexEntryDaoInterface{
	
	@Override
	public List<PokedexEntry> getPokedex() {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pokedex order by pokedex_id";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<PokedexEntry> pokedex = new ArrayList();
			
			while (rs.next()) {
				PokedexEntry pe = new PokedexEntry(
						rs.getInt("pokedex_id"),
						rs.getString("pokemon_name"),
						rs.getString("type_1_name"),
					    rs.getString("type_2_name"),
					    rs.getInt("seen"),
					    rs.getInt("caught")
						);
				pokedex.add(pe);
			}
			
			return pokedex;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong in displaying your pokedex!");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<PokedexEntry> getPokedexPage(int pagenum) {
		// TODO Auto-generated method stub
		return null;
	}
}
