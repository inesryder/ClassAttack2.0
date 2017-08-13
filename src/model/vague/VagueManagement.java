package model.vague;

import model.TerrainModel;

/**
 * Cette classe permet d'initialiser une vague selon l'avancée du joueur dans le jeu
 * VagueA1T1 siginifie vague annee 1 trimestre 1
 * VagueA4S1 siginifie vague annee 4 semestre 1
 * 
 * @author erivetti
 *
 */
public class VagueManagement {

	private Vague vagueActuelle;
	private TerrainModel terrain;
	
	public VagueManagement(TerrainModel terrain){
		this.terrain = terrain;
	}
	
	public void initVague(int annee, int trimestre) {
		switch (annee) {
		case 1:
			switch (trimestre){
			case 1:
				vagueActuelle = new VagueA1T1(terrain);
				break;
			case 2:
				vagueActuelle = new VagueA1T2(terrain);
				break;
			case 3:
				vagueActuelle = new VagueA1T3(terrain);
				break;
			}
			break;
		case 2:
			switch (trimestre){
			case 1:
				vagueActuelle = new VagueA2T1(terrain);
				break;
			case 2:
				vagueActuelle = new VagueA2T2(terrain);
				break;
			case 3:
				vagueActuelle = new VagueA2T3(terrain);
				break;
			}
			break;
		case 3:
			switch (trimestre){
			case 1:
				vagueActuelle = new VagueA3T1(terrain);
				break;
			case 2:
				vagueActuelle = new VagueA3T2(terrain);
				break;
			case 3:
				vagueActuelle = new VagueA3T3(terrain);
				break;
			}
			break;
		case 4:
			switch (trimestre){
			case 1:
				vagueActuelle = new VagueA4S1(terrain);
				break;
			case 2:
				vagueActuelle = new VagueA4S2(terrain);
				break;
			}
			break;
		case 5:
			switch (trimestre){
			case 1:
				vagueActuelle = new VagueA5S1(terrain);
				break;
			case 2:
				vagueActuelle = new VagueA5S2(terrain);
				break;
			}
			break;
		}
	}

	//Getters and Setters
	public Vague getVagueActuelle() {
		return vagueActuelle;
	}

	public void setVagueActuelle(Vague vagueActuelle) {
		this.vagueActuelle = vagueActuelle;
	}
}
