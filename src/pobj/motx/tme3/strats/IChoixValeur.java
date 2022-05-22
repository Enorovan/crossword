package pobj.motx.tme3.strats;

import java.util.List;
import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IVariable;

/**
 * Interface permettant d'implémenter le choix des valeurs.
 * @author Enorovan + [REDACTED]
 */
public interface IChoixValeur {
	List<String> orderValues (ICSP problem, IVariable v);
}
