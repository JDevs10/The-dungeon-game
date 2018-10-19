package The_dungeon;

public class Corridor extends Rooms {

	public Corridor() {
		super("corridor");
		
	}
	
	public void leave() {
		System.out.println("Are you willing to leave now ?!?!?\nWe've lost an other knight...");
		//System.exit(0);
	}
	
	public void continuing() {
		System.out.println("No time to sleep knight!!!\nI want my gold");

	}

}
