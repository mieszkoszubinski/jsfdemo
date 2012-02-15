package mieszko.services;


import java.io.IOException;
import java.sql.*;
import java.util.*;

import mieszko.project.*;


public class PersonGameDBManager {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement addGameToPersonStmt;
	private PreparedStatement deleteAllPersonGameStmt;
	private PreparedStatement deleteAllGameFromPersonStmt;
	private PreparedStatement getGamePersonStmt;

	public PersonGameDBManager() 
	{
		try 
		{
			
			conn = DriverManager
					.getConnection("jdbc:hsqldb:hsql://localhost/workdb");

			stmt = conn.createStatement();
			boolean personTableExists = false;

			ResultSet rs = conn.getMetaData().getTables(null, null, null, null);

			while (rs.next()) 
			{
				if ("PersonGame".equalsIgnoreCase(rs.getString("TABLE_NAME"))) 
				{
					personTableExists = true;
					break;
				}
			}

			if (!personTableExists) 
			{
				stmt.executeUpdate("CREATE TABLE personGame(person_id int, game_id int, CONSTRAINT person_id_fk FOREIGN KEY (person_id) REFERENCES person (id), CONSTRAINT game_id_fk FOREIGN KEY (game_id) REFERENCES game (id))");
			}
			
			addGameToPersonStmt = conn.prepareStatement("INSERT INTO personGame (person_id, game_id) VALUES (?, ?)");
			
			deleteAllGameFromPersonStmt = conn.prepareStatement("DELETE FROM personGame WHERE person_id = ?");
			
			deleteAllPersonGameStmt = conn.prepareStatement("DELETE FROM personGame");
			
			getGamePersonStmt = conn.prepareStatement("SELECT Game.name, Game.gameType, Game.releaseYear, Game.price FROM Game, PersonGame WHERE person_id = ? and game_id = Game.id");

		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
	}
	
	
	public void addGameToPerson(List<Integer> listPersonId, List<Integer> listGameId) 
	{
		try 
		{
			for (Integer personID : listPersonId)
			{
				for (Integer gameID : listGameId)
				{
					addGameToPersonStmt.setInt(1, personID);
					addGameToPersonStmt.setInt(2, gameID);
					addGameToPersonStmt.executeUpdate();
				}
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}
	
	public void deleteAllGameFromPerson (List<Integer> listPersonId) 
	{
		try 
		{
			for (Integer personID : listPersonId)
			{
					deleteAllGameFromPersonStmt.setInt(1, personID);
					deleteAllGameFromPersonStmt.executeUpdate();
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}
	
	public void deleteAllPersonGame () 
	{
		try 
		{
				deleteAllPersonGameStmt.executeUpdate();
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}

	}
	
	public List<Game> getPersonGame (List<Integer> listPersonId)
	{
		List<Game> Games = new ArrayList<Game>();
		try 
		{
			for (Integer personID : listPersonId)
			{
				getGamePersonStmt.setInt(1, personID);
				ResultSet rs = getGamePersonStmt.executeQuery();
				while (rs.next()) 
				{
					GameType gameType = null;
					if (rs.getString("gameType").equals("Action"))
						gameType = GameType.Action;
					if (rs.getString("gameType").equals("Adventure"))
						gameType = GameType.Adventure;
					if (rs.getString("gameType").equals("Shooter"))
						gameType = GameType.Shooter;
					if (rs.getString("gameType").equals("Fighting"))
						gameType = GameType.Fighting;
					if (rs.getString("gameType").equals("Strategy"))
						gameType = GameType.Strategy;
					if (rs.getString("gameType").equals("Sport"))
						gameType = GameType.Sport;
					if (rs.getString("gameType").equals("Racing"))
						gameType = GameType.Racing;
						
					Games.add(new Game(rs.getString("name"),gameType,rs.getInt("releaseYear"),rs.getInt("price")));
				}
			}
		} 
		catch (SQLException e) 
		{

			e.printStackTrace();
		}
		return Games;
	}

	

}
