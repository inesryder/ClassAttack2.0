package model.vague;

import model.TerrainModel;
import model.ennemis.DevoirLendemain;
import model.ennemis.Dissertation;
import model.ennemis.Dm;
import model.ennemis.Exercice;
import model.ennemis.Projet;
import model.ennemis.WTH;


/**
 * 
 * @author erivetti
 *
 */
public class VagueA4S1 extends Vague{

	public VagueA4S1(TerrainModel terrain) {
		super(terrain);
	}	
	
	public void initVague() {
		xEntree = terrain.getEntree().getX();
		yEntree = terrain.getEntree().getY();
		int alea;
		for(int i=0;i<45;i++){
			alea = (int) (Math.random() *100);
		
		if(alea<5)
			liste.add(liste.size(), new Exercice(xEntree, yEntree, terrain, definitionSpe()));
		else if(alea >= 5 && alea < 10 )
			liste.add(liste.size(), new Dm(xEntree, yEntree, terrain, definitionSpe()));
		else if(alea >=10 && alea<15)
			liste.add(liste.size(), new DevoirLendemain(xEntree, yEntree, terrain, definitionSpe()));
		else if(alea >=15 && alea<30)
			liste.add(liste.size(), new WTH(xEntree, yEntree, terrain));
		else if(alea >= 30 && alea<50)
			liste.add(liste.size(), new Dissertation(xEntree, yEntree, terrain, definitionSpe()));
		else
			liste.add(liste.size(), new Projet(xEntree, yEntree, terrain, definitionSpe()));
		}
	}
}
