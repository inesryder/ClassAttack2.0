package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
/**
 * Cette classe permet de créer un objet Coor qui est utilisé pour définir la position des cases dans le tableau de jeu
 *
 */
public class Coor {

	private IntegerProperty x;
	private IntegerProperty y;

	/**
	 * Creation de l'objet
	 * @param x coordonnée X de la case
	 * @param y coordonnée Y de la case
	 */
	public Coor(int x, int y) {
		this.x = new SimpleIntegerProperty();
		this.y = new SimpleIntegerProperty();
		setCoor(x, y);
	}

	/**
	 * Permet de comparer si deux coordonnées sont adjacentes
	 * @param c : la coordonnée testée 
	 * @return renvoit d'un booleen pour confirmer ou non l'adjacence
	 */
	public boolean estAdjacent(Coor c) {
		if (x.getValue() == c.getX() || x.getValue() == c.getX() + 1 || x.getValue() == c.getX() - 1) {
			if (y.getValue() == c.getY() || y.getValue() == c.getY() + 1 || y.getValue() == c.getY() - 1)
				return true;
			else
				return false;
		} else
			return false;
	}
	
	/**
	 * Permet de vérifier si une case est alignée a une autre horizontalement ou verticalement et située a 2 case de la coordonnée d'origine
	 * @param c : la coordonnée à tester
	 * @return renvoit d'un booleen pour confirmer ou non la position de la case
	 */
	public boolean estADeuxCasesEnLigne(Coor c) {
		if (x.getValue() == c.getX()) {
			if (y.getValue() == c.getY() + 1 || y.getValue() == c.getY() + 2 ||  y.getValue() == c.getY() - 1 || y.getValue() == c.getY() - 2)
				return true;
			else
				return false;
		}
		else if (y.getValue() == c.getY()) {
			if (x.getValue() == c.getX() + 1 || x.getValue() == c.getX() + 2 || x.getValue() == c.getX() - 1 || x.getValue() == c.getX() - 2)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	
	
	// Getters and Setters
	public void setCoor(int x, int y) {
		setX(x);
		setY(y);
	}

	public void setX(int x) {
		this.x.setValue(x);
	}

	public void setY(int y) {
		this.y.setValue(y);
	}

	public IntegerProperty xProperty() {
		return this.x;
	}

	public IntegerProperty yProperty() {
		return this.y;
	}

	public int getX() {
		return this.x.getValue();
	}

	public int getY() {
		return this.y.getValue();
	}

	@Override
	public String toString() {
		return "x=" + getX() + ", y=" + getY();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coor other = (Coor) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
}
