package model.eleves;

import model.Coor;
import model.EleveModel;
import model.attaque.AttaqueClassique;
/**
 * Cette classe fait partie des 6 classes d'élèves. Elle est fille de EleveModel
 * Cet élève a pour caractéristiques :
 * Dégats : 10
 * Type d'attaque : Attaque Classique
 */
public class Faillot extends EleveModel{

	public Faillot(int posX, int posY){
		super(posX,posY,10, new AttaqueClassique(new Coor(posX,posY)));
	}

}
