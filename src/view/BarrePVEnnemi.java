package view;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;

/**
 * Cette classe permet l'affichage de la barre de point de vie des ennemis
 *
 */
public class BarrePVEnnemi{

	private Rectangle rectangleViePleine; 
	private Rectangle rectangleVieVide;
	private Pane pane;
	private int pvMax;
	
	/**
	 * Création de la barre grace à deux rectangles
	 * @param pvMax défini les points de vie maximaux de l'ennemi possedant la barre de Pv
	 */
	public BarrePVEnnemi(int pvMax){
		
		this.pvMax = pvMax;
		rectangleVieVide = new Rectangle(45, 3);
		rectangleVieVide.setStroke(Color.BLACK);
		rectangleVieVide.setStrokeWidth(2);
		rectangleVieVide.setStrokeType(StrokeType.OUTSIDE);
		rectangleVieVide.setFill(Color.RED);
		
		rectangleViePleine = new Rectangle(45,3);
		rectangleViePleine.setStrokeType(StrokeType.OUTSIDE);
		rectangleViePleine.setFill(Color.LIMEGREEN);
		
		pane = new Pane();
		pane.setPrefHeight(50);
		pane.setPrefWidth(50);
		pane.getChildren().add(rectangleVieVide);
		pane.getChildren().add(rectangleViePleine);
	}
	
	public void start(Pane root) {
		root.getChildren().add(pane);
		
	}
	
	/**
	 * Fait disparaitre la barre
	 */
	public void Degage() {
		pane.setLayoutX(-100);
		pane.setLayoutY(-100);
	}

	public Pane getPane() {
		return pane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}
	
	public void setCoor(int x, int y) {
		pane.setLayoutX(x*50);
		pane.setLayoutY(y*50);
	}
	
	
	public Rectangle getRectangleViePleine() {
		return rectangleViePleine;
	}

	public void setRectangleViePleine(Rectangle rectangleViePleine) {
		this.rectangleViePleine = rectangleViePleine;
	}

	public int getPvMax() {
		return pvMax;
	}

	public void setPvMax(int pvMax) {
		this.pvMax = pvMax;
	}
	
	public void setRectangleViePleineWidth(double widthBarre){
		rectangleViePleine.setWidth(widthBarre);
	}
	
	public double getRectangleViePleineWidth(){
		return rectangleViePleine.getWidth();
	}
}
