package model.vague;


import model.TerrainModel;
import model.ennemis.DevoirLendemain;
import model.ennemis.Dissertation;
import model.ennemis.Dm;
import model.ennemis.Exercice;
import model.ennemis.Projet;

public class VagueA2T2 extends Vague{

	public VagueA2T2(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		
		int alea;
		for(int i=0;i<30;i++){
			alea = (int) (Math.random() *100);
		
		if(alea<30)
			liste.add(liste.size(), new Exercice(xEntree, yEntree, terrain, ""));
		else if(alea >= 30 && alea < 50 )
			liste.add(liste.size(), new Dm(xEntree, yEntree, terrain, ""));
		else if(alea >=50 && alea<70)
			liste.add(liste.size(), new DevoirLendemain(xEntree, yEntree, terrain, ""));
		else if(alea >= 70 && alea<90)
			liste.add(liste.size(), new Dissertation(xEntree, yEntree, terrain, ""));
		else
			liste.add(liste.size(), new Projet(xEntree, yEntree, terrain, ""));
		}
		
	}
}
