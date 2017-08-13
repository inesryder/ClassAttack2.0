package model.vague;

import model.TerrainModel;
/**
 * Cette classe est utilisée pour redefinir la fonction definitionSpe() de manière a n'inclure que 3 spe au lieu de 6
 * Elle ne peut etre créée et contient 3 sous-classes.
 *
 */
public abstract class VagueA3 extends Vague{

	public VagueA3(TerrainModel terrain) {
		super(terrain);
	}
	
	public String definitionSpe(){
		int alea = (int) (Math.random() *30);
		
		if(alea < 10)
			return eco;
		else if(alea >=10 && alea < 20)
			return ang;
		else
			return com;
		
		
	}

}
