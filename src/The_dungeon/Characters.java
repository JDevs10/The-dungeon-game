package The_dungeon;

public abstract class Characters {
	private String name;
	
	public Characters(String name) {
		this.name = name;
	}
	
	public String getCharacterName() {
		return name;
	}
}
