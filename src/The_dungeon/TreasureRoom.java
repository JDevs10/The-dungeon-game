package The_dungeon;

import java.util.Random;

public class TreasureRoom extends Rooms{
	private int roomType = 1;
	private int gold;
	
	public TreasureRoom() {
		super("Treasure Room");
		gold = 0;
	}
	
	public int getRoomType() {
		return this.roomType;
	}
	
	public int getRandomGold() {
		Random rand = new Random();
		gold += rand.nextInt((25-1)+1);
		return gold;
	}
}
