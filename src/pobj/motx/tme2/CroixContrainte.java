package pobj.motx.tme2;

/**
 * Une classe représentant des contraintes sur la grille.
 * @author Enorovan + [REDACTED] 
 */
public class CroixContrainte implements IContrainte {
	//Attributes
	/** Indice du premier emplacement. */
	private int m1;
	/** Indice de la case où a lieu un croisement pour cet emplacement. */
	private int c1;
	/** Indice du second emplacement. */
	private int m2;
	/** Indice de la case où a lieu un croisement pour cet emplacement. */
	private int c2;
	
	//Constructor
	/**
	 * Construit une CroixContrainte à l'aide des indices des emplacements et des cases où se situe la contrainte.
	 * @param m1, l'indice du premier emplacement.
	 * @param c1, l'ndice de la case où a lieu un croisement pour cet emplacement.
	 * @param m2, l'indice du second emplacement.
	 * @param c2, l'indice de la case où a lieu un croisement pour cet emplacement.
	 */
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}
	
	//Methods
	@Override
	public int reduce(GrillePotentiel grille) {
		EnsembleLettre el1 = new EnsembleLettre(grille.getMotsPot().get(m1), c1);
		EnsembleLettre el2 = new EnsembleLettre(grille.getMotsPot().get(m2), c2);
		EnsembleLettre el3 = el1.intersection(el2);
		int res = 0;
		if (el1.size() > el3.size()) {
			//filtrer le dico de m1
			Dictionnaire dicoTmp1 = grille.getMotsPot().get(m1);
			res += dicoTmp1.filtreParEnsemble(el3, c1);
		}
		if (el2.size() > el3.size()) {
			//filtrer sur m2
			Dictionnaire dicoTmp2 = grille.getMotsPot().get(m2);
			res += dicoTmp2.filtreParEnsemble(el3, c2);
		}
		return res;
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (!(o instanceof CroixContrainte)) return false;
		CroixContrainte other = (CroixContrainte) o;
		if (m1 != other.m1) return false;
		if (c1 != other.c1) return false;
		if (m2 != other.m2) return false;
		if (c2 != other.c2) return false;
		return true;
	}
}
