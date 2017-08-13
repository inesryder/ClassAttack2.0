package model;

/**
 * Il s'agit là de la même classe que Coor mais possède comme attributs des Integer et non des IntegerProperty qui empeche le fonctionnement des Map
 * @author Ellmo
 *
 */
public class Coord {

	private int x;
	private int y;
	
	/**
	 * permet de créer une Coord depuis une Coor
	 * @param c : Coor originelle
	 */
	public Coord(Coor c){
		x = c.getX();
		y = c.getY();
	}
	
	public Coord(int x,int y){
		this.x=x;
		this.y=y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Coord other = (Coord) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "x=" + x + ", y=" + y;
	}

	
	// Getters and Setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
