/*
 * TileMapView.java
 * Cette classe gere la partie visuelle de la Tile Map, ses responsabilites sont de :
 * - recuperer et afficher l'image corrspondant à la tuile.
 * 
 */
package byteDefense.view;

import java.io.File;
import java.net.MalformedURLException;

import byteDefense.model.TileMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

public class TileMapView {

	// Donnees correspondant aux composantes visuelles (tiles) de la tilemap 
	public static final int CORNER = 1;
	public static final int HORIZONTAL_PATH = 2;
	public static final int VERTICAL_PATH = 3;
	public static final int VERTICAL_WALL = 4;
	public static final int INTERSECTION_PATH = 5;
	public static final int HORIZONTAL_WALL = 6;
	public static final int TOWER_ZONE = 7;

	private static Image CORNER_SRC_IMG; 
	private static Image HORIZONTAL_PATH_SRC_IMG ;
	private static Image VERTICAL_PATH_SRC_IMG;
	private static Image VERTICAL_WALL_SRC_IMG ;
	private static Image INTERSECTION_PATH_SRC_IMG ;
	private static Image HORIZONTAL_WALL_SRC_IMG ;
	private static Image TOWER_ZONE_SRC_IMG ;

	private TileMap map;
	private TilePane gameBoard;

	public TileMapView(TileMap map, TilePane gameBoard) {
		this.map = map;
		this.gameBoard = gameBoard;
		this.imageLoader();
		this.generateMapView();
	}
	
	private void imageLoader() {
		try {
			CORNER_SRC_IMG = new Image(new File("./resources/corner.png").toURI().toURL().toString()); 
			HORIZONTAL_PATH_SRC_IMG = new Image(new File("./resources/horizontal_path.png").toURI().toURL().toString()); 
			VERTICAL_PATH_SRC_IMG= new Image(new File("./resources/vertical_path.png").toURI().toURL().toString()); 
			VERTICAL_WALL_SRC_IMG = new Image(new File("./resources/vertical_wall.png").toURI().toURL().toString()); 
			INTERSECTION_PATH_SRC_IMG = new Image(new File("./resources/intersection_path.png").toURI().toURL().toString()); 
			HORIZONTAL_WALL_SRC_IMG = new Image(new File("./resources/horizontal_wall.png").toURI().toURL().toString()); 
			TOWER_ZONE_SRC_IMG = new Image(new File("./resources/tower_zone.png").toURI().toURL().toString()); 
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	private Image tileImageGet(int mapCase) {
		Image tileImage = null;

		switch (mapCase) {
		case CORNER:
			tileImage = CORNER_SRC_IMG;
			break;
		case HORIZONTAL_PATH:
			tileImage = HORIZONTAL_PATH_SRC_IMG;
			break;
		case VERTICAL_PATH:
			tileImage = VERTICAL_PATH_SRC_IMG;
			break;
		case VERTICAL_WALL:
			tileImage = VERTICAL_WALL_SRC_IMG;
			break;
		case INTERSECTION_PATH:
			tileImage = INTERSECTION_PATH_SRC_IMG;
			break;
		case HORIZONTAL_WALL:
			tileImage = HORIZONTAL_WALL_SRC_IMG;
			break;
		case TOWER_ZONE:
			tileImage = TOWER_ZONE_SRC_IMG;
			break;
		}
		return tileImage;
	}

	private void generateMapView() {
		Image tileImage;
		int tilesSize = TileMap.tilesSize;
		
		for (int y = 0; y < tilesSize; y++) {
			for (int x = 0; x < tilesSize; x++) {
				tileImage = this.tileImageGet(this.map.getCase(x, y));
				
				if(tileImage != null) {
					ImageView tile = new ImageView();
						tile.setImage(tileImage);
						tile.setX(x);
						tile.setY(y);
						this.gameBoard.getChildren().add(tile);
				}		
			}
		}
	}
}