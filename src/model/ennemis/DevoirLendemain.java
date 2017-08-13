package model.ennemis;

import model.deplacement.DeplacementBFS;
import model.EnnemiModel;
import model.TerrainModel;
/**
 * Cette classe fait partie des 6 classes d'ennemis. Elle est fille de EnnemiModel
 * Cet ennemi a pour caractéristiques :
 * PV: 60
 * Valeur : 4
 * Deplacement : BFS
 */
public class DevoirLendemain extends EnnemiModel{

	public DevoirLendemain(int x, int y, TerrainModel terrain,String matiere){
		super(x,y,terrain,60,matiere,4);
	}
	
	public void seDeplace(){
		deplacement = new DeplacementBFS();
		this.coor = deplacement.seDeplace(terrain, this.coor);
	}
	
	
	
}
