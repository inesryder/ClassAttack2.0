package model;

import java.util.Map;
/**
 * Cette classe permet de créer le terrain de jeu via un tableau d'entier. Elle permet aussi de connaitre les differentes valeurs des cases de ce tableau via des fonctions
 *  de vérification
 *
 */
public class TerrainModel {

	private int[][] map; // le terrain. Il est composé d'entier représentant différentes case (voir en-dessous des tableaux pour connaitre la signification des valeurs)
	private Coord[][] mapCoor; // un tableau rempli des coordonnées de chaque case
	private Map<Coord, Integer> BFS; // Le BFS du terrain
	
	/**
	 * Créé les tableaux vides 
	 */
	public TerrainModel() {
		map = new int[15][15];
		mapCoor = new Coord[15][15];
	}
	/**
	 * Celon le niveau séléctionné, créé le terrain adequat
	 * @param lvl : numero de niveau 
	 */
	public void initLevel(int lvl) {
		switch (lvl) {
		case 1:
			initlevel1();
			break;
		case 2:
			initlevel2();
			break;
		case 3:
			initlevel3();
			break;
		}
	}
	
	/*
	* Permet de vérifier si la case contient un mur ou une table
	*/
	public boolean verificationCheminObstrue(int x, int y){
		if(verificationCheminObstrueMur(x, y) || verificationCheminObstrueTable(x,y))
			return true;//Le chemin est obstrué
		else
			return false;//Le chemin est libre, l'ennemi peut avancer
	}

	/*
	* Permet de vérifier si la case contient un mur
	*/
	public boolean verificationCheminObstrueMur(int x, int y){
		if(getTileValue(x, y) == 2 || getTileValue(x, y) == 6)
			return true;//Le chemin est obstrué par un mur
		else
			return false;//Le chemin n'est pas obstrué par un mur
	}

	/*
	* Permet de vérifier si la case contient une table
	*/
	public boolean verificationCheminObstrueTable(int x, int y){
		if(getTileValue(x, y) == 1 || getTileValue(x, y) == 3)
			return true;//Le chemin est obstrué par une table
		else
			return false;//Le chemin n'est pas obstrué par une table
	}

	/**
	 * Créé le tableau du niveau 1
	 */
	public void initlevel1() {
						// 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14
		int[][] map = { { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, // 0
						 { 2, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 1
						 { 2, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 2 }, // 2
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 3
						 { 2, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 2 }, // 4
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 5
						 { 2, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 2 }, // 6
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 7
						 { 2, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 2 }, // 8
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 9
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2 }, // 10
						 { 2, 1, 1, 0, 0, 0, 4, 6, 0, 0, 0, 1, 0, 0, 2 }, // 11
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 12
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 13
						 { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 2, 2 } };// 14
		

		/*
		 * 0 -> chemin ; 1 -> table ; 2 -> wall ; 3 -> porte ; 4 -> entree ; 5 -> sortie
		 */

		for( int i = 0 ; i < 15 ; i++) {
			for (int j = 0 ; j < 15 ; j++) {
				this.map[i][j] = map[i][j];
			}
		}
	}
	
	/**
	 * Créé le tableau du niveau 2
	 */
	public void initlevel2() {
				// 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14
		 int[][] map = { { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, // 0
						 { 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 5, 2 }, // 1
						 { 2, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 2 }, // 2
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 3
						 { 2, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2 }, // 4
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 5
						 { 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 2 }, // 6
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 7
						 { 2, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 2 }, // 8
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 9
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2 }, // 10
						 { 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 2 }, // 11
						 { 2, 0, 0, 0, 0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 3 }, // 12
						 { 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 13
						 { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 } };// 14
		
		/*
		* 0 -> chemin ; 1 -> table ; 2 -> wall ; 3 -> porte ; 4 -> entree ; 5 -> sortie
		*/
		
		for( int i = 0 ; i < 15 ; i++) {
			for (int j = 0 ; j < 15 ; j++) {
				this.map[i][j] = map[i][j];
			}
		}
	}	
	
	/**
	 * Créé le tableau du niveau 1
	 */
	public void initlevel3() {
					   // 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14
		int[][] map = { { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 }, // 0
						{ 2, 1, 1, 1, 0, 0, 0, 5, 0, 0, 0, 1, 1, 1, 2 }, // 1
						{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 2
						{ 2, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2 }, // 3
						{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 4
						{ 2, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2 }, // 5
						{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 6
						{ 2, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2 }, // 7
						{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 8
						{ 2, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 2 }, // 9
						{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 10
						{ 2, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 2 }, // 11
						{ 3, 0, 1, 1, 0, 0, 0, 4, 6, 0, 0, 1, 1, 0, 2 }, // 12
						{ 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2 }, // 13
						{ 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2 } };// 14

			/*
	    	* 0 -> chemin ; 1 -> table ; 2 -> wall ; 3 -> porte ; 4 -> entree ; 5 -> sortie
			*/
		
			for( int i = 0 ; i < 15 ; i++) {
			for (int j = 0 ; j < 15 ; j++) {
				this.map[i][j] = map[i][j];
			}
		}	
	}

	//Getters and Setters
	public void setMapCoor(){
		for (int i=0; i < 15; i++) {
			for (int j=0; j < 15; j++) {
				Coord c = new Coord(i,j);
				this.mapCoor[i][j] = c;
			}
		}
	}
	
	public Coord[][] getMapCoor() {
		return mapCoor;
	}
	
	public Coord getCoorFromMapCoor(int x,int y){
		return this.mapCoor[x][y];
	}

	public void setMapCoor(Coord[][] mapCoor) {
		this.mapCoor = mapCoor;
	}

	public int getTileValue(int x, int y) {
		return map[y][x];
	}

	public int[][] getMap() {
		return this.map;
	}

	public Coor getEntree() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (getTileValue(i, j) == 4) {
					return new Coor(i, j);
				}
			}
		}
		return null;
	}

	public Coor getSortie() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (getTileValue(i, j) == 5) {
					return new Coor(i, j);
				}
			}
		}
		return null;
	}
	
	public Map<Coord, Integer> getBFS() {
		return this.BFS;
	}
	
	public void setBFS(Map<Coord, Integer> bfs) {
		this.BFS = bfs;
	}
}
