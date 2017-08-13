package model.attaque;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import model.Coor;
import model.EnnemiModel;
/**
 * Cette attaque permet a l'élève d'ataquer 2 ennemis dans une zone de une case autour de lui.
 *
 */
public class AttaqueMulti extends Attaque{

	public AttaqueMulti(Coor c) {
		super(c);
	}

	/**
	 * Attaque deux ennemis adjacents à l'attaquant (les deux plus haut placés
	 * dans la liste d'ennemis)
	 * 
	 * @param att
	 *            force d'attaque
	 * @param listeEnnemis
	 *            liste de tous les ennemis sur le plateau
	 */
	public void attaque(int att, ObservableList<EnnemiModel> listeEnnemis) {
		ArrayList<EnnemiModel> listeCondamnes = this.scanEnnemi(listeEnnemis);
		for (EnnemiModel e : listeCondamnes) {
			attaqueUnEnnemi(e, att, listeEnnemis);
		}
		
	}
	
	/**
	 * Attaque un seul ennemi
	 * 
	 * @param ennemi
	 *            l'ennemi à attaquer
	 * @param att
	 *            force d'attaque
	 * @param listeEnnemis
	 *            liste de tous les ennemis sur le plateau
	 */
	public void attaqueUnEnnemi(EnnemiModel ennemi, int att, ObservableList<EnnemiModel> listeEnnemis) {
		if (ennemi != null) {
			if (ennemi.getSpe().equals(super.spe.getValue()) && !ennemi.getSpe().equals("")) {
				if (ennemi.getMatiere().equals(super.matiere.getValue())) 
					ennemi.infligerDommage(att * 3);
				else
					ennemi.infligerDommage(att * 2);
			} else
				ennemi.infligerDommage(att);
			if (ennemi.getPv() <= 0) {
				listeEnnemis.remove(ennemi);
			}
		}
	}

	/**
	 * Cette fonction scan les ennemis aux environs et retourne les deux ennemis les plus
	 * haut placés dans la liste
	 * 
	 * @param listeEnnemis
	 *            : liste de tous les ennemis présent sur le plateau
	 * @return le premier ennemi de la liste qui se trouve à portée de
	 *         l'attaquant
	 */
	public ArrayList<EnnemiModel> scanEnnemi(ObservableList<EnnemiModel> listeEnnemis) {
		ArrayList<EnnemiModel> listeCondamnes = new ArrayList<EnnemiModel>();
		int j = 0;
		for (int i = 0; i < listeEnnemis.size(); i++) {
			if (this.estAdjacent(listeEnnemis.get(i)) && j < 2) {
				listeCondamnes.add(listeEnnemis.get(i));
				j++;
			}
		}
		return listeCondamnes;
	}

	/**
	 * Cette fonction prend en paramètre un ennemi et retourne vrai s'il est sur
	 * une case adjacente à l(attanquant. Le cas contraire, il retourne faux
	 * 
	 * @param e
	 *            : un ennemi dont on veut vérifier s'il est adjcent à l'attaquant
	 * @return un boolean
	 */
	public boolean estAdjacent(EnnemiModel e) {
		if (coor.estAdjacent(e.getCoor()))
			return true;
		else
			return false;
	}
	
}
