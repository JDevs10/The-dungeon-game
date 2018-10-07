package The_dungeon;

public class Main {

	public static void main(String[] args) {
		UserPlayer up = new UserPlayer();
		EnemyCharacter ec = new EnemyCharacter();
		
		System.out.println("Player character name: "+up.getCharacterName()+" with total treasure: "+up.getPlayerTotalTreasure()+"\n"
				+ "Enemy character name: "+ec.getCharacterName());
		
		
	}
}
