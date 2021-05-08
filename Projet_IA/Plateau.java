package git_Projet_IA;

import java.util.ArrayList;

public class Plateau<T> {
	//Attributs
	private ArrayList<T> plateau;
	
	//Constructeurs
	public Plateau() {
		plateau = new ArrayList<T>();
	}
	
	//M�thodes
	
	/**
	 * 
	 * @return plateau le plateau de jeu actuel
	 */
	public ArrayList<T> getPlateau(){
		return plateau;
	}
}
