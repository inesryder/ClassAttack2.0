package model.listeners;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import view.BarrePVEnnemi;
/**
 * Cette classe permet de mettre a jour la barre de Pv d'un ennemi selon la valeur actuelle des points de vie de l'ennemi.
 * 
 */
public class EnnemiBarrePVListener implements ChangeListener<Number> {

	private BarrePVEnnemi barrePV;
	
	public EnnemiBarrePVListener(BarrePVEnnemi barre) {
		this.barrePV = barre;
	}
	
	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		int degat = oldValue.intValue()-newValue.intValue();
		
		double pourcentageAEnlever = degat*100/oldValue.intValue();
		
		double widthBarre = barrePV.getRectangleViePleineWidth()-(barrePV.getRectangleViePleineWidth()*pourcentageAEnlever/100);
		
		barrePV.setRectangleViePleineWidth(widthBarre);
	}

}
