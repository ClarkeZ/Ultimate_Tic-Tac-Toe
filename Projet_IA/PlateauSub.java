package Projet_IA;

import java.util.ArrayList;

public class PlateauSub extends Plateau<Case> {
	//Attributs
	
	//Derniere case remplie par un joueur dans cette zone
	private int derniereCase;
	
	//Valeur de la zone
	private Valeur valeur;

	//Position de la zone dans le plateau principal
	private int position;
	
	//Constructeur
	public PlateauSub(int position) {
		super.plateau = new ArrayList<Case>();
		initialisation();
		this.valeur=new Valeur();
		this.position=position;
	}

	public PlateauSub(int position,int niveau) {
		plateau = new ArrayList<Case>();
		initialisation();
		this.valeur=new Valeur(niveau);
		this.position=position;
	}
	

	//Methodes
	
	/**
	 * Methode ajoutant les 9 cases dans le plateau 
	 */
	public void initialisation() {
		
		for(int i = 0 ; i < 9 ; i++) {
			Case Case = new Case(i);
			plateau.add(Case);
		}
	}
	
	/**
	 * Methode renvoyant la case choisie par l'utilisateur
	 * 
	 * @param num le numero de la case a recuperer
	 * @return la case choisie par l'utilisateur
	 */
	public Case getCase(int num) {
		return plateau.get(num);
	}
	
	/**
	 * Methode renvoyant la position de la derniere case a avoir ete modifie dans cette zone
	 * 
	 * @return la position de la derniere case de la zone a avoir ete modifie
	 */
	public int getDerniereCase() {
		return derniereCase;
	}
	
	/**
	 * Methode renvoyant la valeur de la zone
	 * @return la valeur de la zone
	 */
	public Valeur getValeur() {
		return valeur;
	}
	
	/**
	 * Methode changeant la valeur de la zone par celle entree en parametre
	 * @param v valeur a appliquer
	 */
	public void setValeur(Valeur v) {
		this.valeur=v;
	}
	
	/**
	 * Fixe la position de la derniere case a avoir ete modifie
	 * @param pos numero de la case
	 */
	public void setDerniereCase(int pos) {
		derniereCase=pos;
	}
	
	/**
	 * Methode ajoutant le symbole a�  la position donnee
	 * 
	 * @param pos : la position de la case dans le plateau
	 * @param symbole : le symbole "X" (-1) ou "O" (1)
	 */
	public void setCase(int pos, int symbole) {
		plateau.get(pos).setSymbole(symbole);
	}
	
	/**
	 * Renvoie le plateau sous forme de String
	 */
	public String toString() {
		StringBuilder tmp = new StringBuilder();
		
		
		tmp.append("| "+plateau.get(0).toString()+" | "+plateau.get(1).toString()+" | "+plateau.get(2).toString());
		tmp.append(" || "+plateau.get(3).toString()+" | "+plateau.get(4).toString()+" | "+plateau.get(5).toString()+"");
		tmp.append(" || "+plateau.get(6).toString()+" | "+plateau.get(7).toString()+" | "+plateau.get(8).toString()+" |\n");
		return tmp.toString();
	}
	
	/**
	 * Methode affichant la zone de jeu pour permettre au joueur de choisir sa case
	 * 
	 * @return String Zone de jeu avec les symboles pour les cases remplies et des chiffres pour les cases non remplies
	 */
	public String affiche() {
		StringBuilder tmp= new StringBuilder();
		
		tmp.append(" "+showCase(plateau.get(0),1)+"|"+showCase(plateau.get(1),2)+"|"+showCase(plateau.get(2),3)+"\n");
		tmp.append(" -+-+-\n");
		tmp.append(" "+showCase(plateau.get(3),4)+"|"+showCase(plateau.get(4),5)+"|"+showCase(plateau.get(5),6)+"\n");
		tmp.append(" -+-+-\n");
		tmp.append(" "+showCase(plateau.get(6),7)+"|"+showCase(plateau.get(7),8)+"|"+showCase(plateau.get(8),9)+"\n");
		
		
		tmp.append("\n");
		return tmp.toString();
	}
	
