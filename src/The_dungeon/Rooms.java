package The_dungeon;

public class Rooms extends Castle {
	private String name;
	private String description;
	
	public Rooms(String name) {
		this.name = name;
	}
	
	public String getRoomName() {
		return this.name;
	}
	
	public void addRoomName(String add) {
		this.name = add;
	}
	
	public void addDescription(String descript) {
		this.description = descript;
	}
	
	public String getDescription() {
		return description;
	}

}
