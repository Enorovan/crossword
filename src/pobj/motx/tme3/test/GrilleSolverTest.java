package pobj.motx.tme3.test;

import static org.junit.Assert.*;

import org.junit.Test;

import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrilleLoader;
import pobj.motx.tme1.GrillePlaces;
import pobj.motx.tme2.Dictionnaire;
import pobj.motx.tme2.GrillePotentiel;
import pobj.motx.tme3.adapt.MotX;
import pobj.motx.tme3.csp.CSPSolver;
/*import pobj.motx.tme3.csp.CSPSolverCorrige;*/
import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.strats.*;

public class GrilleSolverTest {
	
	@Test
	public void testMedium() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/medium.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(! gp.isDead());
		
		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}

	@Test
	public void testHard() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(! gp.isDead());
		
		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testLarge() {
		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/large.grl");

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(! gp.isDead());
		
		ICSP problem = new MotX(gp);
		CSPSolver solver = new CSPSolver();

		// solver.setStrat(new StratFirst());
		// solver.setStrat(new StratMin());
		
		long timestamp = System.currentTimeMillis();
		ICSP solution = solver.solve(problem);

		System.out.println("Solution \n" + solution + " \nCalculée en "+ (System.currentTimeMillis() - timestamp) +" ms " );
	}
	
	@Test
	public void testFirstEasy() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/easy.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(!gp.isDead());

		CSPSolver solver= new CSPSolver();
		solver.setChoixVarStrat(new StratFirst());

		System.out.println("Succès test GrillePotentiel : easy.");
	}
	
	@Test
	public void testMinEasy() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/easy.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(!gp.isDead());

		CSPSolver solver= new CSPSolver();
		solver.setChoixVarStrat(new StratMin());

		System.out.println("Succès test GrillePotentiel : easy.");
	}
	
	@Test
	public void testFirstHard() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(!gp.isDead());

		CSPSolver solver= new CSPSolver();
		solver.setChoixVarStrat(new StratFirst());

		System.out.println("Succès test GrillePotentiel : hard.");
	}
	
	@Test
	public void testMinHard() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(!gp.isDead());

		CSPSolver solver= new CSPSolver();
		solver.setChoixVarStrat(new StratMin());

		System.out.println("Succès test GrillePotentiel : hard.");
	}
	
	@Test
	public void testAleaHard() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(!gp.isDead());

		CSPSolver solver= new CSPSolver();
		solver.setChoixValeurStrat(new StratAleatoire());

		System.out.println("Succès test GrillePotentiel : hard.");
	}
	
	@Test
	public void testBasiqueHard() {

		Dictionnaire gut = Dictionnaire.loadDictionnaire("data/frgut.txt");
		Grille gr = GrilleLoader.loadGrille("data/hard.grl");

		assertEquals(5, gr.nbCol());
		assertEquals(5, gr.nbLig());

		System.out.println(gr);

		GrillePlaces grille = new GrillePlaces(gr);
		GrillePotentiel gp = new GrillePotentiel(grille, gut);
		
		System.out.println(gp);
		assertTrue(!gp.isDead());

		CSPSolver solver= new CSPSolver();
		solver.setChoixValeurStrat(new StratBasique());

		System.out.println("Succès test GrillePotentiel : hard.");
	}

}
