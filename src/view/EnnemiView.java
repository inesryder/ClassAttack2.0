package view;

import model.ennemis.DevoirLendemain;
import model.ennemis.Dissertation;
import model.ennemis.Dm;
import model.ennemis.Exercice;
import model.ennemis.Projet;
import model.ennemis.WTH;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.EnnemiModel;
/**
 * Cette classe permet l'affichage des ennemis sur le terrain
 *
 */
public class EnnemiView {

	private ImageView me;

	/**
	 * Celon chaque type d'ennemi, une sprite lui est donné. Celon sa spécialisation, sa sprite diffère
	 * @param ennemi le model de l'ennemi a qui on attribut une sprite
	 */
	public EnnemiView(EnnemiModel ennemi) {
		if (ennemi instanceof WTH)
			me = new ImageView("/img/spriteEnnemi/WTH/wth.gif");
		else if (ennemi.getMatiere().equals("")) {
			if (ennemi instanceof DevoirLendemain)
				me = new ImageView("/img/spriteEnnemi/devoirLendemain/devoirLendemain.gif");
			else if (ennemi instanceof Dissertation)
				me = new ImageView("/img/spriteEnnemi/dissertation/dissertation.gif");
			else if (ennemi instanceof Dm)
				me = new ImageView("/img/spriteEnnemi/dm/dm.gif");
			else if (ennemi instanceof Exercice)
				me = new ImageView("/img/spriteEnnemi/exercices/exercices.gif");
			else if (ennemi instanceof Projet)
				me = new ImageView("/img/spriteEnnemi/projet/projet.gif");
		}
		
		// Prog
		else if (ennemi.getMatiere().equals("prog")) {
			if (ennemi instanceof DevoirLendemain)
				me = new ImageView("/img/spriteEnnemi/devoirLendemain/devoirLendemainProg.gif");
			else if (ennemi instanceof Dissertation)
				me = new ImageView("/img/spriteEnnemi/dissertation/dissertationProg.gif");
			else if (ennemi instanceof Dm)
				me = new ImageView("/img/spriteEnnemi/dm/dmProg.gif");
			else if (ennemi instanceof Exercice)
				me = new ImageView("/img/spriteEnnemi/exercices/exercicesProg.gif");
			else if (ennemi instanceof Projet)
				me = new ImageView("/img/spriteEnnemi/projet/projetProg.gif");
		}
		
		// BD
		else if (ennemi.getMatiere().equals("bd")) {
			if (ennemi instanceof DevoirLendemain)
				me = new ImageView("/img/spriteEnnemi/devoirLendemain/devoirLendemainBD.gif");
			else if (ennemi instanceof Dissertation)
				me = new ImageView("/img/spriteEnnemi/dissertation/dissertationBD.gif");
			else if (ennemi instanceof Dm)
				me = new ImageView("/img/spriteEnnemi/dm/dmBD.gif");
			else if (ennemi instanceof Exercice)
				me = new ImageView("/img/spriteEnnemi/exercices/exercicesBD.gif");
			else if (ennemi instanceof Projet)
				me = new ImageView("/img/spriteEnnemi/projet/projetBD.gif");
		}
		
		// Web
		else if (ennemi.getMatiere().equals("web")) {
			if (ennemi instanceof DevoirLendemain)
				me = new ImageView("/img/spriteEnnemi/devoirLendemain/devoirLendemainWeb.gif");
			else if (ennemi instanceof Dissertation)
				me = new ImageView("/img/spriteEnnemi/dissertation/dissertationWeb.gif");
			else if (ennemi instanceof Dm)
				me = new ImageView("/img/spriteEnnemi/dm/dmWeb.gif");
			else if (ennemi instanceof Exercice)
				me = new ImageView("/img/spriteEnnemi/exercices/exercicesWeb.gif");
			else if (ennemi instanceof Projet)
				me = new ImageView("/img/spriteEnnemi/projet/projetWeb.gif");
		}
		
		// Eco
		else if (ennemi.getMatiere().equals("eco")) {
			if (ennemi instanceof DevoirLendemain)
				me = new ImageView("/img/spriteEnnemi/devoirLendemain/devoirLendemainEco.gif");
			else if (ennemi instanceof Dissertation)
				me = new ImageView("/img/spriteEnnemi/dissertation/dissertationEco.gif");
			else if (ennemi instanceof Dm)
				me = new ImageView("/img/spriteEnnemi/dm/dmEco.gif");
			else if (ennemi instanceof Exercice)
				me = new ImageView("/img/spriteEnnemi/exercices/exercicesEco.gif");
			else if (ennemi instanceof Projet)
				me = new ImageView("/img/spriteEnnemi/projet/projetEco.gif");
		}
		
		// Anglais
		else if (ennemi.getMatiere().equals("anglais")) {
			if (ennemi instanceof DevoirLendemain)
				me = new ImageView("/img/spriteEnnemi/devoirLendemain/devoirLendemainAnglais.gif");
			else if (ennemi instanceof Dissertation)
				me = new ImageView("/img/spriteEnnemi/dissertation/dissertationAnglais.gif");
			else if (ennemi instanceof Dm)
				me = new ImageView("/img/spriteEnnemi/dm/dmAnglais.gif");
			else if (ennemi instanceof Exercice)
				me = new ImageView("/img/spriteEnnemi/exercices/exercicesAnglais.gif");
			else if (ennemi instanceof Projet)
				me = new ImageView("/img/spriteEnnemi/projet/projetAnglais.gif");
		}
		
		// Com
		else if (ennemi.getMatiere().equals("com")) {
			if (ennemi instanceof DevoirLendemain)
				me = new ImageView("/img/spriteEnnemi/devoirLendemain/devoirLendemainCom.gif");
			else if (ennemi instanceof Dissertation)
				me = new ImageView("/img/spriteEnnemi/dissertation/dissertationCom.gif");
			else if (ennemi instanceof Dm)
				me = new ImageView("/img/spriteEnnemi/dm/dmCom.gif");
			else if (ennemi instanceof Exercice)
				me = new ImageView("/img/spriteEnnemi/exercices/exercicesCom.gif");
			else if (ennemi instanceof Projet)
				me = new ImageView("/img/spriteEnnemi/projet/projetCom.gif");
		}
	}

	public void start(Pane pane) {
		pane.getChildren().add(me);
	}

	public void setX(int x) {
		me.setLayoutX(x * 50);
	}

	public void setY(int y) {
		me.setLayoutY(y * 50);
	}

	public void setCoor(int x, int y) {
		setX(x);
		setY(y);
	}

	public ImageView getImage() {
		return this.me;
	}
}
