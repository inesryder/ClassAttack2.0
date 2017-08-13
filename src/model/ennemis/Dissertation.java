package model.ennemis;

import model.deplacement.DeplacementBalise;
import model.EnnemiModel;
import model.TerrainModel;
/**
 * Cette classe fait partie des 6 classes d'ennemis. Elle est fille de EnnemiModel
 * Cet ennemi a pour caractéristiques :
 * PV: 90
 * Valeur : 9
 * Deplacement : Balise
 */
public class Dissertation extends EnnemiModel {

	private String oldPosition;
	
	public Dissertation (int x, int y, TerrainModel terrain, String matiere){
		super(x,y,terrain,90,matiere,9);
		// coorX,coorY,PV,typeGeneral,matiere,effet)
	}
	
	public void seDeplace(){
		DeplacementBalise deplacement = new DeplacementBalise();
		deplacement.setOldPosition(oldPosition);
		this.coor = deplacement.seDeplace(terrain, this.coor);
		oldPosition = deplacement.getOldPosition();
	}
}
