package model.ennemis;
import model.deplacement.DeplacementBFS;
import model.EnnemiModel;
import model.TerrainModel;
/**
 * Cette classe fait partie des 6 classes d'ennemis. Elle est fille de EnnemiModel
 * Cet ennemi a pour caractéristiques :
 * PV: 120
 * Valeur : 10
 * Deplacement : BFS
 */
public class Projet extends EnnemiModel{

	public Projet(int x, int y, TerrainModel terrain, String matiere){
		super(x,y,terrain,120,matiere,10);
	}
	
	public void seDeplace(){
		deplacement = new DeplacementBFS();
		this.coor = deplacement.seDeplace(terrain, this.coor);
	}
}
