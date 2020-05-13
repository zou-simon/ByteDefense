/*
 * Ennemy.java
 * Cette classe repr�sente un objet Ennemy, ses responsabilit�s sont de:
 * - permet de r�cup�rer et de d�cr�menter les points de vie de ennemi
 * - identifier l'ennemi par un identifiant r�cup�rable
 * - permet de r�cup�rer et de fixer les coordonn�es xy de ennemi
 * - v�rifier que l'ennemi est mort ou non
 * - r�cup�rer les caract�ristiques de l'ennemi (points d'attaque, point 
 *   de d�fense, vitesse d'attaque, port�e d'attaque et le butin)
 */

package byteDefense.model.ennemies;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Ennemy {

	private static int counterId = 0;
	
	private int id;
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private int hp;
	
	public Ennemy(int x, int y) {
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.hp = 0;
		this.id = counterId;
		counterId++;
	}
	
	public int getId() {
		return this.id;
	}

	public IntegerProperty getXProperty() {
		return this.xProperty;
	}
	
	public int getX() {
		return this.xProperty.getValue();
	}
	
	public void setX(int newX) {
		this.xProperty.setValue(newX);
	}
	
	public IntegerProperty getYProperty() {
		return this.yProperty;
	}
	
	public int getY() {
		return this.yProperty.getValue();
	}
	
	public void setY(int newY) {
		this.yProperty.setValue(newY);
	}	
	
	public int getHp() {
		return this.hp;
	}
	
	public void decrementHp(int lostHp) {
		this.hp -= lostHp;
	}

	public boolean isAlive() {
		return this.hp > 0;
	}
	
	public abstract int getAttack();

	public abstract int getDefense();

	public abstract int getAttackSpeed();

	public abstract int getAttackRange();
	
	public abstract int getLoot();
}