package model.listeners;

import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.Duration;
import view.EnnemiView;
/**
 * Cette classe permet de changer la position de l'ennemi sur l'axe Y du terrain
 *
 */
public class EnnemiYListener implements ChangeListener<Number> {

	private EnnemiView ennemi;

	public EnnemiYListener(EnnemiView ennemi) {
		this.ennemi = ennemi;
	}

	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		TranslateTransition slide = new TranslateTransition(Duration.millis(500), ennemi.getImage());
		slide.setCycleCount(1);
		if ((int)oldValue < (int)newValue)
			slide.setByY(50);
		else if ((int)oldValue > (int)newValue && (int)newValue >=0)
			slide.setByY(-50);
		else if ((int)newValue == -1)
			ennemi.setY(-1);
		slide.play();
	}
}
