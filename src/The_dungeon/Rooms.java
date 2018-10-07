package The_dungeon;

public abstract class Rooms {
	private String roomName;
	private String description;

	public Rooms(String roomName, String description) {
		this.roomName = roomName;
		this.description = description;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public String getRoomDescription() {
		return description;
	}

}
