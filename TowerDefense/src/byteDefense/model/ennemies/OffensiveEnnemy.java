/*
 * OffensiveEnnemy.java
 * Cette classe represente un objet OffensiveEnnemy, c'est-a-dire un ennemi qui attaque des tourelles, ses responsabilites sont de :
 * - d'attaquer une tourelle
 */

package byteDefense.model.ennemies;

import byteDefense.model.GameEnvironment;
import byteDefense.utilities.BFS;

public abstract class OffensiveEnnemy extends Ennemy {

	public OffensiveEnnemy(int x, int y, BFS bfsMap, GameEnvironment gameEnv) {
		super(x, y, bfsMap, gameEnv);
	}

	public void attackTower() {

	}

	public abstract void act();

	public abstract float getAttack();

	public abstract int getDefense();

	public abstract int getAttackSpeed();

	public abstract int getAttackRange();

	public abstract int getLoot();
}
