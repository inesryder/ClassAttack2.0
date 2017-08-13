package model.vague;

import model.TerrainModel;
import model.ennemis.DevoirLendemain;
import model.ennemis.Dm;
import model.ennemis.Exercice;

public class VagueA1T2 extends Vague{

	public VagueA1T2(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		liste.add(liste.size(), new DevoirLendemain(xEntree, yEntree, terrain, ""));
		for(int i=0;i<15;i++){
			liste.add(liste.size(), new Exercice(xEntree, yEntree, terrain, ""));
			if(i%5==0)
				liste.add(liste.size(), new Dm(xEntree, yEntree, terrain, ""));
		}
		liste.add(liste.size(), new DevoirLendemain(xEntree, yEntree, terrain, ""));
		
	}
}
