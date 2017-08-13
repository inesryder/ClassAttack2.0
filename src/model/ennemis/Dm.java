package model.ennemis;

import model.deplacement.DeplacementBalise;
import model.EnnemiModel;
import model.TerrainModel;
/**
 * Cette classe fait partie des 6 classes d'ennemis. Elle est fille de EnnemiModel
 * Cet ennemi a pour caractéristiques :
 * PV: 30
 * Valeur : 2
 * Deplacement : Balise
 */
public class Dm extends EnnemiModel {

	private String oldPosition;
	
	public Dm(int x, int y, TerrainModel terrain,String matiere){
		super(x,y,terrain,30,matiere,2);
		// coorX,coorY,PV,typeGeneral,matiere,effet)
	}
	
	public void seDeplace(){
		DeplacementBalise deplacement = new DeplacementBalise();
		deplacement.setOldPosition(oldPosition);
		this.coor = deplacement.seDeplace(terrain, this.coor);
		oldPosition = deplacement.getOldPosition();
	}
}
