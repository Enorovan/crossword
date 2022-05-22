package pobj.motx.tme1;
import java.util.List;
import java.util.ArrayList;
/**
 * Classe calculant les emplacements des mots dans une grille.
 * @author Enorovan + [REDACTED]
 */
public class GrillePlaces {
	//Attributes
	/** Grille où l'on recherche les emplacements de mots. */
	private Grille grille;
	/** Liste des emplacements des mots. */
	private List<Emplacement> places;
	/** Nombre de mots à l'horizontale. */
	private int nbHorizontal;
	/** Nombre de mots à la verticale. */
	private int nbVertical;
	
	//Constructor
	/**
	 * Construit la liste des emplacements des mots de manière ordonnée.
	 * @param grille, la grille où l'on recherche les emplacements de mots.
	 */
	public GrillePlaces(Grille grille) {
		places = new ArrayList<Emplacement>();
		this.grille = grille;
		for (int i = 0; i < grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}
		nbHorizontal = places.size();
		for (int j = 0; j < grille.nbCol(); j++) {
			cherchePlaces(getCol(j));
		}
		nbVertical = places.size() - nbHorizontal;
	}
	
	//Methods
	/**
	 * Détermine les emplacements dans la liste de cases donnée en argument.
	 * @param cases, la liste de cases.
	 */
	private void cherchePlaces(List<Case> cases) {
		List<Case> mot = new ArrayList<>();
		int taille = cases.size();
		for (int i = 0; i < taille; i++) {
			if (cases.get(i).isPleine()) {
				if (mot.size() >= 2) {
					places.add(new Emplacement(mot));
				}
				mot.clear();
			}
			else {
				mot.add(cases.get(i));
			}
		}
		if (mot.size() >= 2) {
			places.add(new Emplacement(mot));
		}
		mot.clear();
	}
	
	//Getters
	/**
	 * Renvoie la liste de cases correspondant à la ligne donnée en argument.
	 * @param lig, la ligne.
	 * @return la liste de cases.
	 */
	private List<Case> getLig(int lig){
		List<Case> res = new ArrayList<>();
		for (int j = 0; j < grille.nbCol(); j++) {
			res.add(grille.getCase(lig,j));
		}
		return res;
	}
	/**
	 * Renvoie la liste de cases correspondant à la colonne donnée en argument.
	 * @param col, la colonne.
	 * @return la liste de cases.
	 */
	private List<Case> getCol(int col){
		List<Case> res = new ArrayList<>();
		for (int i = 0; i < grille.nbLig(); i++) {
			res.add(grille.getCase(i,col));
		}
		return res;
	}
	/**
	 * Renvoie la liste des emplacements.
	 * @return la liste des emplacements.
	 */
	public List<Emplacement> getPlaces(){
		return places;
	}
	/**
	 * Renvoie le nombre de mots horizontaux.
	 * @return le nombre d'emplacements à l'horizontale.
	 */
	public int getNbHorizontal() {
		return nbHorizontal;
	}
	/**
	 * Renvoie le nombre de mots verticaux.
	 * @return le nombre d'emplacements à la verticale.
	 */
	public int getNbVertical() {
		return nbVertical;
	}
	
	//Affichage
	/**
	 * Affiche le contenu de chaque emplacement, un mot par ligne.
	 * @return la chaine de caractères correspondant aux mots.
	 */
	@Override
	public String toString() {
		String s = "";
	    for(Emplacement e : places){
	      s += e.toString() + '\n';
	    }
	    return s;
	}
	/**
	 * Renvoie une nouvelle grille où les cases 
	 * constituant l’emplacement de mot d’indice m 
	 * ont pour contenu les lettres de soluce. 
	 * @param m, l'indice du mot.
	 * @param soluce, le mot.
	 * @return la grille où les cases ont pour contenu les lettres de soluce.
	 */
	public GrillePlaces fixer(int m, String soluce) {
		GrillePlaces newGP = new GrillePlaces(grille.copy());
		for (int i = 0; i < soluce.length(); i++) {
			newGP.places.get(m).getLettres().get(i).setChar(soluce.charAt(i));
		}
		return newGP;
	}
}