	/**
	 * Affiche une ligne de la zone
	 * @param ligne Numero de la ligne a afficher
	 * @return String contenant la ligne a afficher
	 */
	public String afficheLigne(int ligne) {
		//Premiere ligne
		if(ligne==1) {
			//Cas ou la zone est gagnee
			if (verifZone()) {
				int gagnant = getSymboleGagnant();
				
				//Cas ou le symbole est une croix
				if (gagnant==-1) {
					return "| "+"X"+" |   | "+"X"+" |";
				}
					
				//Cas ou le symbole est un cercle
				else {
					return "| "+"O"+" | "+"O"+" | "+"O"+" |";
				}	
			}
			//Cas ou la zone est remplie ou contient encore de l'espace
			else {
				return "| "+showCase(plateau.get(0))+" | "+showCase(plateau.get(1))+" | "+showCase(plateau.get(2))+" |";	
			}
		}
		
		//Deuxieme ligne
		else if(ligne==2) {
			//Cas ou la zone est gagnee
			if(verifZone()) {
				int gagnant= getSymboleGagnant();
				
				//Cas ou le symbole est une croix
				if (gagnant==-1) {
					return "|   | "+"X"+" |   |";
				}
					
				//Cas ou le symbole est un cercle
				else {
					return "| "+"O"+" |   | "+"O"+" |";
				}	
			}
			//Cas ou la zone est remplie ou contient encore de l'espace
			else {
				return "| "+showCase(plateau.get(3))+" | "+showCase(plateau.get(4))+" | "+showCase(plateau.get(5))+" |";
			}
		}
		
		//Troisieme ligne
		else
			//Cas ou la zone est gagnee
			if(verifZone()) {
				int gagnant = getSymboleGagnant();
				
				//Cas ou le symbole est une croix
				if (gagnant==-1) {
					return "| "+"X"+" |   | "+"X"+" |";
				}
					
				//Cas ou le symbole est un cercle
				else {
					return "| "+"O"+" | "+"O"+" | "+"O"+" |";
				}	
			}
			//Cas ou la zone est remplie ou contient encore de l'espace
			else {
				return "| "+showCase(plateau.get(6))+" | "+showCase(plateau.get(7))+" | "+showCase(plateau.get(8))+" |";
			}
	}
	
	/**
	 * Methode renvoyant un String correspondant au symbole ou a la position de la case dans la zone
	 * 
	 * @param c Case dont le contenu est examine
	 * @param pos Position de la case dans la zone
	 * @return Un String correspondant au numero de la case dans la zone ou de son symbole
	 */
	public String showCase(Case c, int pos) {
		if (c.getContenu()==0) {
			String tmp = Integer.toString(pos);
			return tmp;
		}
		else
			//Cas ou le contenu est egal a -1
			if(c.getContenu()==-1)
				return "X";
			//Cas ou le contenu est egal a 1
			else
				return "O";
			
	}
	
	/**
	 * Methode renvoyant un String contenant le symbole de la case 
	 * ou un espace si celle-ci est vide
	 * 
	 * @param c la case a examiner
	 * @return Un String contenant le symbole de la case ou un espace
	 */
	public String showCase(Case c) {
		//Cas ou le contenu est egal a -1
		if(c.getContenu()==-1)
			return "X";
		//Cas ou le contenu est egal a 1
		else if(c.getContenu()==1) {
			return "O";
		}
		else {
			return " ";
		}
			
	}
	
