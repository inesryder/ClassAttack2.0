package model.vague;

import model.TerrainModel;
import model.ennemis.Dm;
import model.ennemis.Exercice;
public class VagueA1T1 extends Vague{

	public VagueA1T1(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		for(int i=0;i<20;i++){
			liste.add(liste.size(), new Exercice(xEntree, yEntree, terrain, ""));
			if(i%5==0)
				liste.add(liste.size(), new Dm(xEntree, yEntree, terrain, ""));
		}
	}
}
