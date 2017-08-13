package view;

import java.util.ArrayList;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.EleveModel;
import view.MatiereView;
import view.SpeView;

/**
 * Cette classe créé l'affichage du menu d'amelioration des ennemis
 *
 */
public class UpgradeMenu {

	Pane root = new Pane();
	private EleveModel eleve;
	private int ame;
	private String spe;
	private String mat;
	private IntegerProperty argent = new SimpleIntegerProperty(0);
	Label attaqueEleve1 = new Label();
	Label speEleve1 = new Label();
	Label matiereEleve1 = new Label();
	private VBox pane1Container = new VBox();
	private VBox pane2Container = new VBox();
	private VBox pane3infoContainer = new VBox();
	private VBox pane4Container = new VBox();
	private VBox pane5Container = new VBox();
	private VBox pane3ArtContainer = new VBox();
	VBox pane0 = new VBox();
	ArrayList <Button> listeButton = new ArrayList <Button>();
	ArrayList <VBox> listeContainer = new ArrayList <VBox>();
	ArrayList <HBox> listeBox = new ArrayList <HBox>();
	
	public void start(Pane root) {
		
		this.root = root;
		listeContainer.add(pane1Container);
		listeContainer.add(pane2Container);
		listeContainer.add(pane4Container);
		listeContainer.add(pane5Container);
		listeContainer.add(pane3infoContainer);
		listeContainer.add(pane3ArtContainer);
		
		pane0.getChildren().add(new Label("Cliquez sur un élève placé pour accéder au menu d'améliorations"));
		
		//Pane 1
		Pane pane1 = new Pane();
		pane1.setPrefHeight(250);
		pane1.setPrefWidth(400);
		Label titre1 = new Label("Élève upgrade");
		titre1.setPrefHeight(50);
		titre1.setPadding(new Insets(0,0,0,150));
		Label attaque1 = new Label("Attaque : ");
		Label spe1 = new Label("Spécialisation : ");
		Label matiere1 = new Label("Matière : ");
		Button specialisation = new Button("Spécialiser");
		listeButton.add(specialisation);
		Button amelioration = new Button("Améliorer");
		listeButton.add(amelioration);
		
		HBox box1_1 = new HBox();
		listeBox.add(box1_1);
		HBox box1_2 = new HBox();
		listeBox.add(box1_2);
		HBox box1_3 = new HBox();
		listeBox.add(box1_3);
		HBox box1_4 = new HBox();
		listeBox.add(box1_4);
		box1_1.getChildren().add(attaque1);
		box1_1.getChildren().add(attaqueEleve1);
		box1_2.getChildren().add(spe1);
		box1_2.getChildren().add(speEleve1);
		box1_3.getChildren().add(matiere1);
		box1_3.getChildren().add(matiereEleve1);
		box1_4.getChildren().add(specialisation);
		box1_4.getChildren().add(amelioration);
		pane1Container.getChildren().add(titre1);
		pane1Container.getChildren().add(box1_1);
		pane1Container.getChildren().add(box1_2);
		pane1Container.getChildren().add(box1_3);
		pane1Container.getChildren().add(box1_4);
		pane1.getChildren().add(pane1Container);
		
		// Pane 2
		Pane pane2 = new Pane();
		pane2.setPrefHeight(250);
		pane2.setPrefWidth(400);
		Label titre2 = new Label("Élève upgrade");
		titre2.setPrefHeight(50);
		titre2.setPadding(new Insets(0,0,0,150));
		pane2Container.getChildren().add(titre2);
		Button retour2 = new Button("Retour");
		listeButton.add(retour2);
		Button info = new Button("Informatique");
		listeButton.add(info);
		Button art = new Button("Sciences Humaines");
		listeButton.add(art);
		ImageView coin2 = new ImageView("/img/compteurs/coin.gif");
		Label money2 = new Label();
		money2.setPrefHeight(30);
		Button valider2 = new Button("Valider");
		listeButton.add(valider2);
		
		
		HBox box2_1 = new HBox();
		listeBox.add(box2_1);
		box2_1.getChildren().add(info);
		box2_1.getChildren().add(art);
		HBox box2_2 = new HBox();
		listeBox.add(box2_2);
		box2_2.getChildren().add(coin2);
		box2_2.getChildren().add(money2);
		pane2Container.getChildren().add(retour2);
		pane2Container.getChildren().add(box2_1);
		pane2Container.getChildren().add(box2_2);
		pane2Container.getChildren().add(valider2);
		pane2.getChildren().add(pane2Container);

		
		// Pane 3 Info
		Pane pane3info = new Pane();
		pane3info.setPrefHeight(250);
		pane3info.setPrefWidth(400);
		Label titre3info = new Label("Élève upgrade");
		titre3info.setPrefHeight(50);
		titre3info.setPadding(new Insets(0,0,0,150));
		pane3infoContainer.getChildren().add(titre3info);
		Button retour3info = new Button("Retour");
		listeButton.add(retour3info);
		ImageView coin3info = new ImageView("/img/compteurs/coin.gif");
		Button ameInfo1 = new Button("Prog");
		listeButton.add(ameInfo1);
		Button ameInfo2 = new Button("BD");
		listeButton.add(ameInfo2);
		Button ameInfo3 = new Button("Web");
		listeButton.add(ameInfo3);
		Label money3 = new Label();
		money3.setPrefHeight(30);
		Button valider3 = new Button("Valider");
		listeButton.add(valider3);
		
		
		pane3infoContainer.getChildren().add(retour3info);
		HBox boxInfo1 = new HBox();
		listeBox.add(boxInfo1);
		boxInfo1.getChildren().add(ameInfo1);
		boxInfo1.getChildren().add(ameInfo2);
		boxInfo1.getChildren().add(ameInfo3);
		pane3infoContainer.getChildren().add(boxInfo1);
		HBox boxInfo2 = new HBox();
		listeBox.add(boxInfo2);
		boxInfo2.getChildren().add(coin3info);
		boxInfo2.getChildren().add(money3);
		pane3infoContainer.getChildren().add(boxInfo2);
		pane3infoContainer.getChildren().add(valider3);

		
		// Pane 3 Art
		Pane pane3Art = new Pane();
		pane3Art.setPrefHeight(250);
		pane3Art.setPrefWidth(400);
		Label titre3art = new Label("Élève upgrade");
		titre3art.setPrefHeight(50);
		titre3art.setPadding(new Insets(0,0,0,150));
		pane3ArtContainer.getChildren().add(titre3art);
		Button retour3art = new Button("Retour");
		listeButton.add(retour3art);
		retour3art.setStyle("-fx-background-color : #efb158");
		ImageView coin3art = new ImageView("/img/compteurs/coin.gif");
		Button ameArt1 = new Button("Eco");
		listeButton.add(ameArt1);
		Button ameArt2 = new Button("Com");
		listeButton.add(ameArt2);
		Button ameArt3 = new Button("Anglais");
		listeButton.add(ameArt3);
		Label money3Art = new Label();
		money3Art.setPrefHeight(30);
		Button valider3Art = new Button("Valider");
		listeButton.add(valider3Art);

		
		pane3ArtContainer.getChildren().add(retour3art);
		HBox boxArt1 = new HBox();
		listeBox.add(boxArt1);
		boxArt1.getChildren().add(ameArt1);
		boxArt1.getChildren().add(ameArt2);
		boxArt1.getChildren().add(ameArt3);
		pane3ArtContainer.getChildren().add(boxArt1);
		HBox boxArt2 = new HBox();
		listeBox.add(boxArt2);
		boxArt2.getChildren().add(coin3art);
		boxArt2.getChildren().add(money3Art);
		pane3ArtContainer.getChildren().add(boxArt2);
		pane3ArtContainer.getChildren().add(valider3Art);
		
		// Pane 4
		Pane pane4 = new Pane();
		pane4.setPrefHeight(250);
		pane4.setPrefWidth(400);
		Label titre4 = new Label("Élève upgrade");
		titre4.setPrefHeight(50);
		titre4.setPadding(new Insets(0,0,0,150));
		pane4Container.getChildren().add(titre4);
		Label up = new Label("Déjà up");
		Button retour4 = new Button("Retour");
		listeButton.add(retour4);
		
		
		pane4Container.getChildren().add(retour4);
		pane4Container.getChildren().add(up);
		
		// Pane 5
		Pane pane5 = new Pane();
		pane5.setPrefHeight(250);
		pane5.setPrefWidth(400);
		Label titre5 = new Label("Élève upgrade");
		titre5.setPrefHeight(50);
		titre5.setPadding(new Insets(0,0,0,150));
		pane5Container.getChildren().add(titre5);
		Button retour5 = new Button("Retour");
		listeButton.add(retour5);
		ImageView coin5 = new ImageView("/img/compteurs/coin.gif");
		Button up1 = new Button("1");
		listeButton.add(up1);
		Button up2 = new Button("2");
		listeButton.add(up2);
		Button up3 = new Button("3");
		listeButton.add(up3);
		Button up4 = new Button("4");
		listeButton.add(up4);
		Button up5 = new Button("5");
		listeButton.add(up5);
		Label money5 = new Label();
		money5.setPrefHeight(30);
		Button valider5 = new Button("Valider");
		listeButton.add(valider5);
		
		
		pane5Container.getChildren().add(retour5);
		HBox box5 = new HBox();
		listeBox.add(box5);
		box5.getChildren().add(up1);
		box5.getChildren().add(up2);
		box5.getChildren().add(up3);
		box5.getChildren().add(up4);
		box5.getChildren().add(up5);
		HBox boxMoney = new HBox();
		listeBox.add(boxMoney);
		boxMoney.getChildren().add(coin5);
		boxMoney.getChildren().add(money5);
		pane5Container.getChildren().add(box5);
		pane5Container.getChildren().add(boxMoney);
		pane5Container.getChildren().add(valider5);
		
		root.getChildren().add(pane0);
		
		// Pane 1 Events
		specialisation.setOnAction(event -> {
			if (eleve.getSpe().equals("")) {
				root.getChildren().removeAll(pane1Container);
				root.getChildren().add(pane2Container);
			}
			else {
				if (eleve.getMatiere().equals("")) {
					if (eleve.getSpe().equals("info")) {
						root.getChildren().removeAll(pane1Container);
						root.getChildren().add(pane3infoContainer);
					}
					else {
						root.getChildren().removeAll(pane1Container);
						root.getChildren().add(pane3ArtContainer);
					}
						
				}
				else {
					root.getChildren().removeAll(pane1Container);
					root.getChildren().add(pane4Container);
				}
			}
		});
		
		amelioration.setOnAction(event -> {
			root.getChildren().removeAll(pane1Container);
			root.getChildren().add(pane5Container);
		});
		
		
		// Pane 2 Events
		valider2.setOnAction(event -> {
			if (model.GameModel.debiterArgent(argent.getValue()) && spe != null) {
				System.out.println(spe);
				setSpeEleve();
				backToTop();
			}
			nettoyage();
		});
		info.setOnAction(event -> {
			spe = "info";
			argent.setValue(20);
		});
		art.setOnAction(event -> {
			spe = "art";
			argent.setValue(20);
		});
		
		// Pane 3 info Events
		ameInfo1.setOnAction(event -> {
			mat = "prog";
			argent.setValue(30);
		});
		ameInfo2.setOnAction(event -> {
			mat = "bd";
			argent.setValue(30);
		});
		ameInfo3.setOnAction(event -> {
			mat = "web";
			argent.setValue(30);
		});
		valider3.setOnAction(event -> {
			if (model.GameModel.debiterArgent(argent.getValue()) && mat != null) {
				setMatiereEleve();
				backToTop();
			}
			nettoyage();
		});
		
		// Pane 3 art Events
		ameArt1.setOnAction(event -> {
			mat = "eco";
			argent.setValue(30);
		});
		ameArt2.setOnAction(event -> {
			mat = "com";
			argent.setValue(30);
		});
		ameArt3.setOnAction(event -> {
			mat = "anglais";
			argent.setValue(30);
		});
		valider3Art.setOnAction(event -> {
			if (model.GameModel.debiterArgent(argent.getValue()) && mat != null) {
				setMatiereEleve();
				backToTop();
			}
			nettoyage();
		});
		
		// Pane 5 Events
		up1.setOnAction(event -> {
			ame = 1;
			argent.setValue(10);
		});
		up2.setOnAction(event -> {
			ame = 2;
			argent.setValue(20);
		});
		up3.setOnAction(event -> {
			ame = 3;
			argent.setValue(30);
		});
		up4.setOnAction(event -> {
			ame = 4;
			argent.setValue(40);
		});
		up5.setOnAction(event -> {
			ame = 5;
			argent.setValue(50);
		});
		valider5.setOnAction(event -> {
			if (model.GameModel.debiterArgent(argent.getValue()) && ame != 0) {
				ameliorer();
				backToTop();
			}			
			nettoyage();
		});
		
		// Retour Events
		retour2.setOnAction(event -> {
			backToTop();
			nettoyage();
		});
		retour3info.setOnAction(event -> {
			backToTop();
			nettoyage();
		});
		retour3art.setOnAction(event -> {
			backToTop();
			nettoyage();
		});
		retour4.setOnAction(event -> {
			backToTop();
			nettoyage();
		});
		retour5.setOnAction(event -> {
			backToTop();
			nettoyage();
		});
		
		// Money Events		
		money2.textProperty().bind(argent.asString());
		money3.textProperty().bind(argent.asString());
		money3Art.textProperty().bind(argent.asString());
		money5.textProperty().bind(argent.asString());
		
		// CSS
		for (Button b : listeButton) {
			b.setPadding(new Insets(5,5,5,5));
			b.setStyle("-fx-background-color : #efb158");
			b.setOnMouseEntered(event -> {
				b.setStyle("-fx-background-color : #f3c17a");
			});
			b.setOnMouseExited(event -> {
				b.setStyle("-fx-background-color : #efb158");
			});
		}
		for (VBox v : listeContainer) {
			v.setSpacing(10);
		}
		for (HBox h : listeBox) {
			h.setSpacing(10);
		}
	}
	
