package byteDefense.model.ennemies;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

public class Wave {
	
	private ObservableList<Ennemy> ennemies;
	private final int WAVE_NUMBER;
	private final Point2D ARRIVAL_POINT; 
	
	public Wave(int waveNumber) {
		this.ennemies = FXCollections.observableArrayList(); 
		this.WAVE_NUMBER = waveNumber;
		this.ARRIVAL_POINT = new Point2D(0, 0);

		fillEnnemyList();
	}
	
	private void addEnnemy(Ennemy ennemy) {
		this.ennemies.add(ennemy);
	}
	
	private void addEnnemies(int ennemyQty, int ennemyType) {
		for (int i = 1; i <= ennemyQty; i++) {
			switch (ennemyType) {
				case 1:
					this.addEnnemy(new Rookit());
					break;
				case 2:
					this.addEnnemy(new Adware());
					break;
				case 3:
					this.addEnnemy(new Bot());
					break;
				case 4:
					this.addEnnemy(new Ransomware());
					break;
				case 5:
					this.addEnnemy(new Spyware());
				case 6:
					this.addEnnemy(new TrojanHorse());
					break;
			}
		}
	}
	
	private void fillEnnemyList() {
		switch (WAVE_NUMBER) {
			case 1:
				addEnnemies(5, 1);
				addEnnemies(5, 4);
				break;
			case 2:
				addEnnemies(5, 1);
				addEnnemies(3, 4);
				addEnnemies(2, 3);
				break;
			case 3:
				addEnnemies(5, 1);
				addEnnemies(3, 4);
				addEnnemies(2, 3);
				addEnnemies(3, 5);
				break;
			case 4:
				addEnnemies(4, 1);
				addEnnemies(3, 4);
				addEnnemies(2, 3);
				addEnnemies(3, 5);
				addEnnemies(2, 2);
				break;
			case 5:
				addEnnemies(4, 1);
				addEnnemies(3, 4);
				addEnnemies(3, 3);
				addEnnemies(3, 5);
				addEnnemies(2, 2);
				addEnnemies(1, 6);
				break;
		}
	}
	
	public ObservableList<Ennemy> getEnnemies() {
		return this.ennemies;
	}
	
	public Ennemy getEnnemy(int id) {
		for(Ennemy e : this.ennemies)
			if(e.getId() == id)
				return e;
		
		return null;
	}
	
	public boolean isEmpty() {
		return this.ennemies.size() <= 0;
	}
	
	public void verifieEnnemi() {
		if(! this.isEmpty())
			for(int i = this.ennemies.size() - 1; i > 0; i--) {			
				Ennemy e = this.ennemies.get(i);
				if(! e.isAlive() || e.getX() == ARRIVAL_POINT.getX() && e.getY() == ARRIVAL_POINT.getY()) 
					this.ennemies.remove(i);
			}
	}
}
