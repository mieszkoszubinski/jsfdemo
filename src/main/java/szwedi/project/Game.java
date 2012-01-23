package szwedi.project;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Game {

	public String name;
	public GameType gameType;
	public int releaseYear;
	public int price;
	public boolean cleanBox;
	public boolean backup;
	public String gameBoxColor;
	
	public String gameTypeString;

	public Game(String name, GameType gameType, int releaseYear, int price) {
		this.name = name;
		this.gameType = gameType;
		this.releaseYear = releaseYear;
		this.price = price;
		this.cleanBox = true;
		this.backup = false;
		this.gameBoxColor = "white";

		this.gameTypeString = gameTypeString;
	}
/*
	public void printGame() {
		System.out.println("Name: " + name + "\tGame type: " + gameType
				+ "\tRelease year: " + releaseYear + "\tPrice: " + price);
	}
*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GameType getGameType() {
		return gameType;
	}

	public void setGameType(GameType gameType) {
		this.gameType = gameType;
	}

	@Min(1950)
	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Min(0)
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isCleanBox() {
		return cleanBox;
	}

	public void setCleanBox(boolean cleanBox) {
		this.cleanBox = cleanBox;
	}

	public boolean isBackup() {
		return backup;
	}

	public void setBackup(boolean backup) {
		this.backup = backup;
	}

	public String getGameBoxColor() {
		return gameBoxColor;
	}

	public void setGameBoxColor(String gameBoxColor) {
		this.gameBoxColor = gameBoxColor;
	}

	public String getGameTypeString() {
		return gameTypeString;
	}

	public void setGameTypeString(String gameTypeString) {
		this.gameTypeString = gameTypeString;
	}

}
