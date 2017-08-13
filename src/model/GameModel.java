package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.vague.VagueManagement;
/**
 * Cette classe permet de regrouper toutes les fonctionnalités principales du model pour les gérer depuis ici. Elle permet de créer le terrain et définir son BFS, 
 * lancer les vagues de jeu et faire apparaitre les ennemis, gérer l'argents et la vie du joueur, effectuer un tour de jeu (une frame) en faisant déplacer les ennemis
 * et attaquer les élèves.
 *
 */
public class GameModel {

	private ObservableList<EnnemiModel> listeEnnemisObs = FXCollections.observableArrayList();
	private ObservableList<EleveModel> listeElevesObs = FXCollections.observableArrayList();
	private TerrainModel terrain = new TerrainModel();
	private VagueManagement vague = new VagueManagement(terrain);
	private int lvl = 1;
	private int annee = 1;
	private int trimestre = 1;
	private TerrainGraphe terrainGraphe = new TerrainGraphe(terrain);
	private TerrainBFS terrainBFS = new TerrainBFS(terrainGraphe);
	static IntegerProperty vie = new SimpleIntegerProperty(20);
	static IntegerProperty argent = new SimpleIntegerProperty(80);

	/**
	 * Initialise le terrain selon le niveau choisit puis créé son BFS
	 * @param lvl : niveau choisit par le joueur
	 */
	public GameModel(int lvl) {
		terrain.initLevel(lvl);
		terrainBFS.BFS(new Coord(terrain.getSortie().getX(), terrain.getSortie().getY()));
		terrain.setBFS(terrainBFS.getListBFS());
	}
	
	/**
	 * Declenche l'attaque des élèves sur les ennemis.
	 * Declenche le déplacement (une case) des ennemis dans le terrain
	 * Fait apparaitre les ennemis si la liste de la vague n'est pas vide
	 * Détruit les ennemis qui sont arrivés
	 */
	public void oneFrame() {
		for (EleveModel eleve : listeElevesObs) {
			eleve.attaque(listeEnnemisObs);
		}
		for (EnnemiModel ennemi : listeEnnemisObs) {
			ennemi.seDeplace();
		}
		if (!vague.getVagueActuelle().getListe().isEmpty())
			EnnemiSpawn();
		nettoyerListe();
	}

	/**
	 * Créé la vague grâce aux attributs annee et trimestre
	 */
	public void loadVague(){
		vague.initVague(annee, trimestre);
	}
	
	/**
	 * Fait apparaitre un ennemi de la liste de la vague
	 */
	public void EnnemiSpawn() {
		listeEnnemisObs.add(listeEnnemisObs.size(), vague.getVagueActuelle().getListe().get(0));
		vague.getVagueActuelle().getListe().remove(0);
	}

	/**
	 * Verifie s'il y a encore des ennemis sur le terrain
	 * @return true ou false
	 */
	public boolean noMoreEnnemies() {
		if (vague.getVagueActuelle().getListe().isEmpty() && listeEnnemisObs.isEmpty())
			return true;
		else
			return false;
	}
	
	/**
	 * Supprime les ennemis ayant atteint l'arrivée
	 */
	public void nettoyerListe() {
		for (int i = 0 ; i < listeEnnemisObs.size() ; i++) {
			if (listeEnnemisObs.get(i).arriveADestination()) {
				minusVie();
				listeEnnemisObs.remove(listeEnnemisObs.get(i));
			}
		}
	}
	
	/**
	 * Enleve un Pv au joueur
	 */
	public static void minusVie() {
		vie.setValue(vie.getValue()-1);
	}
	
	/**
	 * ajoute de l'argent au joueur
	 * @param money : valeur a ajouter
	 */
	public static void crediterArgent(int money) {
		argent.setValue(argent.getValue() + money);
	}
	
	/**
	 * Enleve de l'argent au joueur
	 * @param money : l'argent a enlever au joueur
	 * @return true ou false selon si le joueur a assez d'argent dans son compte
	 */
	public static boolean debiterArgent(int money) {
		if (money <= argent.getValue()) {
			argent.setValue(argent.getValue() - money);
			return true;
		}
		else
			return false;
	}
	
	// Getters and Setters
	public VagueManagement getVague() {
		return this.vague;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getTrimestre() {
		return trimestre;
	}

	public void setTrimestre(int trimestre) {
		this.trimestre = trimestre;
	}
	
	public int getLvl() {
		return lvl;
	}

	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	public IntegerProperty vieProperty() {
		return vie;
	}
	
	public IntegerProperty argentProperty() {
		return argent;
	}
	
	public static IntegerProperty getVie() {
		return vie;
	}
	
	public void setListeEnnemisObs(ObservableList<EnnemiModel> listeEnnemisObs) {
		this.listeEnnemisObs = listeEnnemisObs;
	}

	public void setListeElevesObs(ObservableList<EleveModel> listeElevesObs) {
		this.listeElevesObs = listeElevesObs;
	}
	
	public ObservableList<EleveModel> getObsEleves() {
		return this.listeElevesObs;
	}

	public ObservableList<EnnemiModel> getObsEnnemis() {
		return this.listeEnnemisObs;
	}

	public TerrainGraphe getTerrainGraphe() {
		return terrainGraphe;
	}

	public void setTerrainGraphe(TerrainGraphe terrainGraphe) {
		this.terrainGraphe = terrainGraphe;
	}

	public TerrainBFS getTerrainBFS() {
		return terrainBFS;
	}

	public void setTerrainBFS(TerrainBFS terrainBFS) {
		this.terrainBFS = terrainBFS;
	}

	public static void setVie(int v) {
		vie.setValue(v);
	}

	public int getArgent() {
		return argent.getValue();
	}

	public void setArgent(int a) {
		argent.setValue(a);
	}

	public void setTerrain(TerrainModel terrain) {
		this.terrain = terrain;
	}
	
	public TerrainModel getTerrain() {
		return this.terrain;
	}

	public void setVague(VagueManagement vague) {
		this.vague = vague;
	}
}
