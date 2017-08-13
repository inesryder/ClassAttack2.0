package view;

import model.eleves.BonEleve;
import model.eleves.Faillot;
import model.eleves.LeSpecial;
import model.eleves.LowCost;
import model.eleves.Major;
import model.eleves.MultiTache;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.EleveModel;
/**
 * Cette classe permet l'affichage des Elèves 
 *
 */
public class EleveView {

	private EleveModel e;
	private ImageView me;
	private ImageView matiere;
	private ImageView portee;
	private char typePortee; // 0 pour classique, 1 pour croix

	/**
	 * Celon le type d'élève, une sprite lui est donnée
	 * @param eleve le model de l'élève a qui on attribut une sprite
	 */
	public EleveView(EleveModel eleve) {
		typePortee = 0;
		e = eleve;
		
			if(eleve instanceof BonEleve)
				me = new ImageView("/img/BonEleve-50.gif");	
			else if(eleve instanceof LowCost)
				me = new ImageView("/img/LowCost-50.gif");	
			else if(eleve instanceof Faillot)
				me = new ImageView("/img/Faillot-50.gif");	
			else if(eleve instanceof MultiTache)
				me = new ImageView("/img/Multitache-50.gif");
			else if(eleve instanceof LeSpecial) {
				me = new ImageView("/img/Special-50.gif");
				typePortee = 1;
			}else if(eleve instanceof Major)
				me = new ImageView("/img/Major-50.gif");
		
		portee = new ImageView("/img/portee-trans.png");
		
		if (!eleve.getMatiere().equals("")) {
			if (eleve.getMatiere().equals("prog"))
				matiere = new ImageView("/img/matieres/prog.gif");
			else if (eleve.getMatiere().equals("web"))
				matiere = new ImageView("/img/matieres/web.gif");
			else if (eleve.getMatiere().equals("bd"))
				matiere = new ImageView("/img/matieres/bd.gif");
			else if (eleve.getMatiere().equals("eco"))
				matiere = new ImageView("/img/matieres/eco.gif");
			else if (eleve.getMatiere().equals("anglais"))
				matiere = new ImageView("/img/matieres/anglais.gif");
			else if (eleve.getMatiere().equals("com"))
				matiere = new ImageView("/img/matieres/com.gif");
		}
		else
			matiere = new ImageView();
	}

	/**
	 * Permet l'affichage de la zone de distance d'attaque de l'élève
	 * @param pane le pane principal du jeu
	 */
	public void start(Pane pane) {
		pane.getChildren().add(me);
		pane.getChildren().add(portee);
		if (!matiere.equals(null))
			pane.getChildren().add(matiere);
		me.setOnMouseEntered(event -> {
			if (typePortee == 1)
				portee.setImage(new Image("/img/porteeCroix.png"));
			else
				portee.setImage(new Image("/img/portee.png"));
		});
		me.setOnMouseExited(event -> {
			portee.setImage(new Image("/img/portee-trans.png"));
		});
		me.setOnMouseClicked(event -> {
			controller.Controller.getUpgrade().setEleve(e);
		});
	}

	public void refreshPortee() {
		portee.setLayoutX(me.getLayoutX() - 100);
		portee.setLayoutY(me.getLayoutY() - 100);
	}
	
	public void setX(int x) {
		me.setLayoutX(x * 50);
		portee.setX(x * 50 - 50);
	}

	public void setY(int y) {
		me.setLayoutY(y * 50);
		portee.setY(y * 50 - 50);
	}
	
	public void setPortee(int x, int y) {
		portee.setLayoutX(x*50-50);
		portee.setLayoutY(y*50-50);
	}

	public void setCoor(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public ImageView getImage() {
		return this.me;
	}
	
	public ImageView getMatiere() {
		return this.matiere;
	}
}
