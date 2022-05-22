package pobj.motx.tme3.csp;

import java.util.List;

/**
 * Interface permettant d'implémenter des CSP.
 * @author Enorovan + [REDACTED]
 */
public interface ICSP {
	/**
	 * Accède aux variables.
	 * @return la liste des variables.
	 */
	List<IVariable> getVars();
	/**
	 * Teste si le problème est encore satisfiable.
	 * @return le booléen.
	 */
	boolean isConsistent();
	/**
	 * Affecte les variables du problème.
	 * @param vi, la variable.
	 * @param val, la valeur que l'ont souhait affecter.
	 * @return un nouveau problème CSP, de même nature que le précédent, mais qui compte une variable de moins.
	 */
	ICSP assign(IVariable vi, String val);
	void setVars(List<IVariable> liv);
}
