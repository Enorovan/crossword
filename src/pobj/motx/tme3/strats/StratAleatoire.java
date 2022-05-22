package pobj.motx.tme3.strats;

import java.util.Collections;
import java.util.List;
import pobj.motx.tme3.csp.*;

/**
 * Classe utilisant la stratégie aléatoire qui rend les valeurs dans un ordre arbitraire..
 * @author Enorovan + [REDACTED]
 */
public class StratAleatoire implements IChoixValeur {

	@Override
	public List<String> orderValues(ICSP problem, IVariable v) {
		List<IVariable> liv = problem.getVars();
		Collections.shuffle(liv);
		problem.setVars(liv);
		return null;
	}
	
}
