package view;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * 
 *Cette classe définie la vue de la scène de séléction des niveaux
 */
public class LevelMenu {

	Image level1 = new Image("/img/boutons-level/button-level1.png");
	Image level1Hover = new Image("/img/boutons-level/button-level1-hover.png");
	Image level2 = new Image("/img/boutons-level/button-level2.png");
	Image level2Hover = new Image("/img/boutons-level/button-level2-hover.png");
	Image level3 = new Image("/img/boutons-level/button-level3.png");
	Image level3Hover = new Image("/img/boutons-level/button-level3-hover.png");
	ImageView title = new ImageView("/img/boutons-level/ClassAttack.png");
	ImageView lvl1Button = new ImageView(level1);
	ImageView lvl2Button = new ImageView(level2);
	ImageView lvl3Button = new ImageView(level3);
	
	public void start(Pane root) {
		
		title.setLayoutX(200);
		title.setLayoutY(150);
		root.getChildren().add(title);
		lvl1Button.setLayoutX(0);
		lvl1Button.setLayoutY(300);
		lvl2Button.setLayoutX(400);
		lvl2Button.setLayoutY(300);
		lvl3Button.setLayoutX(800);
		lvl3Button.setLayoutY(300);
		root.getChildren().add(lvl1Button);
		root.getChildren().add(lvl2Button);
		root.getChildren().add(lvl3Button);
		root.setBackground(new Background(new BackgroundFill(Color.web("#fff7c0"), CornerRadii.EMPTY, Insets.EMPTY)));
		
		lvl1Button.setOnMouseEntered(event -> lvl1Button.setImage(level1Hover));
		lvl1Button.setOnMouseExited(event -> lvl1Button.setImage(level1));
		lvl2Button.setOnMouseEntered(event -> lvl2Button.setImage(level2Hover));
		lvl2Button.setOnMouseExited(event -> lvl2Button.setImage(level2));
		lvl3Button.setOnMouseEntered(event -> lvl3Button.setImage(level3Hover));
		lvl3Button.setOnMouseExited(event -> lvl3Button.setImage(level3));	
	}
	
	public ImageView getlvl1() {
		return lvl1Button;
	}
	public ImageView getlvl2() {
		return lvl2Button;
	}
	public ImageView getlvl3() {
		return lvl3Button;
	}
}
