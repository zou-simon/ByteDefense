/*
 * BFS.java
 * Cette classe explore la carte accessible dans la gameArea (un ArrayList<Integer>)
 * et fourni les chemins les plus courts vers le point de lancement.
 * - Le chemin du bfs est stockee dans un tableau à une dimension du nombre de tiles de la carte
 * || cameFrom[indiceTile] = indiceParentDeLaTile ||
 */

package byteDefense.utilities;

import java.util.LinkedList;

import byteDefense.model.GameArea;

public class BFS {
	
	public static final int ARRIVAL_POINT = -1; // -1 correspond au point d'arrivée
	
	int tilesIndex = 0;
	int gameAreaDimension;
	public GameArea gameArea;
	public int[] cameFrom;

	public BFS(GameArea gameArea) {
		this.gameArea = gameArea;
		this.gameAreaDimension = (int) Math.pow(GameArea.gameAreaTilesSize, 2);// (largeurDuTerrain^2)
		this.cameFrom = new int[this.gameAreaDimension];
		this.BFS_algo(GameArea.arrivalPoint);	
	}

	private int[] foundNeightbours(int index) {
		int x = GameArea.tilePosX(index);
		int y = GameArea.tilePosY(index);	
		int up = GameArea.tileIndex(x, y - 1);
		int right = GameArea.tileIndex(x + 1, y);
		int down = GameArea.tileIndex(x, y + 1);
		int left = GameArea.tileIndex(x - 1, y);
	
		int[] neightbours = new int[] {
				this.lookTileValue(up),
				this.lookTileValue(right), 
				this.lookTileValue(down), 
				this.lookTileValue(left)
		};	
		return neightbours;
	}
	
	private int lookTileValue(int value) {
		if (this.gameArea.isWalkable(this.gameArea.getTilesList().get(value))) 
			return value;
		else
			return -1;
	}
	
	private boolean isInCameFrom(int value) {
		for (int i : this.cameFrom)
			if (i == value)
				return true;
		return false;
	}

	public void BFS_algo(int start) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		queue.add(start);
		this.cameFrom[start] = ARRIVAL_POINT; // premier sommet du BFS
		
		while (queue.size() != 0) {
			int current = queue.poll();
			int [] neightbour = this.foundNeightbours(current);
			int next;
			
			for (int i = 0 ; i < neightbour.length; i++) {
				if (neightbour[i] != -1) {
					next = neightbour[i];					
					if (!this.isInCameFrom(next)) {
						queue.add(next);
						this.cameFrom[next] = current;
					}
				}
			}
		}		
	}	
}
