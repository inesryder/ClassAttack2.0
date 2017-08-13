package model.vague;

import model.TerrainModel;

import model.ennemis.Dissertation;
import model.ennemis.Projet;

public class VagueA5S1 extends Vague{

	public VagueA5S1(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		int alea;
		for(int i=0;i<100;i++){
			alea = (int) (Math.random() *100);
		if(alea < 50)
			liste.add(liste.size(), new Dissertation(xEntree, yEntree, terrain, definitionSpe()));
		else
			liste.add(liste.size(), new Projet(xEntree, yEntree, terrain, definitionSpe()));
		}
	}
}
