package model.vague;

import model.TerrainModel;
import model.ennemis.Dm;
import model.ennemis.Exercice;
import model.ennemis.Projet;

public class VagueA1T3 extends Vague{

	public VagueA1T3(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		
		liste.add(liste.size(), new Dm(xEntree, yEntree, terrain, ""));
		liste.add(liste.size(), new Projet(xEntree, yEntree, terrain, ""));
		for(int i=0;i<25;i++){
			liste.add(liste.size(), new Exercice(xEntree, yEntree, terrain, ""));
		}
		liste.add(liste.size(), new Projet(xEntree, yEntree, terrain, ""));
	}
}
