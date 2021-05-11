package Projet_IA;

import java.util.ArrayList;

public class PlateauPrincipal extends Plateau<PlateauSub>{
		
	//Constructeur
	public PlateauPrincipal() {
		plateau= new ArrayList<PlateauSub>();
		initialisation();
	}
	
	//Methodes
	/**
	 * Methode ajoutant les 9 plateaux dans le plateau principal
	 */
	public void initialisation() {
		PlateauSub platSub = new PlateauSub();
		for(int i = 0 ; i < 9 ; i++) {
			plateau.add(platSub);
		}
	}
	
	/**
	 * Methode verifiant si un plateau n'est plus utilisable (gagne ou rempli)
	 */
	public void verifPlateau() {
		//Parcours tous les plateaux
		for(int i = 0 ; i < 9 ; i++) {
			//Condition verifiant si le plateau est gagnante ou remplie
			if(plateau.get(i).verifZone() || plateau.get(i).verifZoneRemplie()) {
				//TODO : Regarder comment "neutraliser" la zone
			}
		}
	}
	
	/**
	 * Renvoie le plateau sous forme de String
	 */
	public String toString() {
		StringBuilder tmp= new StringBuilder();
		
		tmp.append("|¯¯¯T¯¯¯T¯¯¯TT¯¯¯T¯¯¯T¯¯¯TT¯¯¯T¯¯¯T¯¯¯|\n");
		//tmp.append("|   |   |   ||   |   |   ||   |   |    |\n");
		tmp.append(plateau.get(0).toString()+plateau.get(1).toString()+plateau.get(2).toString());
		tmp.append("|___|___|___||___|___|___||___|___|___|\n");
		tmp.append("|   |   |   ||   |   |   ||   |   |   |\n");
		tmp.append(plateau.get(3).toString()+plateau.get(4).toString()+plateau.get(5).toString());
		tmp.append("|___|___|___||___|___|___||___|___|___|\n");
		tmp.append("|   |   |   ||   |   |   ||   |   |   |\n");
		tmp.append(plateau.get(6).toString()+plateau.get(7).toString()+plateau.get(8).toString());
		tmp.append("|___|___|___||___|___|___||___|___|___|");
		
		
		tmp.append("\n");
		return tmp.toString();
	}
	

}