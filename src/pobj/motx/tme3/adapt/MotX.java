package pobj.motx.tme3.adapt;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme2.*;
import pobj.motx.tme3.csp.*;

/**
 * Une classe qui gère les problèmes.
 * @author Enorovan + [REDACTED]
 */
public class MotX implements ICSP{
	/** Une liste de dictionnaire de variables. */
	private List<IVariable> ldv;
	/** Une GrillePotentiel. */
	private GrillePotentiel gp;
	/**
	 * Construit un MotX
	 * @param gp, une GrillePotentiel.
	 */
	public MotX(GrillePotentiel gp) {
		ldv = new ArrayList<>();
		this.gp = gp;
		
		for (int i = 0; i < gp.getGrillePlaces().getPlaces().get(i).size(); i++) {
			if (gp.getGrillePlaces().getPlaces().get(i).hasCaseVide())
				ldv.add(new DicoVariable(i,gp));
		}
	}

	@Override
	public List<IVariable> getVars() {
		return ldv;
	}

	@Override
	public boolean isConsistent() {
		return !gp.isDead();
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		MotX res = null;
		
		if ((vi!= null) && (vi instanceof DicoVariable)) {
			GrillePotentiel gpa = null;
			DicoVariable dicoVi = (DicoVariable) vi;
			gpa = gp.fixer(dicoVi.getIndex(),val);
			res = new MotX(gpa);
		}
		return res;
	}

	@Override
	public void setVars(List<IVariable> liv) {
		ldv = liv;		
	}
}
