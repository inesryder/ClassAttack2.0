package model.attaque;

import javafx.collections.ObservableList;
import model.Coor;
import model.EnnemiModel;
/**
 * Cette attaque est l'attaque de base. Elle permet d'attaquer un ennemi dans une zone de une case autour de l'élève.
 *
 */
public class AttaqueClassique extends Attaque {

	public AttaqueClassique(Coor c) {
		super(c);
	}

	public void attaque(int att, ObservableList<EnnemiModel> listeEnnemis) {
		EnnemiModel ennemi = this.scanEnnemi(listeEnnemis);
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
	 * Cette fonction scan les ennemis au environ et retourne l'ennemi le plus
	 * haut placé dans la liste
	 * 
	 * @param listeEnnemis
	 *            : liste de tous les ennemis présent sur le plateau
	 * @return le premier ennemi de la liste qui se trouve à portée de
	 *         l'attaquant
	 */
	public EnnemiModel scanEnnemi(ObservableList<EnnemiModel> listeEnnemis) {
		for (int i = 0; i < listeEnnemis.size(); i++) {
			if (this.estAdjacent(listeEnnemis.get(i)))
				return listeEnnemis.get(i);
		}
		return null;
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
