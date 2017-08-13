package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.EleveModel;
/**
 * 
 *Cette classe permet l'affichage du symbole de matière des élèves (cercle de couleur en bas a gauche de l'élève)
 */
public class MatiereView {

	ImageView matiere = new ImageView();
	EleveModel e;
	
	public MatiereView(EleveModel eleve) {
		e = eleve;
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
	
	public void start(Pane pane) {
		pane.getChildren().add(matiere);
		matiere.setLayoutX(e.getX() * 50);
		matiere.setLayoutY(e.getY() * 50);
	}
}
