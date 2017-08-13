package JUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.EnnemiModel;
import model.TerrainModel;
import model.eleves.LeSpecial;
import model.eleves.LowCost;
import model.eleves.Major;
import model.eleves.MultiTache;
import model.ennemis.Exercice;

public class AttaqueClassesTest {

	@Test
	public void testSpe() {
		TerrainModel terrain = new TerrainModel();
		Exercice exo1 = new Exercice(0,0,terrain,"prog");
		assertEquals("spe","info",exo1.getSpe());
		Exercice exo2 = new Exercice(0,0,terrain,"com");
		assertEquals("spe","art",exo2.getSpe());
		Exercice exo3 = new Exercice(0,0,terrain,"");
		assertEquals("spe","",exo3.getSpe());
	}
	
	@Test
	public void testAttaqueCompleteSpe() {
		TerrainModel terrain = new TerrainModel();
		Exercice exo1 = new Exercice(0,0,terrain,"prog");
		Exercice exo2 = new Exercice(0,1,terrain,"com");
		Exercice exo3 = new Exercice(1,0,terrain,"");
		Exercice exo4 = new Exercice(2,2,terrain,"bd");
		Major m = new Major(1,1);
		m.setAttaque(5);
		m.setSpe("info");
		m.setMatiere("prog");
		assertEquals("att m",5,m.getAttaque());
		ObservableList<EnnemiModel> liste = FXCollections.observableArrayList();
		liste.add(0,exo1);
		liste.add(1,exo2);
		liste.add(2,exo3);
		liste.add(3,exo4);
		m.attaque(liste);
		assertEquals("exo1",0,exo1.getPv());
		assertEquals("exo2",10,exo2.getPv());
		assertEquals("exo3",10,exo3.getPv());
		assertEquals("exo4",5,exo4.getPv());
	}
	
	@Test
	public void testAttaqueComplete() {
		TerrainModel terrain = new TerrainModel();
		Exercice exo1 = new Exercice(0,0,terrain,"");
		Exercice exo2 = new Exercice(0,1,terrain,"");
		Exercice exo3 = new Exercice(3,3,terrain,"");
		Exercice exo4 = new Exercice(2,2,terrain,"");
		Major m = new Major(1,1);
		m.setAttaque(5);
		assertEquals("att m",5,m.getAttaque());
		ObservableList<EnnemiModel> liste = FXCollections.observableArrayList();
		liste.add(0,exo1);
		liste.add(1,exo2);
		liste.add(2,exo3);
		liste.add(3,exo4);
		m.attaque(liste);
		assertEquals("exo1",10,exo1.getPv());
		assertEquals("exo2",10,exo2.getPv());
		assertEquals("exo3",15,exo3.getPv());
		assertEquals("exo4",10,exo4.getPv());
	}
	
	@Test
	public void testAttaqueClassique() {
		TerrainModel terrain = new TerrainModel();
		Exercice exo1 = new Exercice(3,3,terrain,"");
		Exercice exo2 = new Exercice(0,1,terrain,"");
		Exercice exo3 = new Exercice(1,0,terrain,"");
		LowCost l = new LowCost(1,1);
		l.setAttaque(5);
		assertEquals("att l",5,l.getAttaque());
		ObservableList<EnnemiModel> liste = FXCollections.observableArrayList();
		liste.add(0,exo1);
		liste.add(1,exo2);
		liste.add(2,exo3);
		l.attaque(liste);
		assertEquals("exo1",15,exo1.getPv());
		assertEquals("exo2",10,exo2.getPv());
		assertEquals("exo3",15,exo3.getPv());
	}
	
	@Test
	public void testAttaqueMulti() {
		TerrainModel terrain = new TerrainModel();
		Exercice exo1 = new Exercice(3,3,terrain,"");
		Exercice exo2 = new Exercice(0,1,terrain,"");
		Exercice exo3 = new Exercice(1,0,terrain,"");
		Exercice exo4 = new Exercice(2,2,terrain,"");
		MultiTache m = new MultiTache(1,1);
		m.setAttaque(5);
		assertEquals("att m",5,m.getAttaque());
		ObservableList<EnnemiModel> liste = FXCollections.observableArrayList();
		liste.add(0,exo1);
		liste.add(1,exo2);
		liste.add(2,exo3);
		liste.add(3,exo4);
		m.attaque(liste);
		assertEquals("exo1",15,exo1.getPv());
		assertEquals("exo2",10,exo2.getPv());
		assertEquals("exo3",10,exo3.getPv());
		assertEquals("exo4",15,exo4.getPv());
	}
	
	@Test
	public void testAttaqueCroix() {
		TerrainModel terrain = new TerrainModel();
		Exercice exo1 = new Exercice(0,0,terrain,"");
		Exercice exo2 = new Exercice(1,0,terrain,"");
		Exercice exo3 = new Exercice(3,1,terrain,"");
		Exercice exo4 = new Exercice(2,2,terrain,"");
		LeSpecial s = new LeSpecial(1,1);
		s.setAttaque(5);
		assertEquals("att m",5,s.getAttaque());
		ObservableList<EnnemiModel> liste = FXCollections.observableArrayList();
		liste.add(0,exo1);
		liste.add(1,exo2);
		liste.add(2,exo3);
		liste.add(3,exo4);
		s.attaque(liste);
		assertEquals("exo1",15,exo1.getPv());
		assertEquals("exo2",10,exo2.getPv());
		assertEquals("exo3",10,exo3.getPv());
		assertEquals("exo4",15,exo4.getPv());
	}

}
