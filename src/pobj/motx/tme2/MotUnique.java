package pobj.motx.tme2;

/**
 * Une classe représentant la contrainte du mot unique sur une grille.
 * @author Enorovan + [REDACTED]
 */
public class MotUnique implements IContrainte {
	//Attributes
	/** Indice du mot.*/
	public int mot;
	
	//Constructor
	/**
	 * Construit une contrainte de MotUnique à l'aide de l'indice du mot.
	 * @param m, l'indice du mot.
	 */
	public MotUnique(int m) {
		mot = m;
	}
	//Methods
	@Override
	public int reduce(GrillePotentiel grille) {
		int res= 0;
		int i = 0;
		for (Dictionnaire dico: grille.getMotsPot()) {
			if ((i != mot) && (grille.getMotsPot().get(mot).size() >= 1)) 
				res += dico.remove(grille.getMotsPot().get(mot).get(0));
		i++;
		}
		return res;
	}

}
