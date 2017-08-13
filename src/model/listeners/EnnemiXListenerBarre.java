package model.listeners;

import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.Duration;
import view.BarrePVEnnemi;
/**
 * Cette classe permet de changer la position de la barre de PV de l'ennemi sur l'axe X du terrain
 *
 */
public class EnnemiXListenerBarre implements ChangeListener<Number> {

	private BarrePVEnnemi ennemi;

	public EnnemiXListenerBarre(BarrePVEnnemi ennemi) {
		this.ennemi = ennemi;
	}

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		TranslateTransition slide = new TranslateTransition(Duration.millis(500), ennemi.getPane());
		slide.setCycleCount(1);
		if ((int)oldValue < (int)newValue)
			slide.setByX(50);
		else if ((int)oldValue > (int)newValue && (int)newValue >=0)
			slide.setByX(-50);
		else if ((int)newValue == -1)
			ennemi.Degage();
		slide.play();

		
	}

}
