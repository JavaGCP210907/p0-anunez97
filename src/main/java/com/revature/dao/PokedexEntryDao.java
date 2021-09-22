package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.PokedexEntry;
import com.revature.utils.ConnectionUtil;

public class PokedexEntryDao implements PokedexEntryDaoInterface{
	
	private int entriesPerPage = 10;
	
	@Override
	public List<PokedexEntry> getPokedex() {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pokedex order by pokedex_id";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<PokedexEntry> pokedex = new ArrayList<>();
			
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
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pokedex order by pokedex_id limit 10 offset ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			// set pagenum in prepared statement
			ps.setInt(1, pagenum * entriesPerPage);
			
			rs = ps.executeQuery();
			
			List<PokedexEntry> pokedex = new ArrayList<>();
			
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
			System.out.println("Something went wrong in displaying the pokedex page!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PokedexEntry> getSeenPokemon() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pokedex where seen > 0 order by pokedex_id";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<PokedexEntry> pokedex = new ArrayList<>();
			
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
			System.out.println("Something went wrong in displaying the seen pokemon!");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<PokedexEntry> getCaughtPokemon() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pokedex where caught > 0 order by pokedex_id";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<PokedexEntry> pokedex = new ArrayList<>();
			
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
			System.out.println("Something went wrong in displaying the caught pokemon!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PokedexEntry> getPokemonByType(String type) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pokedex where type_1_name = ? or type_2_name = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			StringBuilder t = new StringBuilder(type.toLowerCase());
			
			t.replace(0, 1, (type.toUpperCase().substring(0, 1)));
			
			ps.setString(1, t.toString());
			ps.setString(2, t.toString());
			
			rs = ps.executeQuery();
			
			List<PokedexEntry> pokedex = new ArrayList<>();
			
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
			
			System.out.println(t.toString() + " Pokemon: ");
			
			return pokedex;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong in displaying the pokemon by type!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PokedexEntry> getPokemonByTypes(String type1, String type2) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;

			String sql = "select * from pokedex where (type_1_name = ? or type_2_name = ?) and (type_1_name = ? or type_2_name = ?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			StringBuilder t1 = new StringBuilder(type1.toLowerCase());
			StringBuilder t2 = new StringBuilder(type2.toLowerCase());
			
			t1.replace(0, 1, (type1.toUpperCase().substring(0, 1)));
			t2.replace(0, 1, (type2.toUpperCase().substring(0, 1)));
			
			ps.setString(1, t1.toString());
			ps.setString(2, t1.toString());
			
			// type 1
			ps.setString(3, t2.toString());
			ps.setString(4, t2.toString());
			
			rs = ps.executeQuery();
			
			List<PokedexEntry> pokedex = new ArrayList<>();
			
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
			
			System.out.println(t1.toString() + "/" + t2.toString() + " Pokemon: ");
			
			return pokedex;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong in displaying the pokemon by types!");
			e.printStackTrace();
		}
		return null;
	}
}
