package pobj.motx.tme3.adapt;

import java.util.List;

import pobj.motx.tme2.*;
import pobj.motx.tme3.csp.*;

/**
 * Une classe de dictionnaire avec variables.
 * @author Enorovan + [REDACTED] 
 */
public class DicoVariable implements IVariable {
	/** Indice de l'emplacement du mot correspondant. */
	private int index;
	/** Une GrillePotentiel. */
	@SuppressWarnings("unused")
	private GrillePotentiel gp;
	/** Une liste de chaine de caractères. */
	private List<String> domain;
	
	/**
	 * Construit un dictionnaire de variables.
	 * @param index, l'indice de l'emplacement du mot correspondant.
	 * @param gp, la GrillePotentiel.
	 */
	public DicoVariable(int index, GrillePotentiel gp) {
		this.index = index;
		this.gp = gp;
		Dictionnaire dico = gp.getMotsPot().get(index);
		domain = dico.getMots();
	}
	@Override
	public List<String> getDomain() {
		return domain;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("");
		for (String s: this.getDomain()) {
			sb.append(s);
		}
		return sb.toString();
	}
	/**
	 * Accède à l'index.
	 * @return l'index.
	 */
	public int getIndex() {
		return index;
	}
}
