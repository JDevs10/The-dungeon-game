package The_dungeon;

import java.util.Random;

public class EnemyCharacter extends Characters {
	private int attack_hit_points;
	
	public EnemyCharacter() {
		super("Enemy");
	}
	
	public int getEnemyAttackHitPoint() {
		return attack_hit_points;
	}
	
	public int getRandomEnemyAHP() {
		Random rand = new Random();
		attack_hit_points = rand.nextInt((13-1)+1);
		return attack_hit_points;
	}

}
