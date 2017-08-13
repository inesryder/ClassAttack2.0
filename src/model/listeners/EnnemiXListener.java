package model.listeners;

import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.Duration;
import view.EnnemiView;
/**
 * Cette classe permet de changer la position de l'ennemi sur l'axe X du terrain
 *
 */
public class EnnemiXListener implements ChangeListener<Number> {

	private EnnemiView ennemi;

	public EnnemiXListener(EnnemiView ennemi) {
		this.ennemi = ennemi;
	}

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		TranslateTransition slide = new TranslateTransition(Duration.millis(500), ennemi.getImage());
		slide.setCycleCount(1);
		if ((int)oldValue < (int)newValue)
			slide.setByX(50);
		else if ((int)oldValue > (int)newValue && (int)newValue >=0)
			slide.setByX(-50);
		else if ((int)newValue == -1)
			ennemi.setX(-1);
		slide.play();	
	}
}
