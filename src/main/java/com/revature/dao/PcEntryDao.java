package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.PcEntry;
import com.revature.models.Pokemon;
import com.revature.utils.ConnectionUtil;

public class PcEntryDao implements PcEntryDaoInterface{

	@Override
	public List<PcEntry> getPc() {
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "select * from pc_pokemon";
			
			Statement s = conn.createStatement();
			
			rs = s.executeQuery(sql);
			
			List<PcEntry> pc = new ArrayList<>();
			
			while (rs.next()) {
				PcEntry pt = new PcEntry(
						rs.getInt("pc_id"),
						rs.getString("pokemon_name_fk")
						);
				pc.add(pt);
			}
			
			return pc;
		}
		catch (SQLException e) {
			System.out.println("Something went wrong in displaying your pc!".toUpperCase());
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void releasePokemon(int id) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			ResultSet rs = null;
			
			String sql = "delete from pc_pokemon where pc_id = ?";
			
			String sql2 = "select * from pc_pokemon where pc_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			
			ps.setInt(1, id);
			ps2.setInt(1, id);
			
			rs = ps2.executeQuery();
			
			ps.executeUpdate();
			
			List<PcEntry> pc = new ArrayList<>();
			
			while (rs.next()) {
				PcEntry pt = new PcEntry(
						rs.getInt("pc_id"),
						rs.getString("pokemon_name_fk")
						);
				pc.add(pt);
			}
			
			System.out.println("You released ".toUpperCase() + pc.get(0).getPokemonName().toUpperCase() + " from your pc!".toUpperCase());
		}
		catch (SQLException e) {
			System.out.println("Something went wrong in releasing a pokemon from your pc!".toUpperCase());
			e.printStackTrace();
		}
		
	}
	

	@Override
	public void addPokemon(Pokemon p) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "insert into pc_pokemon (pokemon_name_fk) values (?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, p.getName());
			
			ps.executeUpdate();
		}
		catch (SQLException e) {
			System.out.println("Something went wrong in catching a pokemon!".toUpperCase());
			e.printStackTrace();
		}
		
	}
	
}
