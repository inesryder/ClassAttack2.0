package model.deplacement;
import model.Coor;
import model.TerrainModel;
/**
 * Ce déplacement utilise de la reconnaissance case par case. A chaque tour, l'ennemi va observer au tour de lui les cases Disponibles selon un ordre de priorité:
 * Nord,Est,Ouest,Sud
 *
 */
public class DeplacementBalise implements Deplacement {
	
	private String oldPosition;
	
	public Coor seDeplace(TerrainModel terrain, Coor coor){	
		String old = null;
		if(terrain.verificationCheminObstrue(coor.getX(), coor.getY()-1) || this.oldPosition == "N" ){
			if(terrain.verificationCheminObstrue(coor.getX()+1, coor.getY()) || this.oldPosition == "E" ){
				if(terrain.verificationCheminObstrue(coor.getX()-1, coor.getY()) || this.oldPosition == "O" ){
					if(terrain.verificationCheminObstrue(coor.getX(), coor.getY()+1) || this.oldPosition == "S" ){
					}else{
						old = "N";
						coor.setCoor(coor.getX(),coor.getY()+1);
					}
				}else{
					old = "E";
					coor.setCoor(coor.getX()-1,coor.getY());
				}
			}else{
				old = "O";
				coor.setCoor(coor.getX()+1,coor.getY());
			}
		}else{
			old = "S";
			coor.setCoor(coor.getX(),coor.getY()-1);
		}
		setOldPosition(old);
		return coor;
	}

	public String getOldPosition() {
		return oldPosition;
	}

	public void setOldPosition(String oldPosition) {
		this.oldPosition = oldPosition;
	}
}
