

package model.vague;

import model.TerrainModel;
import model.ennemis.DevoirLendemain;
import model.ennemis.Dissertation;
import model.ennemis.Dm;
import model.ennemis.Exercice;
import model.ennemis.Projet;
import model.ennemis.WTH;

public class VagueA2T3 extends Vague{

	public VagueA2T3(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		
		int alea;
		for(int i=0;i<30;i++){
			alea = (int) (Math.random() *100);
		
		if(alea<20)
			liste.add(liste.size(), new Exercice(xEntree, yEntree, terrain, ""));
		else if(alea >= 20 && alea < 40 )
			liste.add(liste.size(), new Dm(xEntree, yEntree, terrain, ""));
		else if(alea >=40 && alea<59)
			liste.add(liste.size(), new DevoirLendemain(xEntree, yEntree, terrain, ""));
		else if(alea >=59 && alea<60)
			liste.add(liste.size(), new WTH(xEntree, yEntree, terrain));
		else if(alea >= 60 && alea<80)
			liste.add(liste.size(), new Dissertation(xEntree, yEntree, terrain, ""));
		else
			liste.add(liste.size(), new Projet(xEntree, yEntree, terrain, ""));
		}
	}
}
