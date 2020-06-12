/*
 * TrojanHorse.java
 * Cette classe represente un objet TrojanHorse, ses responsabilites sont de :
 * - stocker et recuperer son attaque
 * - stocker et recuperer sa defense
 * - stocker et recuperer sa vitesse d'attaque
 * - stocker et recuperer sa portee d'attaque
 * - stocker et recuperer le montant de son butin
 * - effectuer toutes les actions d'aggissement durant un tour
 */

package byteDefense.model.enemies;

import byteDefense.model.GameEnvironment;
import byteDefense.model.GameMaster;
import byteDefense.model.LivingObject;
import byteDefense.utilities.BFS;

public class TrojanHorse extends Enemy {

	private static int attack;
	private static final int DEFENSE = 40;
	private static final int ATTACK_SPEED = 0; // vitesse d'attaque en nombre de tour
	private static final int ATTACK_RANGE = 0; // portee d'attaque en nombre de tuile du plateau de jeu
	private static final int LOOT = 80;

	public TrojanHorse(BFS bfs, GameEnvironment gameEnv) {
		super(bfs, gameEnv);
		attack = GameMaster.getPcHp();
	}

	public int getAttack() {
		return attack;
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

	public void useSpecialEffect(LivingObject livingObject) {
		
		
	}
}
