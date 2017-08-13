package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.GameModel;
import model.eleves.BonEleve;
import model.eleves.Faillot;
import model.eleves.LeSpecial;
import model.eleves.LowCost;
import model.eleves.Major;
import model.eleves.MultiTache;
import model.listeners.ArgentDigitListener;
import model.listeners.ListeEleveListener;
import model.listeners.ListeEnnemiListener;
import model.listeners.NoteDigitListener;
import view.ButtonMenu;
import view.LevelMenu;
import view.TerrainView;
import view.UpgradeMenu;
/**
 * Cette classe est la classe mère du programme. C'est elle qui lance les scènes et le jeu. 
 */
public class Controller extends Application {

	private GameModel game; // permet de lancer le programme coté model
	
	static Pane paneGame = new Pane(); // pane principal du jeu
	private TerrainView terrain = new TerrainView(); // permet d'afficher le terrain
	static UpgradeMenu upgrade = new UpgradeMenu(); // permet d'afficher le menu d'amelioration
	private Button boutonVague = new Button("Vague Suivante"); // permet d'afficher le bouton de chnagement de vague
	private ImageView digit1 = new ImageView(); //Premier chiffre compteur de vie
	private ImageView digit2 = new ImageView(); //Deuxieme chiffre compteur de vie
	private ImageView digit3 = new ImageView(); //Premier chiffre compteur d'argent
	private ImageView digit4 = new ImageView(); //Deuxieme chiffre compteur d'argent
	private ImageView digit5 = new ImageView(); //Troisième chiffre compteur d'argent
	private ImageView digit6 = new ImageView(); //Quatrième chiffre compteur d'argent
	private int choixEleve = 0;	// Choix de l'eleve séléctionné grçace au menu
	
	private IntegerProperty laNote = new SimpleIntegerProperty(0); //La quantité de pv du joueur
	private static IntegerProperty argent1 = new SimpleIntegerProperty(0); //La quantité d'argent du joueur
	
	private Timeline gameloop = new Timeline();	// TimeLoop pour effectuer le bon d"roulement du jeu

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setResizable(false);		

		// First Scene
		Pane firstPane = new Pane();
		firstPane.getChildren().add(new ImageView("/img/firstScene/Start-pane.png"));
		firstPane.setPrefWidth(1200);
		firstPane.setPrefHeight(900);
		Image play = new Image("/img/firstScene/button-play.png");
		Image playHover = new Image("/img/firstScene/button-play-hover.png");
		ImageView playButton = new ImageView(play);
		firstPane.getChildren().add(playButton);
		playButton.setLayoutX(400);
		playButton.setLayoutY(200);
		Scene firstScene = new Scene(firstPane, 1200, 900);
		
		//Level select
		Pane secondPane = new Pane();
		secondPane.setPrefWidth(1200);
		secondPane.setPrefHeight(900);
		LevelMenu levelMenu = new LevelMenu();
		levelMenu.start(secondPane);
		Scene secondScene = new Scene(secondPane, 1200, 900);
		
		// Game Over
		Pane lastPane = new Pane();
		lastPane.setBackground(new Background(new BackgroundFill(Color.web("#fff7c0"), CornerRadii.EMPTY, Insets.EMPTY)));
		lastPane.setPrefWidth(1200);
		lastPane.setPrefHeight(900);
		ImageView alpagaHG = new ImageView("/img/alpaga.gif");
		ImageView alpagaHD = new ImageView("/img/alpaga.gif");
		ImageView alpagaBG = new ImageView("/img/alpaga.gif");
		ImageView alpagaBD = new ImageView("/img/alpaga.gif");
		ImageView gameOverImg = new ImageView("/img/gameOver.png");
		alpagaHD.setLayoutX(944);
		alpagaHD.setLayoutY(25);
		alpagaHG.setLayoutY(25);

		alpagaBG.setLayoutX(0);
		alpagaBG.setLayoutY(619);

		alpagaBD.setLayoutX(944);
		alpagaBD.setLayoutY(619);

		gameOverImg.setLayoutX(400);
		gameOverImg.setLayoutY(250);

		lastPane.getChildren().add(alpagaHG);
		lastPane.getChildren().add(alpagaHD);
		lastPane.getChildren().add(alpagaBG);
		lastPane.getChildren().add(alpagaBD);
		lastPane.getChildren().add(gameOverImg);
		Scene gameOver = new Scene(lastPane, 1200, 900);
		
