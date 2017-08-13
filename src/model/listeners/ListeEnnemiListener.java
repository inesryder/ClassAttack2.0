package model.listeners;

import javafx.collections.ListChangeListener;
import javafx.scene.layout.Pane;
import model.EnnemiModel;
import view.BarrePVEnnemi;
import view.EnnemiView;
/**
 * Cette classe permet de créer une liste de tous les ennemis présents sur le terrain
 * Elle créé une liste observable
 */
public class ListeEnnemiListener implements ListChangeListener<EnnemiModel> {

	private Pane pane;

	public ListeEnnemiListener(Pane pane) {
		this.pane = pane;
	}

	@Override
	public void onChanged(javafx.collections.ListChangeListener.Change<? extends EnnemiModel> c) {
		while (c.next()) {
			if (c.wasAdded()) {
				EnnemiView ennemi = new EnnemiView(c.getAddedSubList().get(0));
				BarrePVEnnemi barrePV = new BarrePVEnnemi(c.getAddedSubList().get(0).getPv());
				
				ennemi.start(pane);
				barrePV.start(pane);
				
				ennemi.setX(c.getAddedSubList().get(0).getX());
				ennemi.setY(c.getAddedSubList().get(0).getY());
				EnnemiXListener xListener = new EnnemiXListener(ennemi);
				EnnemiYListener yListener = new EnnemiYListener(ennemi);
				c.getAddedSubList().get(0).getCoor().xProperty().addListener(xListener);
				c.getAddedSubList().get(0).getCoor().yProperty().addListener(yListener);
				
				barrePV.setCoor(c.getAddedSubList().get(0).getX(), c.getAddedSubList().get(0).getY());
				EnnemiXListenerBarre xBarre = new EnnemiXListenerBarre(barrePV);
				EnnemiYListenerBarre yBarre = new EnnemiYListenerBarre(barrePV);
				c.getAddedSubList().get(0).getCoor().xProperty().addListener(xBarre);
				c.getAddedSubList().get(0).getCoor().yProperty().addListener(yBarre);
				
				EnnemiBarrePVListener barre = new EnnemiBarrePVListener(barrePV);
				c.getAddedSubList().get(0).pvProperty().addListener(barre);
				
			}
			else if (c.wasRemoved()) {
				for (EnnemiModel e : c.getRemoved()) {
					e.disparait();
					if (e.getPv() <= 0)
						model.GameModel.crediterArgent(e.getValeur());
					
				}
					
			}
		}
	}

}
