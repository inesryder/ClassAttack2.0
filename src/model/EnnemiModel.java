package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import model.deplacement.Deplacement;
import model.deplacement.DeplacementBFS;
/**
 * Cette classe créé les ennemis et leur assigne leurs différents attributs
 * Elle est abstraite car on ne peut que créer un des ennemis disponibles dans le jeu. Les sous-classes sont dans le package ennemis
 */
public abstract class EnnemiModel {

	protected Coor coor; // La position de l'ennemi dans le tableau du terrain
	protected TerrainModel terrain; // le terrainModel pour accéder aux différentes caractéristiques de celui-ci
	protected Deplacement deplacement; // le type de déplacement de l'ennemi. Il en existe 3 : BFS,Balise,Aleatoire
	private IntegerProperty pv; // Les points de vie de l'ennemi; Ceux-ci change durant la durée de vie de l'ennemi
	private int pvMax; // La valeurs Initiale des points de vie de l'ennemis cette variable ne peut etre modifiée
	private int valeur; // La somme d'argent qu'il va rapporter au joueur lorsqu'il sera tué
	private String spe; // Specialisation de l'ennemi : Informatique ou Sciences Humaines
	private String matiere; // Matière de spécialisation de l'ennemi. Info : Programation , Base de Données, Programation Web. S.Humaines : Anglais, Economie, Communication

	public EnnemiModel(int x, int y, TerrainModel terrain,int pv,String mat, int valeur) {
		this.coor = new Coor(x, y);
		this.terrain = terrain;
		this.pv= new SimpleIntegerProperty(pv);
		this.pvMax = pv;
		this.matiere=mat;
		this.valeur = valeur;
		if (matiere.equals("eco") || matiere.equals("anglais") || matiere.equals("com"))
			this.spe = "art";
		else if (matiere.equals("prog") || matiere.equals("bd") || matiere.equals("web"))
			this.spe = "info";
		else
			this.spe = "";
	}

	/**
	 * Cette fonction est créée de base dans la classe abstraite pour qu'un ennemi d'une sous-classe n'ayant pas de déplacement précis utilise le déplacement BFS
	 */
	public void seDeplace() {
		deplacement = new DeplacementBFS();
		this.coor = deplacement.seDeplace(terrain, this.coor); 
	}
	
	/**
	 * Cette fonction permet d'infliger des dégats a l'ennemi. Il perd la valeur envoyée en parametre
	 * @param attaque : la quantité de dégats infligés a l'ennemi
	 */
	public void infligerDommage(int attaque){
		this.pv.setValue(pv.getValue()-attaque);
		if(this.pv.getValue()<0){
			disparait();
		}
	}
	
	/**
	 * Permet de savoir si l'ennemi est arrivé au bout du terrain
	 * @return renvoit oui ou non sous forme d'un booleen
	 */
	public boolean arriveADestination() {
			if (coor.getX() == terrain.getSortie().getX() && coor.getY() == terrain.getSortie().getY())
				return true;
			else
			return false;
	 }
	
	public void disparait() {
		setCoor(-1, -1);
	}

	
	// Getters and Setters
	public Coor getCoor() {
		return this.coor;
	}

	public int getX() {
		return coor.getX();
	}

	public int getY() {
		return coor.getY();
	}

	public void setCoor(int x, int y) {
		coor.setCoor(x, y);
	}
	
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int getPv() {
		return pv.getValue();
	}
	
	public IntegerProperty pvProperty() {
		return pv;
	}

	public void setPv(int pv) {
		this.pv.setValue(pv);;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String specialisation) {
		this.matiere = specialisation;
	}
	
	public String getSpe() {
		return spe;
	}
	
	public int getPvMax() {
		return pvMax;
	}
	
	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}
	
	@Override
	public String toString() {
		return "coor: " +this.coor.toString();
	}
}