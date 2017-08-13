package model.eleves;

import model.Coor;
import model.EleveModel;
import model.attaque.AttaqueCroix;
/**
 * Cette classe fait partie des 6 classes d'élèves. Elle est fille de EleveModel
 * Cet élève a pour caractéristiques :
 * Dégats : 7
 * Type d'attaque : Attaque Croix
 */
public class LeSpecial extends EleveModel{

	public LeSpecial(int posX, int posY){
			super(posX,posY,7, new AttaqueCroix(new Coor(posX,posY)));
			
	}
}