	/**
	 * Permet d'afficher les nouvelles statistiques de l'élève séléctionné
	 */
	public void refreshStat() {
		attaqueEleve1.setText(Integer.toString(eleve.getAttaque()));
		if (eleve.getSpe().equals(""))
			speEleve1.setText("aucun");
		else if (eleve.getSpe().equals("info"))
			speEleve1.setText("Informatique");
		else
			speEleve1.setText("Sciences Humaines");
		if (eleve.getMatiere().equals(""))
			matiereEleve1.setText("aucun");
		else
			matiereEleve1.setText(eleve.getMatiere());
	}
	
	/**
	 * augmente l'attaque de l'élève
	 */
	public void ameliorer() {
		if (ame != 0) {
			eleve.augmenteAttaque(ame);
			refreshStat();
		}
		ame = 0;
	}
	
	/**
	 * Reinitialise les attributs de la classe
	 */
	public void nettoyage() {
		spe = null;
		ame = 0;
		mat = null;
		argent.setValue(0);
	}
	
	/**
	 * Remet l'affichage de base (enlève les sous-menus)
	 */
	public void backToTop() {
		root.getChildren().removeAll(pane1Container,pane2Container, pane3infoContainer, pane3ArtContainer, pane4Container, pane5Container, pane0);
		root.getChildren().add(pane1Container);
	}
	
	public void setEleve(EleveModel e) {
		eleve = e;
		refreshStat();
		backToTop();
	}
	
	
	public void setSpeEleve() {
		if (spe != null) {
			eleve.setSpe(spe);
			SpeView s = new SpeView(eleve);
			s.start(controller.Controller.getPaneGame());
			refreshStat();
			spe = null;
		}
		spe = null;
	}
	
	public void setMatiereEleve() {
		if (mat != null) {
			eleve.setMatiere(mat);
			MatiereView m = new MatiereView(eleve);
			m.start(controller.Controller.getPaneGame());
			refreshStat();
		}
		mat = null;
	}
}
