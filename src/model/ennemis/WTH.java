package model.ennemis;

import java.util.concurrent.ThreadLocalRandom;
import model.deplacement.DeplacementAleatoire;
import model.EnnemiModel;
import model.TerrainModel;
/**
 * Cette classe fait partie des 6 classes d'ennemis. Elle est fille de EnnemiModel
 * Cet ennemi a pour caractéristiques :
 * PV: Aleatoire entre 30 et 150
 * Valeur : 7
 * Deplacement : Aleatoire
 */
public class WTH extends EnnemiModel{
	
	public WTH(int x, int y, TerrainModel terrain){
		super(x,y,terrain,ThreadLocalRandom.current().nextInt(30, 150 + 1),"",7);
		// coorX,coorY,PV,typeGeneral,matiere,effet)
	}
	
	public void seDeplace(){
		deplacement = new DeplacementAleatoire();
		this.coor = deplacement.seDeplace(terrain, this.coor);
	}
}
