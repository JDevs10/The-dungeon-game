package The_dungeon;

public class UserPlayer extends Characters {
	private int treasure;
	private int health;
	
	public UserPlayer() {
		super("Player");
		treasure = 0;
		health = 25;
	}
	
	public int getPlayerTotalTreasure() {
		return this.treasure;
	}
	
	public void addTreasure(int adding) {
		treasure = treasure + adding;
	}
	
	public void removeTreasure(int removing) {
		treasure = treasure - removing;
	}
	
	public void addHealth(int adding) {
		health = health + adding;
	}
	
	public void setHealth(int set) {
		this.health = set;
	}
	
	public int getHealth() {
		return this.health;
	}
}