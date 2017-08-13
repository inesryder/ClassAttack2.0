package model.listeners;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import model.EleveModel;
import view.EleveView;
/**
 * Cette classe permet de créer une liste de tous les élèves présents sur le terrain
 * Elle créé une liste observable
 */
public class ListeEleveListener implements ListChangeListener<EleveModel> {

	private Pane pane;

	public ListeEleveListener(Pane pane) {
		this.pane = pane;
	}

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends EleveModel> c) {
		while (c.next()) {
			if (c.wasAdded()) {
				EleveView eleve = new EleveView(c.getAddedSubList().get(0));
				eleve.start(pane);
				eleve.getImage().layoutXProperty().bind(c.getAddedSubList().get(0).getCoor().xProperty().multiply(50));
				eleve.getImage().layoutYProperty().bind(c.getAddedSubList().get(0).getCoor().yProperty().multiply(50));
				eleve.getMatiere().layoutXProperty().bind(c.getAddedSubList().get(0).getCoor().xProperty().multiply(50));
				eleve.getMatiere().layoutYProperty().bind(c.getAddedSubList().get(0).getCoor().yProperty().multiply(50));
				eleve.refreshPortee();
			}
		}

	}

}
