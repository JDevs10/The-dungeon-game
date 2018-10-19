package The_dungeon;

import java.util.Random;

public class EmptyRoom extends Rooms {
	private int roomType = 0;
	private UserPlayer up = new UserPlayer();
	
	public EmptyRoom() {
		super("Empty Room");
	}
	
	public int getRoomType() {
		return this.roomType;
	}
	
	public int getRandomHealth() {
		Random rand = new Random();
		int health;
		health = rand.nextInt((13-1)+1);
		return health;
	}

}
