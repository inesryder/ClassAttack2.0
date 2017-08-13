package model.deplacement;

import model.Coor;
import model.TerrainModel;
/**
 * Cette interface possède les differents type de déplacement possible : BFS, Balise et Aleatoire
 *
 */
public interface Deplacement {

	public Coor seDeplace(TerrainModel terrainModel, Coor c);
	
}
