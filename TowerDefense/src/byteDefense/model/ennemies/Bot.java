/*
 * Bot.java
 * Cette classe represente un objet Bot, ses responsabilites sont de :
 * - stocker et recuperer son attaque
 * - stocker et recuperer sa defense
 * - stocker et recuperer sa vitesse d'attaque
 * - stocker et recuperer sa portee d'attaque
 * - stocker et recuperer le montant de son butin
 * - effectuer toutes les actions d'aggissement durant un tour
 */

package byteDefense.model.ennemies;

import byteDefense.model.GameEnvironment;
import byteDefense.utilities.BFS;

public class Bot extends Ennemy {

	private static final float ATTACK = 0;
	private static final int DEFENSE = 0;
	private static final int ATTACK_SPEED = 0;
	private static final int ATTACK_RANGE = 0;
	private static final int LOOT = 0;

	public Bot(BFS bfsMap, GameEnvironment gameEnv) {
		super(624, 432, bfsMap, gameEnv);
	}

	public float getAttack() {
		return ATTACK;
	}

	public int getDefense() {
		return DEFENSE;
	}

	public int getAttackSpeed() {
		return ATTACK_SPEED;
	}

	public int getAttackRange() {
		return ATTACK_RANGE;
	}

	public int getLoot() {
		return LOOT;
	}

	public void act() {
		this.moveEnnemy();
	}
}
