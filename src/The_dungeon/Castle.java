package The_dungeon;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Castle {
	private ArrayList<Rooms> Rooms;
	private boolean winner = false;
	
	
	private EmptyRoom emptyRoom;
	private TreasureRoom treasureRoom;
	private EnemyRoom enemyRoom;

	private String userAnswer="";
	private String userCharacName="";

	private Scanner scAnswer;
	private Characters characterPlayer;
	private Characters characterEnemy;
	private UserPlayer player;
	private EnemyCharacter enemy;


	public void CastleGame() {
		
		do {
			//start the game
			System.out.println("Welcome to Dungeon Adventure!!!\n\n\n");
			initialize();

			//create a player with his name
			createPlayer();

			//enter the castle
			System.out.println("\nHello "+characterPlayer.getCharacterName()+" I am king Ragnarlof!!!\n"
					+ "Are you ready to find my missing gold in my huge Castle ?\n"
					+ "if you can get me 100 gold out safely, you will be rewared greatly.\n"
					+ "ENOUGH CHATTING GOOO AND FIND MY GOLD.... GOOOO NOW!!!!\n");

			//in the corridor
			System.out.println(characterPlayer.getCharacterName()+" by pass the huge castle gates...\n"); //to the Corridor

			while(corridorRoom()) {
				//check if the player haves 100 gold
				if(player.getPlayerTotalTreasure() >= 100) {
					System.out.println(characterPlayer.getCharacterName()+" you have "+player.getPlayerTotalTreasure()+" gold.\n"
							+ "Are you sure you want to continu  y|n ?");
					scAnswer = new Scanner(System.in);
					if(scAnswer.nextLine().trim().equals("n")) {
						winner = true;
						break;	
					}	
				}
				
				//generate a random room
				int randomRoomID = randomRoomPicker();
				System.out.print("\n"+characterPlayer.getCharacterName()+" left the corridor and is now in... ");
				boolean dead = false;
				
				switch(randomRoomID) {
				case 0: Rooms.add(emptyRoom);
						int getHeals = emptyRoom.getRandomHealth();

						System.out.print("an "+emptyRoom.getRoomName()+" with no enemy around my surroundings but wait... '"+
								characterPlayer.getCharacterName()+" gains "+getHeals+" additional health'.");
						player.addHealth(getHeals);
						break;

				case 1:	Rooms.add(treasureRoom);

						int playerT = treasureRoom.getRandomGold();
						player.addTreasure(playerT);

						System.out.print("a "+treasureRoom.getRoomName()+". In this room "+characterPlayer.getCharacterName()+" "
								+ "sees a lot of big treasure statues that he can not take with him but found "+playerT+" gold.");
						
						break;

				case 2: Rooms.add(enemyRoom);
						
						System.out.print("an "+enemyRoom.getRoomName()+" where a "+characterEnemy.getCharacterName()+" is blocking my patch to the exit... "
								+ "looks like he's coming towards me...\nis he attacking me ?!?!? I can risk it '"+characterPlayer.getCharacterName()+" "
										+ "unsheathe his sword'. ");
						System.out.println("The "+characterEnemy.getCharacterName()+" and "+characterPlayer.getCharacterName()+" are fighting...");

						int enemyAHP = enemy.getRandomEnemyAHP();
						//System.out.println("get player health: "+player.getHealth());
						//System.out.println("get enemy attack point: "+enemy.getRandomEnemyAHP());
						int remainingHealth = (player.getHealth() - enemyAHP);
						//System.out.println("remainingHealth: "+remainingHealth);
						player.setHealth(remainingHealth);
						
						if (player.getHealth() > 0) {
							System.out.println(characterPlayer.getCharacterName()+" won the battle and exited the room but lost some health.\n"
									+ "Remaining health: "+player.getHealth()+".");
						}else {
							System.out.println("'"+characterPlayer.getCharacterName()+"' is dying... The enemy "+characterEnemy.getCharacterName()+" "
									+ "is victorious.");
							dead = true;
						}
						break;

				default: System.out.println("No Rooms were created... there's a problem!!!");	break;
				}
				
				if(dead == true)
					break;
			
			}
			//out of corridor loop
			//the player wins the game
			if(winner) {
				System.out.println("Congratulation "+characterPlayer.getCharacterName()+" you brought back enough gold to the King Ragnarlof\n'"
						+characterPlayer.getCharacterName()+" gives "+player.getPlayerTotalTreasure()+" gold to the King'");
			}

		}while(playAgain().trim().equals("y"));
		//out of game loop

		System.out.println("The Dungeon:\n"
				+characterPlayer.getCharacterName()+" had "+player.getHealth()+" health points left.\n"
				+characterPlayer.getCharacterName()+" had "+player.getPlayerTotalTreasure()+" gold.\n"
				+ "The castle generated "+Rooms.size()+" rooms during the game.");
		System.exit(0);
	}
	
	private void initialize() {
		Rooms = new ArrayList<Rooms>();
		
		emptyRoom = new EmptyRoom();
		treasureRoom = new TreasureRoom();
		enemyRoom = new EnemyRoom();
		
		characterEnemy = new Characters("Knight");
		enemy = new EnemyCharacter();
	}

	private void createPlayer() {
		System.out.println("Enter your character name: ");
		scAnswer = new Scanner(System.in);
		userCharacName = scAnswer.nextLine().trim();
		characterPlayer = new Characters(userCharacName);
		player = new UserPlayer();
	}

	//creating the castle corridors (couloir)
	private Corridor createCorridor() {
		Corridor cor = new Corridor();
		Rooms.add(cor);
		return cor;
	}

	private boolean corridorRoom() {
		//ask if the player wants to leave the game ?
		System.out.println("\n"+characterPlayer.getCharacterName()+" is in the corridor.");
		boolean decision = false;
		
		if(decision().trim().equals("y")) {
			createCorridor().leave();
		}else {
			createCorridor().continuing();
			Rooms.add(createCorridor());
			decision = true;
		}
		return decision;
	}

	private String decision() {
		System.out.println("Do you want to leave y|n ? ");
		userAnswer = "";
		scAnswer = new Scanner(System.in);
		userAnswer = scAnswer.nextLine();
		return userAnswer;
	}
	
	private String playAgain() {
		System.out.println("Do you wanna play again y|n ? ");
		userAnswer = "";
		scAnswer = new Scanner(System.in);
		userAnswer = scAnswer.nextLine();
		return userAnswer;
	}
	
	private int randomRoomPicker() {
		//generate a random number between 0-2 and store them
		Random rand = new Random();
		return rand.nextInt((2-0)+1);
	}
	
	
	
	
}
