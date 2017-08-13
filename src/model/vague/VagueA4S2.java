package model.vague;

import model.TerrainModel;
import model.ennemis.DevoirLendemain;
import model.ennemis.Dissertation;
import model.ennemis.Dm;
import model.ennemis.Exercice;
import model.ennemis.Projet;
import model.ennemis.WTH;

public class VagueA4S2 extends Vague{

	public VagueA4S2(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		int alea;
		for(int i=0;i<100;i++){
			alea = (int) (Math.random() *100);
		
		if(alea<15)
			liste.add(liste.size(), new Exercice(xEntree, yEntree, terrain, definitionSpe()));
		else if(alea >= 15 && alea < 25 )
			liste.add(liste.size(), new Dm(xEntree, yEntree, terrain, definitionSpe()));
		else if(alea >=25 && alea<33)
			liste.add(liste.size(), new DevoirLendemain(xEntree, yEntree, terrain, definitionSpe()));
		else if(alea >=33 && alea<50)
			liste.add(liste.size(), new WTH(xEntree, yEntree, terrain));
		else if(alea >= 50 && alea<71)
			liste.add(liste.size(), new Dissertation(xEntree, yEntree, terrain, definitionSpe()));
		else
			liste.add(liste.size(), new Projet(xEntree, yEntree, terrain, definitionSpe()));
		}
	}
}
