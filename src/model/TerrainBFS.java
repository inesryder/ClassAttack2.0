package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 * Cette classe permet de créer le BFS d'un terrain grâce a son graphe créé dans la classe Terraingraphe
 *
 */
public class TerrainBFS{

	private Map<Coord,Integer> listBFS; // map comportant chaque case de chemins du tableau de jeu et sa distance par rapport a l'arrivée 
	private TerrainGraphe terrainGraphe; // le graphe du terrainModel
	
	public TerrainBFS(TerrainGraphe terrainGraphe){
		this.terrainGraphe = terrainGraphe;
	}
	
	/**
	 * Demande la création d graphe
	 * Créé le BFS du terrain et le stock dans une Map appelée listBFS
	 */
	public void BFS (Coord CoorArrivee){
		terrainGraphe.creerGraphe();
		ArrayList <Coord> aTraiter = new ArrayList <Coord>();
		ArrayList <Coord> dejaTraites = new ArrayList<Coord>();
		Map<Coord, ArrayList<Coord>> graphe = terrainGraphe.getGraphe();
		listBFS = new HashMap<Coord, Integer>();
		Coord coorPrecedente = new Coord(0,0);
		
		//Print la map graphe
		/*System.out.println("Début Map Graphe");
		for(Coord c:graphe.keySet()){
			String key =c.toString();
            String value = graphe.get(c).toString();  
            System.out.println(key + " " + value); 
		}
		System.out.println("Fin Map Graphe");*/
		
		dejaTraites.add(CoorArrivee);
		listBFS.put(dejaTraites.get(0),0);
		coorPrecedente = dejaTraites.get(0);
		
		while(!dejaTraites.isEmpty()){
			for(Coord c: graphe.get(dejaTraites.get(0))){
				aTraiter.add(c);
			}
			coorPrecedente = dejaTraites.get(0);
			dejaTraites.remove(0);
			while(!aTraiter.isEmpty()){
				if(!listBFS.containsKey(aTraiter.get(0))){
					listBFS.put(aTraiter.get(0),listBFS.get(coorPrecedente)+1);
					dejaTraites.add(aTraiter.get(0));
				}
				aTraiter.remove(0);
			}
		}
	}

	//Getters and Setters
	public Map<Coord, Integer> getListBFS() {
		return listBFS;
	}

}
