package model.eleves;

import model.Coor;
import model.EleveModel;
import model.attaque.AttaqueComplete;
/**
 * Cette classe fait partie des 6 classes d'élèves. Elle est fille de EleveModel
 * Cet élève a pour caractéristiques :
 * Dégats : 15
 * Type d'attaque : Attaque Complete (comme les crëpes)
 */
public class Major extends EleveModel{

	
	public Major(int posX, int posY){
		super(posX,posY,15, new AttaqueComplete(new Coor(posX,posY)));
				
}

}
