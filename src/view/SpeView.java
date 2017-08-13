package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.EleveModel;
/**
 * 
 *Cette classe permet l'affichage du symbole de spécialisation des élèves (petit I ou petit H en haut a droite d'un élève)
 */
public class SpeView {

	ImageView spe = new ImageView();
	EleveModel e;
	
	public SpeView(EleveModel e) {
		this.e = e;
		if (e.getSpe().equals("info"))
			spe = new ImageView("/img/spe/info.gif");
		else
			spe = new ImageView("/img/spe/art.gif");
	}
	
	public void start(Pane pane) {
		pane.getChildren().add(spe);
		spe.setLayoutX(e.getX() * 50);
		spe.setLayoutY(e.getY() * 50);
	}
}
