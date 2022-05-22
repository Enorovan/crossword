package pobj.motx.tme3.strats;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IVariable;

/**
 * Interface permettant d'implémenter le choix des variables.
 * @author Enorovan + [REDACTED]
 */
public interface IChoixVar {
	/**
	 * Méthode permettant de choisir les variables pour un problème donné.
	 * @param problem, le problème.
	 * @return les variables choisies.
	 */
	IVariable chooseVar(ICSP problem);
}
