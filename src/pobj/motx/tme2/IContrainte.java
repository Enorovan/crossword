package pobj.motx.tme2;
/**
 * Interface permettant d'implémenter des contraintes sur une grille de mots croisés.
 * @author Enorovan + [REDACTED]
 */
public interface IContrainte {
	/**
	 * Renvoie le nombre total de mots filtrés.
	 * @param grille, la grille modifiée par le filtrage.
	 * @return le nombre total de mots filtrés.
	 */
	int reduce(GrillePotentiel grille);
	boolean equals(Object obj);
}
