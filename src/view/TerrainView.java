package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import model.TerrainModel;

/**
 * Cette classe permet de créer la vue du terrain de jeu (TerrainModel)
 * 
 */
public class TerrainView {

	private TerrainModel terrain = new TerrainModel();
	private int Lvl;

	/**
	 * Celon la valeur dans le tableau du TerrainModel, une image est ajoutée au TilePane
	 * @param pane  pane de la partie
	 */
	public void start(Pane pane) {
		TilePane root = new TilePane();
		root.setPrefWidth(750);
		root.setPrefHeight(750);
		terrain.initLevel(Lvl);
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {

				switch (terrain.getTileValue(j, i)) {
				case 0:
					ImageView cheminV = new ImageView("/img/chemin.png");
					root.getChildren().add(cheminV);
					break;	
				case 1:
					ImageView tableV = new ImageView("/img/table.png");
					root.getChildren().add(tableV);
					break;
				case 2:
					ImageView wallV = new ImageView("/img/wall.png");
					root.getChildren().add(wallV);
					break;
				case 3:
					ImageView porteV = new ImageView("/img/porte.png");
					root.getChildren().add(porteV);
					break;
				case 4:
					ImageView entreeV = new ImageView("/img/entree.png");
					root.getChildren().add(entreeV);
					break;
				case 5:
					ImageView sortieV = new ImageView("/img/sortie.png");
					root.getChildren().add(sortieV);
					break;
				case 6:
					ImageView entree2 = new ImageView("/img/entree2.png");
					root.getChildren().add(entree2);
					break;
				}
			}
		}
			pane.getChildren().add(root);
	}

	public void setLvl(int lvl) {
		this.Lvl= lvl;
	}

}
