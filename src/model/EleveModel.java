package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import model.attaque.Attaque;
/**
 * Cette classe créé les élèves et leur assigne leurs différentes capacitées et leurs différents attributs
 * Elle est abstraite car on ne peut que créer un des élèves disponibles dans le jeu. Les sous-classes sont dans le package eleves
 */
public abstract class EleveModel {

	private Coor coor;//Position de l'élève dans le tableau
	private int attaque;// Nombre de dégats que l'élève infligera
	private StringProperty spe; // Specialisation de l'élève : Informatique ou Sciences Humaines
	private StringProperty matiere; // Matière de spécialisation de l'élève. Info : Programation , Base de Données, Programation Web. S.Humaines : Anglais, Economie, Communication
	private Attaque stratAttaque; // Le type d'attaque de l'élève (voir package eleves)

	public EleveModel(int posX, int posY,int attaque, Attaque strAtt){
		this.coor=new Coor(posX,posY);
		this.attaque=attaque;
		this.spe = new SimpleStringProperty();
		this.matiere = new SimpleStringProperty();
		this.stratAttaque = strAtt;
		this.spe.bindBidirectional(stratAttaque.speProperty());
		spe.setValue("");
		this.matiere.bindBidirectional(stratAttaque.matiereProperty());
		matiere.setValue("");
	}
	
	/**
	 * Permet de lancer l'action d'attaquer pour l'élève
	 * @param listeEnnemis :  la liste des ennemis sur le terrain
	 */
	public void attaque(ObservableList<EnnemiModel> listeEnnemis) {
		stratAttaque.attaque(attaque, listeEnnemis);
	}
	
	/**
	 * Augmente l'attribut attaque de l'élève
	 * @param aug : la valeur a ajouter a l'attribut
	 */
	public void augmenteAttaque(int aug) {
		this.attaque += aug;
	}

	// Getters and Setters
	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public Attaque getStratAttaque() {
		return stratAttaque;
	}

	public void setStratAttaque(Attaque stratAttaque) {
		this.stratAttaque = stratAttaque;
	}
	
	public void setCoor(int posX, int posY) {
		coor.setX(posX);
		coor.setY(posY);
	}
	
	public void setCoor(Coor coor) {
		this.coor = coor;
	}

	public int getX() {
		return coor.getX();
	}

	public int getY() {
		return coor.getY();
	}

	public Coor getCoor() {
		return this.coor;
	}
	
	public String getSpe() {
		return this.spe.getValue();
	}

	public void setSpe(String spe) {
		this.spe.setValue(spe);
	}

	public String getMatiere() {
		return matiere.getValue();
	}

	public void setMatiere(String matiere) {
		this.matiere.setValue(matiere);
	}
}
