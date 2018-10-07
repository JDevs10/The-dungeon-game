package The_dungeon;

public class UserPlayer extends Characters {
	private int treasure = 2;
	
	public UserPlayer() {
		super("Player");
	}
	
	public int getPlayerTotalTreasure() {
		return treasure;
	}
}