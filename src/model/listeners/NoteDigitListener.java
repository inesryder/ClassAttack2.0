package model.listeners;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 * Cette classe permet de changer l'affichage des PV du joueur selon la valeur du modèle.
 * Elle change l'image des chiffres.
 */
public class NoteDigitListener implements ChangeListener<Number>{

	Image num0 = new Image("/img/numbers/number0.png");
	Image num1 = new Image("/img/numbers/number1.png");
	Image num2 = new Image("/img/numbers/number2.png");
	Image num3 = new Image("/img/numbers/number3.png");
	Image num4 = new Image("/img/numbers/number4.png");
	Image num5 = new Image("/img/numbers/number5.png");
	Image num6 = new Image("/img/numbers/number6.png");
	Image num7 = new Image("/img/numbers/number7.png");
	Image num8 = new Image("/img/numbers/number8.png");
	Image num9 = new Image("/img/numbers/number9.png");

	ImageView digit1;
	ImageView digit2;
	
	public NoteDigitListener(ImageView digit1, ImageView digit2) {
		this.digit1 = digit1;
		this.digit2 = digit2;
	}
	
	@Override
	public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
		String compteur = String.format("%02d", newValue);
		switch (compteur.charAt(0)) {
		case '0':
			digit1.setImage(num0);
			break;
		case '1':
			digit1.setImage(num1);
			break;
		case '2':
			digit1.setImage(num2);
			break;
		case '3':
			digit1.setImage(num3);
			break;
		case '4':
			digit1.setImage(num4);
			break;
		case '5':
			digit1.setImage(num5);
			break;
		case '6':
			digit1.setImage(num6);
			break;
		case '7':
			digit1.setImage(num7);
			break;
		case '8':
			digit1.setImage(num8);
			break;
		case '9':
			digit1.setImage(num9);
			break;
		default:
			digit1.setImage(num0);
		}
		
		switch (compteur.charAt(1)) {
		case '0':
			digit2.setImage(num0);
			break;
		case '1':
			digit2.setImage(num1);
			break;
		case '2':
			digit2.setImage(num2);
			break;
		case '3':
			digit2.setImage(num3);
			break;
		case '4':
			digit2.setImage(num4);
			break;
		case '5':
			digit2.setImage(num5);
			break;
		case '6':
			digit2.setImage(num6);
			break;
		case '7':
			digit2.setImage(num7);
			break;
		case '8':
			digit2.setImage(num8);
			break;
		case '9':
			digit2.setImage(num9);
			break;
		default:
			digit2.setImage(num0);
		}	
	}
}
