package view;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
/**
 * Cette classe créé la vue du menu de selection d'élève a placer
 *
 */
public class ButtonMenu {

	ArrayList <Button> liste = new ArrayList <Button>();
	Button lowCost = new Button();
	Button bonEleve = new Button();
	Button multiTache = new Button();
	Button faillot = new Button();
	Button special = new Button();
	Button major = new Button();
	
	public void start(VBox root) {
		
		GridPane paneButton = new GridPane();
		paneButton.setHgap(5);
		paneButton.setVgap(5);
		
		liste.add(lowCost);
		liste.add(bonEleve);
		liste.add(multiTache);
		liste.add(faillot);
		liste.add(special);
		liste.add(major);
		
		for (Button b : liste) {
			b.setPrefWidth(200);
			b.setPrefHeight(100);
			b.setStyle("-fx-background-color : #efb158");
			b.setOnMouseEntered(event -> {
				b.setStyle("-fx-background-color : #f3c17a");
			});
			b.setOnMouseExited(event -> {
				b.setStyle("-fx-background-color : #efb158");
			});
		}
		
		lowCost.setGraphic(new ImageView("/img/LowCost.gif"));
		lowCost.setText("Low-Cost");
		bonEleve.setGraphic(new ImageView("/img/BonEleve.gif"));
		bonEleve.setText("Bon Élève");
		multiTache.setGraphic(new ImageView("/img/Multitache.gif"));
		multiTache.setText("Multitache");
		faillot.setGraphic(new ImageView("/img/Faillot.gif"));
		faillot.setText("Faillot");
		special.setGraphic(new ImageView("/img/Special.gif"));
		special.setText("Spécial");
		major.setGraphic(new ImageView("/img/Major.gif"));
		major.setText("Major");
		
		paneButton.add(lowCost, 0, 0);
		paneButton.add(bonEleve, 1, 0);
		paneButton.add(multiTache, 0, 1);
		paneButton.add(faillot, 1, 1);
		paneButton.add(special, 0, 2);
		paneButton.add(major, 1, 2);
		
		root.getChildren().add(paneButton);
	}
	
	public Button getLowCost() {
		return lowCost;
	}
	public Button getBonEleve() {
		return bonEleve;
	}
	public Button getMultitache() {
		return multiTache;
	}
	public Button getFaillot() {
		return faillot;
	}
	public Button getSpecial() {
		return special;
	}
	public Button getMajor() {
		return major;
	}	
}
