package model.eleves;

import model.Coor;
import model.EleveModel;
import model.attaque.AttaqueMulti;
/**
 * Cette classe fait partie des 6 classes d'élèves. Elle est fille de EleveModel
 * Cet élève a pour caractéristiques :
 * Dégats : 7
 * Type d'attaque : Attaque Multi
 */
public class MultiTache extends EleveModel {

	public MultiTache(int posX, int posY){
		super(posX,posY,7, new AttaqueMulti(new Coor(posX,posY)));
	}
	
}