		//Win scene
		Pane winPane = new Pane();
		winPane.setBackground(new Background(new BackgroundFill(Color.web("#fff7c0"), CornerRadii.EMPTY, Insets.EMPTY)));
		lastPane.setPrefWidth(1200);
		lastPane.setPrefHeight(900);
		ImageView win = new ImageView("/img/youWin.png");
		ImageView saucisseHG = new ImageView("/img/saucisse.gif");
		ImageView saucisseHD = new ImageView("/img/saucisse.gif");
		ImageView saucisseBG = new ImageView("/img/saucisse.gif");
		ImageView saucisseBD = new ImageView("/img/saucisse.gif");
		
		saucisseHD.setLayoutX(900);
		
		saucisseBG.setLayoutY(600);
		
		saucisseBD.setLayoutX(900);
		saucisseBD.setLayoutY(600);
		
		win.setLayoutX(300);
		win.setLayoutY(300);
		winPane.getChildren().add(win);
		winPane.getChildren().add(saucisseBD);
		winPane.getChildren().add(saucisseBG);
		winPane.getChildren().add(saucisseHD);
		winPane.getChildren().add(saucisseHG);
		Scene winScene = new Scene(winPane, 1200, 900);
		
		// BorderPane
		BorderPane borderpane = new BorderPane();
		borderpane.setPrefWidth(1200);
		borderpane.setPrefHeight(900);
		
		// Vbox with menus
		VBox vbox = new VBox();
		vbox.setSpacing(10);
		vbox.setPrefWidth(450);
		vbox.setPrefHeight(850);
		vbox.setPadding(new Insets(0, 15, 0, 15));
		vbox.setBackground(new Background(new BackgroundFill(Color.web("#fff7c0"), CornerRadii.EMPTY, Insets.EMPTY)));

		Pane paneUpgrade = new Pane();
		upgrade.start(paneUpgrade);
		paneUpgrade.setPrefHeight(250);
		paneUpgrade.setPrefWidth(400);
		vbox.getChildren().add(paneUpgrade);

		ButtonMenu paneButton = new ButtonMenu();
		paneButton.start(vbox);
		
		Pane paneDescription = new Pane();
		paneDescription.setPrefHeight(250);
		paneDescription.setPrefWidth(400);
		Image descrDefault = new Image("/img/descr/descr-default.png");
		Image descrLowcost = new Image("/img/descr/descr-lowcost.png");
		Image descrBoneleve = new Image("/img/descr/descr-boneleve.png");
		Image descrFaillot = new Image("/img/descr/descr-faillot.png");
		Image descrMajor = new Image("/img/descr/descr-major.png");
		Image descrMultitache = new Image("/img/descr/descr-multitache.png");
		Image descrSpecial = new Image("/img/descr/descr-special.png");
		ImageView description = new ImageView(descrDefault);
		paneDescription.getChildren().add(description);
		vbox.getChildren().add(paneDescription);

		
		// Hbox with parameters
		VBox container = new VBox();
		HBox hbox = new HBox();
		hbox.setPadding(new Insets(20,20,20,20));
		hbox.setSpacing(10);
		ImageView note = new ImageView("/img/compteurs/beat.gif");
		ImageView argent = new ImageView("/img/compteurs/coin.gif");
		HBox noteDigit = new HBox();
		noteDigit.setPadding(new Insets(0,100,0,0));
		noteDigit.getChildren().add(digit1);
		noteDigit.getChildren().add(digit2);
		HBox argentDigit = new HBox();
		argentDigit.getChildren().add(digit3);
		argentDigit.getChildren().add(digit4);
		argentDigit.getChildren().add(digit5);
		argentDigit.getChildren().add(digit6);
		argentDigit.setPadding(new Insets(0,100,0,0));
		argent1.addListener(new ArgentDigitListener(digit3, digit4, digit5, digit6));
		hbox.getChildren().add(note);
		hbox.getChildren().add(noteDigit);
		hbox.getChildren().add(argent);
		hbox.getChildren().add(argentDigit);
		hbox.getChildren().add(boutonVague);
		boutonVague.setPadding(new Insets(10, 20, 10, 20));
		boutonVague.setStyle("-fx-background-color : #efb158");
		boutonVague.setOnMouseEntered(event -> {
		boutonVague.setStyle("-fx-background-color : #f3c17a");
		});
		boutonVague.setOnMouseExited(event -> {
		boutonVague.setStyle("-fx-background-color : #efb158");
		});
		container.setBackground(new Background(new BackgroundFill(Color.web("#fff7c0"), CornerRadii.EMPTY, Insets.EMPTY)));
		container.getChildren().add(paneGame);
		container.getChildren().add(hbox);
		HBox h = new HBox();
		h.setPadding(new Insets(10,0,0,25));
		h.getChildren().add(new ImageView("/img/descr.gif"));
		container.getChildren().add(h);

		
		// Borderpane build
		borderpane.setCenter(container);
		borderpane.setRight(vbox);
		Scene scene = new Scene(borderpane, 1200, 900);

