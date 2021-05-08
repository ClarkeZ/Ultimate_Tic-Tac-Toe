package Projet_IA;

import java.util.ArrayList;

public class Plateau<T> {
	//Attributs
	protected ArrayList<T> plateau;
	
	//Constructeurs
	public Plateau() {
		plateau = new ArrayList<T>();
	}
	
	//M�thodes
	
	/**
	 * 
	 * @return plateau, le plateau de jeu actuel
	 */
	public ArrayList<T> getPlateau(){
		return plateau;
	}
	
	/**
	 * V�rifie qu'un joueur a rempli une ligne
	 * 
	 * @return boolean, true si une ligne est remplie par un m�me symbole, false sinon
	 */
	public boolean verifLigne() {
		//Premi�re ligne
		if(plateau.get(0).equals(plateau.get(1)) && plateau.get(0).equals(plateau.get(2)))
			return true;
		//Deuxi�me ligne
		if(plateau.get(3).equals(plateau.get(4)) && plateau.get(3).equals(plateau.get(5)))
			return true;
		//Troisi�me ligne
		if(plateau.get(6).equals(plateau.get(7)) && plateau.get(6).equals(plateau.get(7)))
			return true;
		//Premi�re colonne
		if(plateau.get(0).equals(plateau.get(3)) && plateau.get(0).equals(plateau.get(6)))
			return true;
		//Deuxi�me colonne
		if(plateau.get(1).equals(plateau.get(4)) && plateau.get(1).equals(plateau.get(7)))
			return true;
		//Troisi�me colonne
		if(plateau.get(2).equals(plateau.get(5)) && plateau.get(0).equals(plateau.get(8)))
			return true;
		//Diagonale gauche
		if(plateau.get(4).equals(plateau.get(0)) && plateau.get(4).equals(plateau.get(8)))
			return true;
		//Diagonale droite
		if(plateau.get(4).equals(plateau.get(2)) && plateau.get(4).equals(plateau.get(6)))
			return true;
		else
			return false;
	}
}
