package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Cette classe créé le graphe du terrain défini dans TerrainModel
 *
 */
public class TerrainGraphe{
	
	private Map<Coord,ArrayList<Coord>> graphe; // Cette map stock pour chaque coordonnée de chemin, sur le tableau du terrainModel, sa liste de chemins adjacents. 
	private TerrainModel terrainModel; // Le terrainModel utilisé pour connaitre la forme du terrain
	
	public TerrainGraphe(TerrainModel terrainModel){
		this.terrainModel = terrainModel;
	}
	
	
	/*
	 * Créé une HashMap contenant tous les sommets du graphes et leurs voisins respectifs 
	 */
	public void creerGraphe(){
		graphe = new HashMap<Coord,ArrayList<Coord>>();
		terrainModel.setMapCoor();
		for (int i = 1; i < 14; i++) {
			for (int j=1; j < 14; j++) {
				
				if(!terrainModel.verificationCheminObstrue(i, j)){
					ArrayList<Coord> listeVoisins = selectionneVoisins(i,j);
					graphe.put(terrainModel.getCoorFromMapCoor(i,j), listeVoisins);
				}
			}
		}
	}
	
	/**
	 * Grace au coordonnées d'un point, cette fonction renvoit les sommets voisisns de ce point dans un ArrayList
	 * @param x : coordonnée X de la case testée
	 * @param y : coordonnée Y de la case testée
	 * @return renvoit la liste des voisins de la case testée
	 */
	public ArrayList<Coord> selectionneVoisins(int x, int y){
		ArrayList<Coord> listeVoisins = new ArrayList<Coord>();
		
		if(terrainModel.getTileValue(x,y-1) == 0 || terrainModel.getTileValue(x,y-1) == 4){//Nord
			listeVoisins.add(listeVoisins.size(),terrainModel.getCoorFromMapCoor(x,y-1));
		}
	
		if(terrainModel.getTileValue(x,y+1) == 0 || terrainModel.getTileValue(x,y+1) == 4){//Sud
			listeVoisins.add(listeVoisins.size(),terrainModel.getCoorFromMapCoor(x,y+1));
		}
		
		if(terrainModel.getTileValue(x+1 ,y) == 0 || terrainModel.getTileValue(x+1 ,y) == 4){//Est
			listeVoisins.add(listeVoisins.size(),terrainModel.getCoorFromMapCoor(x+1,y));
		}
		
		if(terrainModel.getTileValue(x-1,y) == 0 || terrainModel.getTileValue(x-1,y) == 4){//Ouest
			listeVoisins.add(listeVoisins.size(),terrainModel.getCoorFromMapCoor(x-1,y));
		}
		return listeVoisins;
	}
	
	//Getters and Setters
	public Map<Coord, ArrayList<Coord>> getGraphe() {
		return graphe;
	}

}