package model.attaque;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import model.Coor;
import model.EnnemiModel;
/**
 * Cette classe ne peut etre créée. Elle définit la base des attaques disponibles pour les élèves. Elle possède 4 classes filles.
 */
public abstract class Attaque {
	
	Coor coor; //Coordonnée de l'élève
	StringProperty spe;// Specialisation de l'élève : Informatique ou Sciences Humaines
	StringProperty matiere; // Matière de spécialisation de l'élève. Info : Programation , Base de Données, Programation Web. S.Humaines : Anglais, Economie, Communication
	
	public Attaque(Coor c) {
		this.coor = c;
		spe = new SimpleStringProperty("");
		matiere = new SimpleStringProperty("");
	}
	
	//Abstract Class
	public abstract void attaque(int att, ObservableList<EnnemiModel> listeEnnemis);
	
	//Getters and Setters
	public Coor getCoor() {
		return this.coor;
	}
	
	public StringProperty speProperty() {
		return spe;
	}
	
	public StringProperty matiereProperty() {
		return matiere;
	}
}