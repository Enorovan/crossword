package pobj.motx.tme3.strats;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IVariable;

/**
 * Classe utilisant la stratégie variable ordering.
 * @author Enorovan + [REDACTED]
 */
public class StratFirst implements IChoixVar {

	@Override
	public IVariable chooseVar(ICSP problem) {
		return problem.getVars().get(0);
	}

}
