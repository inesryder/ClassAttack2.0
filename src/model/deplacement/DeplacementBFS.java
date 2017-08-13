package model.deplacement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Coor;
import model.Coord;
import model.TerrainModel;
/**
 * Ce déplacement utilise l'attribut BFS du TerrainModel pour fonctionner. Il ira sur une case adjacente a lui dont la distance à l'arrivée est inferieure
 * a la distance par rapport a l'arrivée de sa case actuelle. Si plusieurs chemins sont possibles il ira aléatoirement sur un d'eux.
 *
 */
public class DeplacementBFS implements Deplacement {	
	
	public Coor seDeplace(TerrainModel terrainModel, Coor coor){
		
		/*System.out.println("Debut de la liste");
		for(Coord c:distance.keySet()){
			String key =c.toString();
            String value = distance.get(c).toString();  
            System.out.println("Case : "+key + " ; Distance :" + value); 
		}
		System.out.println("Fin de la liste");*/
		Map<Coord,Integer> distance = new HashMap<Coord,Integer>();
		ArrayList<Coord> cheminsDispo = new ArrayList<Coord>();
		Coor coorPro;
		distance = terrainModel.getBFS();
		
		
		Coord caseActu = new Coord(coor.getX(),coor.getY());
		Coord caseN = new Coord(coor.getX(),coor.getY()-1);
		Coord caseE = new Coord(coor.getX()+1,coor.getY());
		Coord caseS = new Coord(coor.getX(),coor.getY()+1);
		Coord caseW = new Coord(coor.getX()-1,coor.getY());

		if(distance.get(caseN) != null && distance.get(caseActu)>distance.get(caseN)){//Nord
			cheminsDispo.add(caseN);
		}
		if(distance.get(caseE) != null && distance.get(caseActu)>distance.get(caseE)){//Est
			cheminsDispo.add(caseE);
		}
		if(distance.get(caseS) != null && distance.get(caseActu)>distance.get(caseS)){//Sud
			cheminsDispo.add(caseS);
		}
		if(distance.get(caseW) != null && distance.get(caseActu)>distance.get(caseW)){//Ouest
			cheminsDispo.add(caseW);
		}
	    coorPro = nextCaseBFS(cheminsDispo);
		
		coor.setCoor(coorPro.getX(),coorPro.getY());
		
		return coor;
	}
	
	/**
	 * Selectionne une case parmis les cases disponibles dans la liste de cases de poid inférieur 
	 * @param cheminsDispo liste des voisins de la case
	 * @return la case suivante
	 */
	public Coor nextCaseBFS(ArrayList<Coord> cheminsDispo){
		Coor coor = new Coor(0,0);
		int alea = (int) (Math.random() *100);
		
		 if(cheminsDispo.size() == 1){
			coor.setCoor(cheminsDispo.get(0).getX(), cheminsDispo.get(0).getY());
		}else if(cheminsDispo.size() == 2){
			if(alea<50)
				coor.setCoor(cheminsDispo.get(0).getX(), cheminsDispo.get(0).getY());
			else
				coor.setCoor(cheminsDispo.get(1).getX(), cheminsDispo.get(1).getY());
		}else if(cheminsDispo.size() == 3){
			if(alea<33)
				coor.setCoor(cheminsDispo.get(0).getX(), cheminsDispo.get(0).getY());
			else if(alea>=33 && alea < 66)
				coor.setCoor(cheminsDispo.get(1).getX(), cheminsDispo.get(1).getY());
			else 
				coor.setCoor(cheminsDispo.get(2).getX(), cheminsDispo.get(2).getY());
		}else if(cheminsDispo.size()==4){
			if(alea<25)
				coor.setCoor(cheminsDispo.get(0).getX(), cheminsDispo.get(0).getY());
			else if(alea>=25 && alea < 50)
				coor.setCoor(cheminsDispo.get(1).getX(), cheminsDispo.get(1).getY());
			else if(alea >= 50 && alea < 75)
				coor.setCoor(cheminsDispo.get(2).getX(), cheminsDispo.get(2).getY());
			else
				coor.setCoor(cheminsDispo.get(3).getX(), cheminsDispo.get(3).getY());
		}
		return coor;
	}
}