	/**
	 * Verifie qu'un joueur a rempli une ligne
	 * 
	 * @return boolean, true si une ligne est remplie par un meme symbole, false sinon
	 */
	public boolean verifZone() {
		//Premiere ligne
		if(plateau.get(0).getContenu()!=0 && plateau.get(1).getContenu()!=0 && plateau.get(2).getContenu()!=0) {
			if((plateau.get(0).getContenu()==plateau.get(1).getContenu()) && (plateau.get(0).getContenu()==plateau.get(2).getContenu())) {
				setSymboleGagnant(plateau.get(0).getContenu());
				return true;
			}
		}
		//Deuxieme ligne
		if(plateau.get(3).getContenu()!=0 && plateau.get(4).getContenu()!=0 && plateau.get(5).getContenu()!=0) {
			if((plateau.get(3).getContenu()==plateau.get(4).getContenu()) && (plateau.get(3).getContenu()==plateau.get(5).getContenu())) {
				setSymboleGagnant(plateau.get(3).getContenu());
				return true;
			}
		}
		//Troisieme ligne
		if(plateau.get(6).getContenu()!=0 && plateau.get(7).getContenu()!=0 && plateau.get(8).getContenu()!=0) {
			if((plateau.get(6).getContenu()==plateau.get(7).getContenu()) && (plateau.get(6).getContenu()==plateau.get(8).getContenu())) {
				setSymboleGagnant(plateau.get(6).getContenu());
				return true;
			}
		}
		//Premiere colonne
		if(plateau.get(0).getContenu()!=0 && plateau.get(3).getContenu()!=0 && plateau.get(6).getContenu()!=0) {
			if((plateau.get(0).getContenu()==plateau.get(3).getContenu()) && (plateau.get(0).getContenu()==plateau.get(6).getContenu())) {
				setSymboleGagnant(plateau.get(0).getContenu());
				return true;
			}
		}
		//Deuxieme colonne
		if(plateau.get(1).getContenu()!=0 && plateau.get(4).getContenu()!=0 && plateau.get(7).getContenu()!=0) {
			if((plateau.get(1).getContenu()==plateau.get(4).getContenu()) && (plateau.get(1).getContenu()==plateau.get(7).getContenu())) {
				setSymboleGagnant(plateau.get(1).getContenu());
				return true;
			}
		}
		//Troisieme colonne
		if(plateau.get(2).getContenu()!=0 && plateau.get(5).getContenu()!=0 && plateau.get(8).getContenu()!=0) {
			if((plateau.get(2).getContenu()==plateau.get(5).getContenu()) && (plateau.get(2).getContenu()==plateau.get(8).getContenu())) {
				setSymboleGagnant(plateau.get(2).getContenu());
				return true;
			}
		}
		//Diagonale gauche
		if(plateau.get(4).getContenu()!=0 && plateau.get(0).getContenu()!=0 && plateau.get(8).getContenu()!=0) {
			if((plateau.get(4).getContenu()==plateau.get(0).getContenu()) && (plateau.get(4).getContenu()==plateau.get(8).getContenu())) {
				setSymboleGagnant(plateau.get(4).getContenu());
				return true;
			}
		}
		//Diagonale droite
		if(plateau.get(4).getContenu()!=0 && plateau.get(2).getContenu()!=0 && plateau.get(6).getContenu()!=0) {
			if((plateau.get(4).getContenu()==plateau.get(2).getContenu()) && (plateau.get(4).getContenu()==plateau.get(6).getContenu())) {
				setSymboleGagnant(plateau.get(4).getContenu());
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Verifie si la zone est remplie ou non
	 * 
	 * @return boolean, true si la zone est remplie donc si les 9 cases contiennent un symbole, false sinon
	 */
	public boolean verifZoneRemplie() {
		//Verifie que toutes les cases sont remplies, donc non vide
		if(	plateau.get(0).getContenu()==0 || plateau.get(1).getContenu()==0 || plateau.get(2).getContenu()==0 ||
			plateau.get(3).getContenu()==0 || plateau.get(4).getContenu()==0 || plateau.get(5).getContenu()==0 ||
			plateau.get(6).getContenu()==0 || plateau.get(7).getContenu()==0 || plateau.get(8).getContenu()==0
		)
			return false;
		else
			return true;
	}
	
	/**
	 * Methode mettant a jour la valeur de la zone et de ses alentours
	 * en fonction de son contenu
	 * @param symboleJoueur Symbole du joueur appliquant la methode
	 * @param platP Plateau principal ou se trouve la zone de jeu
	 */
	public void majValeur(int symboleJoueur, PlateauPrincipal platP) {
		//ArrayList permettant de verifier la disponibilite des lignes
		ArrayList<Boolean> verifLignesAdverses= new ArrayList<Boolean>();
		ArrayList<Boolean> verifLignesAlliees= new ArrayList<Boolean>();
		for(int i=0;i<8;i++) {
			verifLignesAdverses.add(false);
			verifLignesAlliees.add(false);
		}
		//Analyse des cases
		for(Case c : plateau) {
			//Mise a jour de la valeur pour chaque case adverse presente
			valeur.caseAdversePresente(symboleJoueur, c);
			//Mise a jour de la valeur pour chaque case alliee presente
			valeur.caseAllieePresente(symboleJoueur, c);
			
			//Mise a jour de la valeur si des cases sont sur des bords si l'IA est intermediaire ou difficile
			
			//Mise a jour de la valeur pour chaque case adverse presente sur les bords
			valeur.caseAdverseBord(symboleJoueur, c);
			//Mise a jour de la valeur pour chaque case alliee presente sur les bords
			valeur.caseAllieeBord(symboleJoueur, c);
			
			//Mise a jour de la valeur si des lignes adverses sont possibles
			valeur.ligneAdversePossible(symboleJoueur, c, this, verifLignesAdverses);
			//Mise a jour de la valeur si des lignes alliees sont possibles
			valeur.ligneAllieePossible(symboleJoueur, c, this, verifLignesAlliees);
		}
		
		//Cas ou la zone est gagnee par un joueur
		if(verifZone()) {
			//Cas ou l'adversaire a rempli la zone
			if(getSymboleGagnant()!=symboleJoueur) {
				//Mise a jour de la valeur des zones voisines
				valeur.zoneValideeAdversaire(position, platP);
			}
			
			//Cas ou la zone est gagnee par le joueur
			if(getSymboleGagnant()==symboleJoueur) {
				//Mise a jour des zones voisines
				valeur.zoneValideeAlliee(position, platP);
			}
		}
	}
	
}