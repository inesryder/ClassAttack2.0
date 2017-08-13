package model.vague;

import java.util.ArrayList;

import model.EnnemiModel;
import model.TerrainModel;
/**
 * Cette classe défini une vague. Elle ne peut etre créée et possède 14 sous classes.
 * Chaque sous classe posséde la focntion initVague() qui créé des listes d'ennemis. Les sous classes ne seront pas commentées exepté VagueA3.
 */
public abstract class Vague {

	protected ArrayList<EnnemiModel> liste; // la liste contenant les ennemis de la vague
	protected TerrainModel terrain;
	protected String neutre;
	protected String prog;
	protected String web;
	protected String bd;
	protected String eco;
	protected String ang;
	protected String com;
	protected int xEntree;
	protected int yEntree;

	public Vague(TerrainModel terrain) {
		this.liste = new ArrayList<EnnemiModel>();
		this.terrain = terrain;
		neutre = "";
		prog = "prog";
		web = "web";
		bd = "bd";
		eco = "eco";
		ang = "anglais";
		com = "com";
		initVague();
	}

	/**
	 * Ajoute un ennemi a la vague
	 * @param e
	 */
	public void add(EnnemiModel e) {
		liste.add(e);
	}
	
	/**
	 * Permet de séléctionner aleatoirement une spécialisation
	 * @return un string contenant la spécialisation
	 */
	public String definitionSpe(){
		int alea = (int) (Math.random() *70);
		
		if(alea < 10)
			return neutre;
		else if(alea >=10 && alea < 20)
			return prog;
		else if(alea >=20 && alea < 30)
			return web;
		else if(alea >=30 && alea < 40)
			return bd;
		else if(alea >=40 && alea < 50)
			return eco;
		else if(alea >=50 && alea < 60)
			return ang;
		else
			return com;
	}

	//Abstract Class
	public abstract void initVague();
	
	//Getters and Setters
	public ArrayList<EnnemiModel> getListe() {
		return this.liste;
	}
	
}
