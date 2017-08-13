package model.vague;

import model.TerrainModel;
import model.ennemis.Projet;
import model.ennemis.WTH;

public class VagueA5S2 extends Vague{

	public VagueA5S2(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		
		for(int i=0;i<150;i++){
			liste.add(liste.size(), new WTH(xEntree, yEntree, terrain));
			if(i%2==0)
				liste.add(liste.size(), new Projet(xEntree, yEntree, terrain,definitionSpe()));
		
		}
	}
}
