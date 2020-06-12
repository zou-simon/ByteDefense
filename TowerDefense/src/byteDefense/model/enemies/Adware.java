/*
 * Adware.java
 * Cette classe represente un objet Adware, ses responsabilites sont de :
 * - stocker et recuperer son attaque
 * - stocker et recuperer sa defense
 * - stocker et recuperer sa vitesse d'attaque
 * - stocker et recuperer sa portee d'attaque
 * - stocker et recuperer le montant de son butin
 * - stocker son taux de reproduction
 * - gerer son tour de naissance dans une vague
 * - effectuer toutes les actions d'aggissement durant un tour
 */

package byteDefense.model.enemies;

import byteDefense.model.GameEnvironment;
import byteDefense.model.LivingObject;
import byteDefense.utilities.BFS;

public class Adware extends Enemy {

	private static final int ATTACK = 20;
	private static final int INITIAL_DEFENSE = 10;
	private static final int ATTACK_RANGE = 1; // portee d'attaque en nombre de tuile du plateau de jeu
	private static final int LOOT = 20;
	
	public Adware(BFS bfs, GameEnvironment gameEnv) {
		super(INITIAL_DEFENSE, bfs, gameEnv);
	}
	
	public int getAttack() {
		return ATTACK;
	}

	public int getAttackRange() {
		return ATTACK_RANGE;
	}

	public int getLoot() {
		return LOOT;
	}

	public void move() {
		if (!super.isArrived())
			super.moveEnnemy();
	}
	
	public void useSpecialEffect(LivingObject livingObject) {
		
	}
}	
