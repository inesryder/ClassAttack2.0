package model.eleves;

import model.Coor;
import model.EleveModel;
import model.attaque.AttaqueClassique;
/**
 * Cette classe fait partie des 6 classes d'élèves. Elle est fille de EleveModel
 * Cet élève a pour caractéristiques :
 * Dégats : 7
 * Type d'attaque : Attaque Classique
 */
public class BonEleve extends EleveModel{

	public BonEleve(int posX, int posY){
		super(posX,posY,7, new AttaqueClassique(new Coor(posX,posY)));
	}
	
}
