package pobj.motx.tme1;
/**
 * Classe de représentation d'une case dans une grille de mots croisés.
 * @author Enorovan + [REDACTED]
 */
public class Case{
	//Attributes
	/** Indice de ligne où se trouve la case. */
	private int ligne;
	/** Indice de colonne où se trouve la case. */
	private int colonne;
	/** Symbole contenu dans la case. */
	private char symbole;
	
	//Constructor
	/**
	 * Construit une case de coordonées et de contenus spécifiés.
	 * @param lig, la ligne où se trouve la case.
	 * @param col, la colonne où se trouve la case.
	 * @param c, le contenu de la case
	 */
	public Case(int lig, int col, char c){
		ligne = lig;
		colonne = col;
		symbole = c;
	}

	//Methods
	//Getters
	/**
	 * Accède a l'indice de ligne de la case.
	 * @return l'indice de ligne de la case.
	 */
	public int getLig(){
		return ligne;
	}
	/**
	 * Accède a l'indice de colonne de la case.
	 * @return l'indice de colonne de la case.
	 */
	public int getCol(){
		return colonne;
	}
	/**
	 * Accède au contenu de la case.
	 * @return le contenu de la case.
	 */
	public char getChar(){
		return symbole;
	}
	//Setter
	/**
	 * Modifie le contenu de la case.
	 * @param c, le nouveau contenu.
	 */
	public void setChar(char c){
		symbole = c;
	}
	
	/**
	 * Vérifie si la case est vide (si son contenu est un espace).
	 * @return le résultat de l'opération booléenne sur la condition vide.
	 */
	public boolean isVide(){
		return symbole == ' ';
	}
	/**
	 * Vérifie si la case est pleine (si son contenu est une étoile).
	 * @return le résultat de l'opération booléenne sur la condition pleine.
	 */
	public boolean isPleine(){
		return symbole == '*';
	}
	/**
	 * Renvoie le booléen du test d'égalité sur la case.
	 * @return le booléen du test d'égalité sur la case.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false ;
		if (!(o instanceof Case)) return false;
		Case other = (Case) o;
		if (ligne != other.ligne) return false;
		if (colonne != other.colonne) return false;
		if (symbole != other.symbole) return false;
		return true;
	}
}