		primaryStage.setScene(firstScene);
		primaryStage.setTitle("Class Attack 2.0");
		primaryStage.show();

		playButton.setOnMouseEntered(event -> {
			playButton.setImage(playHover);
		});
		playButton.setOnMouseExited(event -> {
			playButton.setImage(play);
		});
		playButton.setOnMouseClicked(event -> {
			primaryStage.setScene(secondScene);
		});
		
		levelMenu.getlvl1().setOnMouseClicked(event -> {
			game = new GameModel(1);
			game.setLvl(1);
			primaryStage.setScene(scene);
			initAnimation(primaryStage,winScene);
			paneGame.setPrefWidth(750);
			paneGame.setPrefHeight(750);
			terrain.setLvl(game.getLvl());
			terrain.start(paneGame);
			
			ListeEnnemiListener ennemiListener = new ListeEnnemiListener(paneGame);
			game.getObsEnnemis().addListener(ennemiListener);

			// Eleve Listener
			ListeEleveListener eleveListener = new ListeEleveListener(paneGame);
			game.getObsEleves().addListener(eleveListener);

			laNote.addListener(new NoteDigitListener(digit1, digit2));
			laNote.bind(game.vieProperty());
			argent1.bind(game.argentProperty());
		});
		levelMenu.getlvl2().setOnMouseClicked(event -> {
			game = new GameModel(2);
			game.setLvl(2);
			primaryStage.setScene(scene);
			initAnimation(primaryStage,winScene);
			paneGame.setPrefWidth(750);
			paneGame.setPrefHeight(750);
			terrain.setLvl(game.getLvl());
			terrain.start(paneGame);
			
			ListeEnnemiListener ennemiListener = new ListeEnnemiListener(paneGame);
			game.getObsEnnemis().addListener(ennemiListener);

			// Eleve Listener
			ListeEleveListener eleveListener = new ListeEleveListener(paneGame);
			game.getObsEleves().addListener(eleveListener);

			laNote.addListener(new NoteDigitListener(digit1, digit2));
			laNote.bind(game.vieProperty());
			argent1.bind(game.argentProperty());
		});
		levelMenu.getlvl3().setOnMouseClicked(event -> {
			game = new GameModel(3);
			game.setLvl(3);
			primaryStage.setScene(scene);
			initAnimation(primaryStage,winScene);
			paneGame.setPrefWidth(750);
			paneGame.setPrefHeight(750);
			terrain.setLvl(game.getLvl());
			terrain.start(paneGame);
			
			ListeEnnemiListener ennemiListener = new ListeEnnemiListener(paneGame);
			game.getObsEnnemis().addListener(ennemiListener);

			// Eleve Listener
			ListeEleveListener eleveListener = new ListeEleveListener(paneGame);
			game.getObsEleves().addListener(eleveListener);

			laNote.addListener(new NoteDigitListener(digit1, digit2));
			laNote.bind(game.vieProperty());
			argent1.bind(game.argentProperty());
		});
		
		KeyFrame kfVie = new KeyFrame(Duration.seconds(0.5), (ev -> {
			if(laNote.getValue().equals(0)){	
				gameloop.stop();
				primaryStage.setScene(gameOver);
			}
		}));
		gameloop.getKeyFrames().add(kfVie);
		
