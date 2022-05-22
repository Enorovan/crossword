package pobj.motx.tme1;
/**
 * Classe de représentation d'une grille de mots croisés.
 * @author Enorovan + [REDACTED]
 */
public class Grille{
	//Attributes
	/** Grille composée de cases. */
	private Case[][] grille;
	
	//Constructor
	/**
	 * Construit une grille de hauteur et largeur spécifiées.
	 * @param hauteur, le nombre de lignes dans la grille.
	 * @param largeur, le nombre de colonnes dans la grille.
	 */
	public Grille(int hauteur, int largeur){
		grille = new Case[hauteur][largeur];
		for(int i = 0; i < hauteur; i++){
			for(int j = 0; j < largeur; j++){
				grille[i][j] = new Case(i,j,' ');
			}
		}
	}
	
	//Methods
	/**
	 * Accède a la case située à la position (lig,col) spécifiée.
	 * @param lig, la ligne où est située la case.
	 * @param col, la colonne où est située la case.
	 * @return la case située à la position (lig,col) spécifiée.
	 */
	public Case getCase(int lig, int col){
		return grille[lig][col];
	}
	/**
	 * Renvoie le nombre de lignes de la grille.
	 * @return le nombre de lignes de la grille.
	 */
	public int nbLig(){	
		return grille.length;
	}
	/**
	 * Renvoie le nombre de colonnes de la grille.
	 * @return le nombre de colonnes de la grille.
	 */
	public int nbCol(){
		return grille[0].length;
	}
	/**
	 * Affiche la grille.
	 * @return la chaine de caractères correspondante à l'affichage de la grille.
	 */
	@Override
	public String toString(){
		return GrilleLoader.serialize(this, false);
	}
	/**
	 * Renvoie une copie de la grille.
	 * @return une grille, copie de la grille.
	 */
	public Grille copy(){
		int nbLig = this.nbLig();
		int nbCol = this.nbCol();
		Grille grilleCopy = new Grille(nbLig, nbCol);
		for(int i = 0; i < nbLig; i++){
			for(int j = 0; j < nbCol; j++){
				grilleCopy.grille[i][j] = new Case(i, j, this.getCase(i,j).getChar());
			}
		}
		return grilleCopy;
	}
}