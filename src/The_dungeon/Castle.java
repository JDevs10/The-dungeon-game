package The_dungeon;

import java.util.ArrayList;

public abstract class Castle {
	private ArrayList<Rooms> rooms = new ArrayList<Rooms>();

	public Castle(Rooms roomName) {
		rooms.add(roomName);
	}

}