		// Event sur boutton clique
		paneButton.getLowCost().setOnAction(event -> {
			choixEleve = 1;
			description.setImage(descrLowcost);
		});
		paneButton.getBonEleve().setOnAction(event -> {
			choixEleve = 2;
			description.setImage(descrBoneleve);
		});
		paneButton.getMultitache().setOnAction(event -> {
			choixEleve = 3;
			description.setImage(descrMultitache);
		});
		paneButton.getFaillot().setOnAction(event -> {
			choixEleve = 4;
			description.setImage(descrFaillot);
		});
		paneButton.getSpecial().setOnAction(event -> {
			choixEleve = 5;
			description.setImage(descrSpecial);
		});
		paneButton.getMajor().setOnAction(event -> {
			choixEleve = 6;
			description.setImage(descrMajor);
		});
		
		paneGame.setOnMouseClicked(event -> {
			int MouseX = (int) (((event.getX() - (event.getX() % 50)) / 50));
			int MouseY = (int) (((event.getY() - (event.getY() % 50)) / 50));
			boolean occupied = false;

			for (int i = 0; i < game.getObsEleves().size(); i++) {
				if (game.getObsEleves().get(i).getX() == MouseX && game.getObsEleves().get(i).getY() == MouseY)
					occupied = true;
			}
			if (game.getTerrain().getTileValue(MouseX, MouseY) == 1 && !occupied) {
				switch (choixEleve) {
				case 1:
					if (GameModel.debiterArgent(Settings.PRIXLOWCOST))
						game.getObsEleves().add(new LowCost(MouseX, MouseY));
					else
						System.out.println("LowCost...");
					choixEleve = 0;
					break;
				case 2:
					if (GameModel.debiterArgent(Settings.PRIXBONELEVE))
						game.getObsEleves().add(new BonEleve(MouseX, MouseY));
					else
						System.out.println("BonEleve...");
					choixEleve = 0;
					break;
				case 3:
					if (GameModel.debiterArgent(Settings.PRIXMULTITACHE))
						game.getObsEleves().add(new MultiTache(MouseX, MouseY));
					else
						System.out.println("MultiTache...");

					choixEleve = 0;
					break;

				case 4:
					if (GameModel.debiterArgent(Settings.PRIXFAILLOT))
						game.getObsEleves().add(new Faillot(MouseX, MouseY));
					else
						System.out.println("Faillot...");

					choixEleve = 0;
					break;
				case 5:
					if (GameModel.debiterArgent(Settings.PRIXSPECIAL))
						game.getObsEleves().add(new LeSpecial(MouseX, MouseY));
					else
						System.out.println("Special...");
					choixEleve = 0;
					break;
				case 6:
					if (GameModel.debiterArgent(Settings.PRIXMAJOR))
						game.getObsEleves().add(new Major(MouseX, MouseY));
					else
						System.out.println("Major...");
					choixEleve = 0;
					break;
				case 0:
					System.out.println("Pas d'élève sélectionné!");
				}
			}
		});
		
		boutonVague.setOnMouseClicked(event ->{
			boutonVague.setDisable(true);
			if(game.getAnnee()<4)
				boutonVague.setText("Annee "+game.getAnnee()+" trimestre "+game.getTrimestre());
			else
				boutonVague.setText("Annee "+game.getAnnee()+" semestre "+game.getTrimestre());
			game.loadVague();
			gameloop.play();
		});
	}
	
	/**
	 * Permet de créer le déplacemnt des ennemis et l'attaque des élèves si les ennemis sont encore présents sur le terrain
	 * @param primaryStage 
	 * @param winScene scene de victoire qui est lancée si le joueur a terminé toute les vagues
	 */
	public void initAnimation(Stage primaryStage, Scene winScene) {
		gameloop.setCycleCount(Timeline.INDEFINITE);
		
		KeyFrame kf = new KeyFrame(Duration.seconds(0.5), (ev -> {
			if(game.noMoreEnnemies()){
				if(game.getTrimestre() == 3 || (game.getAnnee() == 4 && game.getTrimestre() ==2)){
					game.setTrimestre(1);
					game.setAnnee(game.getAnnee()+1);
				}else{
					game.setTrimestre(game.getTrimestre()+1);
				}
				boutonVague.setDisable(false);
				boutonVague.setText("Vague Suivante");
				gameloop.stop();
				if(game.getAnnee()==5 && game.getTrimestre() == 3 && game.noMoreEnnemies()){
					primaryStage.setScene(winScene);
				}
					
			}else{
				game.oneFrame();
			}
		}));
		gameloop.getKeyFrames().add(kf);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//Getters and Setters
	public static UpgradeMenu getUpgrade() {
		return upgrade;
	}
	
	public static Pane getPaneGame() {
		return paneGame;
	}
}
