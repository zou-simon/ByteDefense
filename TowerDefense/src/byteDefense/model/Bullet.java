/*
 * Bullet.java
 * Cette classe represente un objet Bullet (un tir), ses responsabilites sont de :
 * - stocker, recuperer et fixer les coordonnees xy du tir
 * - stocker et recuperer la cible du tir
 * - stocker le tireur 
 * - identifier un tir par un identifiant recuperable
 * - stocker et recuperer les coordonnees de la cible du tir
 * - blesser la cible selon les degats du tireur
 */

package byteDefense.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Bullet {
	
	private IntegerProperty xProperty;
	private IntegerProperty yProperty;
	private GameObject targetObject;
	private GameObject shooterObject;
	private int id;
	private int targetX;
	private int targetY;

	public Bullet(int x, int y, GameObject targetObject, GameObject shooterObject) {
		this.xProperty = new SimpleIntegerProperty(x);
		this.yProperty = new SimpleIntegerProperty(y);
		this.targetObject = targetObject;
		this.shooterObject = shooterObject;
		this.targetX = this.targetObject.getX();
		this.targetY = this.targetObject.getY();
		
		this.id = GameObject.counterId;
		GameObject.counterId++;
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

	public GameObject getTargetObject() {
		return this.targetObject;
	}
	
	public int getTargetX() {
		return this.targetX;
	}

	public int getTargetY() {
		return this.targetY;
	}
	
	public void woundTarget() {
		this.targetObject.decrementHp((int) this.shooterObject.getAttack());
	}

}
