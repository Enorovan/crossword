package pobj.motx.tme3.strats;

import pobj.motx.tme3.csp.ICSP;
import pobj.motx.tme3.csp.IVariable;

/**
 * Classe utilisant la stratégie value ordering.
 * @author Enorovan + [REDACTED]
 */
public class StratMin implements IChoixVar{

	@Override
	public IVariable chooseVar(ICSP problem) {
		IVariable resVar = problem.getVars().get(0);
		
		for (IVariable iv: problem.getVars()) {
			if (iv.getDomain().size() < resVar.getDomain().size())
				resVar = iv;
		}
		return resVar;
	}

}
