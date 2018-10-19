package The_dungeon;


public class EnemyRoom extends Rooms{
	private int roomType = 2;

	public EnemyRoom() {
		super("Enemy Room");
	}
	
	public int getRoomType() {
		return this.roomType;
	}

}
