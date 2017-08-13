package model.ennemis;

import model.EnnemiModel;
import model.TerrainModel;
import model.deplacement.DeplacementBFS;
/**
 * Cette classe fait partie des 6 classes d'ennemis. Elle est fille de EnnemiModel
 * Cet ennemi a pour caractéristiques :
 * PV: 15
 * Valeur : 1
 * Deplacement : BFS
 */
public class Exercice extends EnnemiModel{
	
	public Exercice(int x, int y, TerrainModel terrain, String matiere){
		super(x,y,terrain,15,matiere,1);
	}
	
	public void seDeplace(){
		deplacement = new DeplacementBFS();
		this.coor = deplacement.seDeplace(terrain, this.coor);
	}

}
