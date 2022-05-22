package pobj.motx.tme3.csp;

import java.util.List;

/**
 * Interface permettant d'implémenter des variables.
 * @author Enorovan + [REDACTED]
 */
public interface IVariable {
	/**
	 * Accède au domaine de la variable.
	 * @return l’ensemble des valeurs que la variable peut prendre.
	 */
	List<String> getDomain();
}
