package The_dungeon;

public abstract class Room extends Rooms {
	private Rooms[] tab = new Rooms[3];
	
	public Room() {
		super("Room","Different types of rooms");
	}

	public void generateRooType() {
		tab[0] = new TreasureRoom(5,5);
		tab[1] = new EmptyRoom(2,2);
		tab[2] = new EnemyRoom(15,20);
	}
}
