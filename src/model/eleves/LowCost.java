package model.eleves;

import model.Coor;
import model.EleveModel;
import model.attaque.AttaqueClassique;
/**
 * Cette classe fait partie des 6 classes d'élèves. Elle est fille de EleveModel
 * Cet élève a pour caractéristiques :
 * Dégats : 5
 * Type d'attaque : Attaque Classique
 */
public class LowCost extends EleveModel {

	public LowCost(int posX, int posY){
		super(posX,posY,5, new AttaqueClassique(new Coor(posX,posY)));
	}
}
