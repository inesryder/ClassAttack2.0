package model.vague;

import model.TerrainModel;
import model.ennemis.DevoirLendemain;
import model.ennemis.Dissertation;
import model.ennemis.Dm;
import model.ennemis.Projet;

public class VagueA2T1 extends Vague{

	public VagueA2T1(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		for(int i =0 ;i<40;i++){
			if(i % 2 ==0 && !(i%10==0) && !(i%20==0))
				liste.add(liste.size(), new Dm(xEntree, yEntree, terrain, ""));
			else if(i % 3 == 0)
				liste.add(liste.size(), new DevoirLendemain(xEntree, yEntree, terrain, ""));
			else if(i % 10 == 0)
				liste.add(liste.size(), new Dissertation(xEntree, yEntree, terrain, ""));
			else if(i % 20 == 0)
				liste.add(liste.size(), new Projet(xEntree, yEntree, terrain, ""));
				
			
		}
	}
}
