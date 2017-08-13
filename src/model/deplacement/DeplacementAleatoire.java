package model.deplacement;

import model.Coor;
import model.TerrainModel;
/**
 * Cette methode de déplacement est aleatoire. A chaque tour l'ennemi peut se déplacer soit au Nord,Sud,Est ou Ouest. S'il ne peut aller sur la case sélectionée, il passe son tour
 * 
 */
public class DeplacementAleatoire implements Deplacement {

	public Coor seDeplace(TerrainModel terrain, Coor coor){
			int randomNbr = (int) (Math.random() *100);
			System.out.println("nbr: " +randomNbr);
			if(!terrain.verificationCheminObstrue(coor.getX(), coor.getY()-1) && randomNbr>=0 && randomNbr <25 ){//Nord
				coor.setCoor(coor.getX(), coor.getY()-1);
			}else if(!terrain.verificationCheminObstrue(coor.getX()+1, coor.getY()) && randomNbr>=25 && randomNbr <50 ){//Est
				coor.setCoor(coor.getX()+1, coor.getY());
			}else if(!terrain.verificationCheminObstrue(coor.getX(), coor.getY()+1) && randomNbr>=50 && randomNbr <75 ){//Sud
				coor.setCoor(coor.getX(), coor.getY()+1);
			}else if(!terrain.verificationCheminObstrue(coor.getX()-1, coor.getY()) && randomNbr>=75 && randomNbr <100 ){//Ouest
				coor.setCoor(coor.getX()-1, coor.getY());
			}
		return coor;
	}
}
