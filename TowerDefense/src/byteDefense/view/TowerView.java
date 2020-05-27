/*
 * TowerView.java
 * Cette classe gere la partie visuelle d'un objet de jeu, ses responsabilites sont :
 * - charger et stocker les ressources d'images des tourelles
 * - faire la correspondance entre les types de tourelles et les ressources d'images des tourelles
 */

package byteDefense.view;

import java.io.File;
import java.net.MalformedURLException;

import byteDefense.model.GameObject;
import byteDefense.model.towers.AdCube;
import byteDefense.model.towers.Antivirus;
import byteDefense.model.towers.AuthenticationPoint;
import byteDefense.model.towers.Firewall;
import byteDefense.model.towers.SudVPN;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class TowerView extends GameObjectView {
	
	private static Image adcubeImg; 
	private static Image antivirusImg;
	private static Image firewallImg;
	private static Image authenticationPointImg;
	private static Image sudvpnImg;

	public TowerView(Pane grid) {
		super(grid);
	}
	
	public void imageLoader() {
		try {	
			adcubeImg = new Image(new File("./resources/character.png").toURI().toURL().toString()); 
			antivirusImg = new Image(new File("./resources/character.png").toURI().toURL().toString()); 
			firewallImg= new Image(new File("./resources/character.png").toURI().toURL().toString()); 
			authenticationPointImg = new Image(new File("./resources/character.png").toURI().toURL().toString()); 
			sudvpnImg = new Image(new File("./resources/character.png").toURI().toURL().toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public Image imageGetter(GameObject gameObject) {
		Image img;
		
		if (gameObject instanceof AdCube)
			img = adcubeImg;
		else if (gameObject instanceof Antivirus)
			img = antivirusImg;
		else if (gameObject instanceof Firewall)
			img = firewallImg;
		else if (gameObject instanceof AuthenticationPoint)
			img = authenticationPointImg;
		else if (gameObject instanceof SudVPN)
			img = sudvpnImg;
		else
			img = null;
			
		return img;
	}
}