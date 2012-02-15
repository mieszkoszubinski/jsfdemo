package mieszko.project;

import java.util.*;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class Person {

	String name;
	List<Game> listOfGame = new ArrayList<Game>();
	Date dateOfBirth = new Date();

	public Person(String name, Date dateOfBirth) {
		this.name = name;
		this.listOfGame = new ArrayList<Game>();
		this.dateOfBirth = dateOfBirth;
	}
	
	@Size(min = 1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Game> getListOfGame() {
		return listOfGame;
	}

	public void setListOfGame(List<Game> listOfGame) {
		this.listOfGame = listOfGame;
	}

	@Past
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
/*
	public void printGame() {
		for (Game game : listOfGame) {
			game.printGame();
		}
	}

	public void printPerson() {
		System.out.println("##### " + name + " #####");
	}

	public void printAll() {
		printPerson();
		System.out.println();
		printGame();
		System.out.println();
	}

	public void addGame(String name, GameType gameType, int releaseYear,
			int price) throws PriceException {
		if (price > 0) {
			listOfGame.add(new Game(name, gameType, releaseYear, price));
		}
		if (price <= 0)
			throw new PriceException("Price cannot by less than 0");
	}

	public void deleteGame(List<Game> list) {
		for (Game game : list) {
		listOfGame.remove(game);
		}
	}

	public void deleteAllGame() {
		listOfGame.clear();
	}

	public void editGamePrize(List<Game> list, int price) throws PriceException {
		if (price > 0) {
			for (Game game : list) {
				game.setPrice(price);
			}
		}
		if (price <= 0)
			throw new PriceException("Price cannot by less than 0");
	}

	public void editGameReleaseYear(List<Game> list, int releaseYear) {
		for (Game game : list) {
			game.setReleaseYear(releaseYear);
		}
	}

	public void editGameType(List<Game> list, GameType gameType) {
		for (Game game : list) {
			game.setGameType(gameType);
		}
	}

	public List<Game> findAllGameByName(String name) {
		List<Game> results = new ArrayList<Game>();
		for (Game game : listOfGame) {
			if (game.getName().equals(name)) {
				results.add(game);
			}
		}
		return results;
	}

	public List<Game> findAllGameByType(GameType gameType) {
		List<Game> results = new ArrayList<Game>();
		for (Game game : listOfGame) {
			if (game.getGameType().equals(gameType)) {
				results.add(game);
			}
		}
		return results;
	}
	
	public List<Game> findAllGameByReleaseYear(int releaseYear) {
		List<Game> results = new ArrayList<Game>();
		for (Game game : listOfGame) {
			if (game.getReleaseYear()==releaseYear) {
				results.add(game);
			}
		}
		return results;
	}
*/

}
