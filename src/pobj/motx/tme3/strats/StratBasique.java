package pobj.motx.tme3.strats;

import java.util.List;
import pobj.motx.tme3.csp.*;

/**
 * Classe utilisant la stratégie aléatoire qui rend les valeurs dans l’ordre de définition.
 * @author Enorovan + [REDACTED]
 */
public class StratBasique implements IChoixValeur {

	@Override
	public List<String> orderValues(ICSP problem, IVariable v) {
		List<IVariable> liv = problem.getVars();
		problem.setVars(liv);
		return null;
	}
	
}
