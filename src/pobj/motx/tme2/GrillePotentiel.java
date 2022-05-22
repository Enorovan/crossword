package pobj.motx.tme2;

import java.util.List;
import java.util.ArrayList;
import pobj.motx.tme1.*;

/**
 * Classe filtrant les contraintes de la grille pour faciliter la recherche du résultat.
 * @author Enorovan + [REDACTED]
 */
public class GrillePotentiel {
	//Attributes
	/** Une grille d'emplacement. */
	private GrillePlaces grille;
	/** Le dictionnaire complet. */
	private Dictionnaire dico;
	/** Une liste de dictionnaire filtrés. */
	private List<Dictionnaire> motsPot = new ArrayList<>();
	/** Le nombre de mots supprimés. */
	@SuppressWarnings("unused")
	private int motsSupprimes;
	/** Une liste de contraintes. */
	private List<IContrainte> contraintes;

	//Constructor
	/**
	 * Construit une GrillePotentiel et créé des dictionnaires filtrés.
	 * @param grille, la grille d'emplacement.
	 * @param dicoComplet, le dictionnaire complet.
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		dico = dicoComplet.copy();
		int motsDel = 0;
		int i = 0;
		//premier tri des dicos par taille des emplacements
		for (Emplacement e: grille.getPlaces()) {
			Dictionnaire dicoTmp = dico.copy();
			motsDel += dicoTmp.filtreLongueur(e.size());
			for (int j = 0; j < grille.getPlaces().get(i).size(); j++) {
				if (!e.getLettres().get(j).isVide() && !e.getLettres().get(j).isPleine()) {
					motsDel += dicoTmp.filtreParLettre(e.getLettres().get(j).getChar(), j);
				}					
			}
			motsPot.add(dicoTmp);
			i++;
		}
		motsSupprimes = motsDel;
		
		//ajouts contraintes
		contraintes = ajoutContraintes();
		
		//second tri des dicos par Xcontraines
		motsSupprimes += filtreParContraintes();
		
		propage();
	}
	/**
	 * Construit une GrillePotentiel et créé des dictionnaires filtrés.
	 * @param grille, la grille d'emplacement.
	 * @param dicoComplet, le dictionnaire complet.
	 * @param potentiel, une liste de dictionnaire représentant le potentiel actuel.
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet, List<Dictionnaire> potentiel) {
		this.grille = grille;
		dico = dicoComplet.copy();
		motsPot = potentiel;
		contraintes = new ArrayList<>();
		int motsDel = 0;
		int cpt = 0;
		int i = 0;
		for (Emplacement e: grille.getPlaces()) {
			motsDel += motsPot.get(cpt).filtreLongueur(e.size());
			for (int j = 0; j < grille.getPlaces().get(i).size(); j++) {
				if (!e.getLettres().get(j).isVide() && !e.getLettres().get(j).isPleine()) {
					motsDel += motsPot.get(cpt).filtreParLettre(e.getLettres().get(j).getChar(), j);
				}					
			}
			cpt++;
			i++;
		}
		motsSupprimes = motsDel;
		
		//ajouts contraintes
		contraintes = ajoutContraintes();
		
		//second tri des dicos par Xcontraines
		motsSupprimes += filtreParContraintes();
		
		propage();
	}
	//Methods
	/**
	 * Filtre par contrainte, lance la réduction sur la GrillePotentiel courante.
	 * @return le nombre de mots supprimés.
	 */
	public int filtreParContraintes() {
		int motsDel = 0;
		for (IContrainte cx: contraintes) {
			motsDel += cx.reduce(this);
		}
		return motsDel;
	}
	/**
	 * Ajoute les contraintes trouvées sur la grille en créant de nouvelles CroixContrainte.
	 * @return la liste de toutes les contraintes.
	 */
	public List<IContrainte> ajoutContraintes(){
		int m1, c1, m2, c2;
		List<IContrainte> lc = new ArrayList<>();
		
		for (int i = 0; i < grille.getNbHorizontal(); i++) {
			m1 = i;
			for(int x = 0; x < grille.getPlaces().get(i).size(); x++) {
				c1 = x;
				for (int j = grille.getNbHorizontal(); j < grille.getPlaces().size(); j++) {
					m2 = j;
					for(int y = 0; y < grille.getPlaces().get(j).size(); y++) {
						c2 = y;
						Case c = grille.getPlaces().get(j).getLettres().get(y);
						if (grille.getPlaces().get(i).getLettres().get(x).equals(c)) {
							if (c.getChar() == ' ') lc.add(new CroixContrainte(m1, c1, m2, c2));
						}
					}
				}
			}
		}
		return lc;
	}
	/**
	 * Accède à la liste des dictionnaires.
	 * @return la liste des dictionnaires.
	 */
	public List<Dictionnaire> getMotsPot(){
		return motsPot;
	}
	/**
	 * Renvoie le booléen qui vérifie la condition du dictionnaire.
	 * @return le booléen (true si le dictionnaire est vide.
	 */
	public Boolean isDead() {
		for (Dictionnaire d: motsPot) {
			if (d.size() == 0)
				return true;
		}
		return false;
	}	
	/**
	 * Renvoie une nouvelle grille où les cases constituant l’emplacement de mot d’indice m ont pour contenu les lettres de soluce.
	 * @param m, l'indice du mot.
	 * @param soluce une chaine de caractère.
	 * @return une nouvelle GrillePotentiel initialisée à partir de la nouvelle grille.
	 */
	public GrillePotentiel fixer(int m, String soluce) {
		/*return new GrillePotentiel(grille.fixer(m, soluce),dico);*/
		List<Dictionnaire> motsPotTemp = new ArrayList<>();
		for (int i = 0; i < motsPot.size(); i++) {
			motsPotTemp.add(motsPot.get(i).copy());

		}
		
		return new GrillePotentiel(grille.fixer(m, soluce),dico,motsPotTemp); //Améliore les performances.
	}
	/**
	 * Accède à la liste des contraintes.
	 * @return la liste des contraintes.
	 */
	public List<IContrainte> getContraintes() {
		return contraintes;
	}
	/**
	 * Accède au dictionnaire complet.
	 * @return le dictionnaire complet.
	 */
	public Dictionnaire getDico() {
		return dico;
	}
	/**
	 * Propage l'information: pour chaque contrainte on réduit la GrillePotentiel
	 * @return un booléen.
	 */
	public boolean propage() {
		while(true) {
			int res = 0;
			for (IContrainte ic: contraintes) {
				res += ic.reduce(this);
			}
			if (isDead()) return false;
			
			if (res == 0) return true;
		}
	}
	/**
	 * Accède à la GrillePlaces.
	 * @return la GrillePlaces.
	 */
	public GrillePlaces getGrillePlaces() {
		return grille;
	}
	/**
	 * Ajoute une contrainte de mot unique à la grille.
	 */
	public void MotUniqueContrainte() {
		for (int i = 0; i < motsPot.size(); i++) {
			if (motsPot.get(i).size() == 1)
				contraintes.add(new MotUnique(i));
		}
	}
}
