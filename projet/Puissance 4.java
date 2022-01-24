package projet;
import java.util.Scanner;
import java.util.Random;

class Exercice1 {
	static int LigneTotal = 6;
	static int ColonneTotal = 7;
	static int[][] grille = new int[LigneTotal][ColonneTotal]; // On declare notre grille de puissance 4

	public static void initialiseGrille() {// Avec cette fonction on initialise la grille avec des valeurs de 0 dans
											// chaque case
		for (int Ligne = 0; Ligne < LigneTotal; Ligne++) {
			for (int Colonne = 0; Colonne < ColonneTotal; Colonne++) {
				grille[Ligne][Colonne] = 0;
			}
		}
	}

	public static void jouer(int numeroJoueur, int ColonneChoisie) {// Cette foction permet de remplacer l'un des 0 de
																	// la grille par une valeur ratache a un joueur (1
																	// ou 2)
		for (int Ligne = 0; Ligne < 6; Ligne++) {
			if (grille[Ligne][ColonneChoisie] == 0) {
				grille[Ligne][ColonneChoisie] = numeroJoueur;
				Ligne = 6;
			}
		}
	}

	public static void afficheGrille() {// Fonction pour afficher la grille (le type d'affichage est impose)
		for (int Ligne = 0; Ligne < LigneTotal; Ligne++) {
			for (int Colonne = 0; Colonne < ColonneTotal; Colonne++) {
				if (grille[LigneTotal - Ligne - 1][Colonne] == 1) {
					System.out.print("|X");
				} else if (grille[LigneTotal - Ligne - 1][Colonne] == 2) {
					System.out.print("|O");
				} else {
					System.out.print("| ");
				}

			}
			System.out.println("|");
		}
		for (int numeroColonne = 0; numeroColonne < ColonneTotal; numeroColonne++) {
			System.out.print(" " + numeroColonne);
		}
	}

//On ecrit ensuite les 4 algorithme de verification qui correspondent chacun a un type de victoire possible dans d'un puissance 4
	public static boolean aGagneHor(int numeroJoueur, int numeroLigne, int numeroColonne) {
		return ((numeroColonne < 4) && (grille[numeroLigne][numeroColonne] == numeroJoueur)
				&& (grille[numeroLigne][numeroColonne + 1] == numeroJoueur)
				&& (grille[numeroLigne][numeroColonne + 2] == numeroJoueur)
				&& (grille[numeroLigne][numeroColonne + 3] == numeroJoueur));
	}

	public static boolean aGagneVer(int numeroJoueur, int numeroLigne, int numeroColonne) {
		return ((numeroLigne < 3) && (grille[numeroLigne][numeroColonne] == numeroJoueur)
				&& (grille[numeroLigne + 1][numeroColonne] == numeroJoueur)
				&& (grille[numeroLigne + 2][numeroColonne] == numeroJoueur)
				&& (grille[numeroLigne + 3][numeroColonne] == numeroJoueur));
	}

	public static boolean aGagneDiagDesc(int numeroJoueur, int numeroLigne, int numeroColonne) {
		return ((numeroLigne > 2) && (numeroColonne < 4) && (grille[numeroLigne][numeroColonne] == numeroJoueur)
				&& (grille[numeroLigne - 1][numeroColonne + 1] == numeroJoueur)
				&& (grille[numeroLigne - 2][numeroColonne + 2] == numeroJoueur)
				&& (grille[numeroLigne - 3][numeroColonne + 3] == numeroJoueur));
	}

	public static boolean aGagneDiagMont(int numeroJoueur, int numeroLigne, int numeroColonne) {
		return ((numeroLigne < 3) && (numeroColonne < 4) && (grille[numeroLigne][numeroColonne] == numeroJoueur)
				&& (grille[numeroLigne + 1][numeroColonne + 1] == numeroJoueur)
				&& (grille[numeroLigne + 2][numeroColonne + 2] == numeroJoueur)
				&& (grille[numeroLigne + 3][numeroColonne + 3] == numeroJoueur));
	}

//La fonction suivante permet de detecter si apres un coup joue par l'un des joueurs, ce dernier gagne la partie ou non
	public static boolean aGagneOuNulle(int numeroJoueur, int nombreDeCoups) {
		for (int Ligne = 0; Ligne < LigneTotal; Ligne++) {
			for (int Colonne = 0; Colonne < ColonneTotal; Colonne++) {// On verifie si les 4 algorithme precedents
																		// renvoi vraie ou faux pour chacune des cases
																		// de la grille
				if ((aGagneHor(numeroJoueur, Ligne, Colonne)) || (aGagneVer(numeroJoueur, Ligne, Colonne))
						|| (aGagneDiagMont(numeroJoueur, Ligne, Colonne))
						|| (aGagneDiagDesc(numeroJoueur, Ligne, Colonne))
						|| (nombreDeCoups > LigneTotal * ColonneTotal)) {
					return true;
				}
			}
		}
		return false;
	}

//Si l'un des joueurs gagne, on souhaite recuperer les coordonnees de la case pour laquel l'un des algorithme de verification renvoi true
	public static int numeroLigneGagne(int numeroJoueur) {
		for (int Ligne = 0; Ligne < LigneTotal; Ligne++) {
			for (int Colonne = 0; Colonne < ColonneTotal; Colonne++) {
				if ((aGagneHor(numeroJoueur, Ligne, Colonne)) || (aGagneVer(numeroJoueur, Ligne, Colonne))
						|| (aGagneDiagMont(numeroJoueur, Ligne, Colonne))
						|| (aGagneDiagDesc(numeroJoueur, Ligne, Colonne))) {
					return Ligne;
				}
			}
		}
		return -1;// on sait � l'avance que la fonction ne pourra jamais renvoyer -1 car il n'est
					// utilise dans le main que si la condition victoire est vraie
	}

	public static int numeroColonneGagne(int numeroJoueur) {
		for (int Ligne = 0; Ligne < LigneTotal; Ligne++) {
			for (int Colonne = 0; Colonne < ColonneTotal; Colonne++) {
				if ((aGagneHor(numeroJoueur, Ligne, Colonne)) || (aGagneVer(numeroJoueur, Ligne, Colonne))
						|| (aGagneDiagMont(numeroJoueur, Ligne, Colonne))
						|| (aGagneDiagDesc(numeroJoueur, Ligne, Colonne))) {
					return Colonne;
				}
			}
		}
		return -1;// M�me chose que pour numeroLigneGagne
	}

	// On veut afficher quel joueur a gagne et de quelle mani�re
	public static void afficheCommentGagne(int a, int x, int y) {
		System.out.println();
		if (aGagneHor(a, x, y))
			System.out.println("Le joueur " + a + " a gagne en alignant 4 pions horizontalement");
		else if (aGagneVer(a, x, y))
			System.out.println("Le joueur " + a + " a gagne en alignant 4 pions verticalement");
		else if (aGagneDiagMont(a, x, y))
			System.out.println("Le joueur " + a + " a gagne en alignant 4 pions en diagonale montante");
		else if (aGagneDiagDesc(a, x, y))
			System.out.println("Le joueur " + a + " a gagne en alignant 4 pions en diagonale descendante");
		else
			System.out.println("MATCH NUL");

	}

	public static boolean verifieJouabiliteCoup(int ColonneChoisie) {// Avant chaque coup, on veut verifier si la
																		// colonne choisie peut acceullir un nouveau
																		// jeton ou non
		boolean result = true;
		if (ColonneChoisie < 0 || ColonneChoisie > 6)
			result = false;// La colonne choisie est en dehors des valeurs autorise en entree (de 0 � 6)
		else if (grille[5][ColonneChoisie] != 0) {// Si la derni�re ligne de grile est libre(vaut 0) alors le coupe est
													// jouable sinon il ne l'est pas
			result = false;
		}
		return result;
	}

	public static int[][] copieUnTab_6Par7(int[][] ancienTab) {
		int[][] copieTab = new int[LigneTotal][ColonneTotal];
		for (int Ligne = 0; Ligne < LigneTotal; Ligne++) {
			for (int Colonne = 0; Colonne < ColonneTotal; Colonne++) {
				copieTab[Ligne][Colonne] = ancienTab[Ligne][Colonne];
			}
		}
		return copieTab;
	}

	public static int victoireEn1Coup(int numeroJoueur, int nombreDeCoups) {
		int[][] grilleAvantCoup = copieUnTab_6Par7(grille);
		for (int Colonne = 0; Colonne < ColonneTotal; Colonne++) {
			if (verifieJouabiliteCoup(Colonne)) {
				jouer(numeroJoueur, Colonne);
				if (aGagneOuNulle(numeroJoueur, ++nombreDeCoups)) {
					grille = copieUnTab_6Par7(grilleAvantCoup);
					return Colonne;
				}
				grille = copieUnTab_6Par7(grilleAvantCoup);
			}
		}
		return -1;
	}

	public static void ordiJoueMeilleurCoup(int numeroJoueur, int nombreDeCoup) {
		int[] tab = { 0, 0, 0, 0, 0, 0, 0 };
		int nombreDeCoupSansPerdre = 0;
		int[][] grilleAvantCoup = copieUnTab_6Par7(grille);
		for (int Colonne = 0; Colonne < ColonneTotal; Colonne++) {
			if (verifieJouabiliteCoup(Colonne)) {
				jouer(numeroJoueur, Colonne);
				numeroJoueur = 3 - numeroJoueur;
				if ((victoireEn1Coup(numeroJoueur, nombreDeCoup)) == -1) {
					tab[nombreDeCoupSansPerdre++] = Colonne;
				}
				numeroJoueur = 3 - numeroJoueur;
				grille = copieUnTab_6Par7(grilleAvantCoup);
			}
		}
		if (nombreDeCoupSansPerdre == 0) {
			Random ColonneRandom = new Random();
			int nb = ColonneRandom.nextInt(7);
			jouer(numeroJoueur, nb);
			System.out.println("L'ordi � jou� " + nb);
		} else {
			if (nombreDeCoupSansPerdre == 1) {
				jouer(numeroJoueur, tab[0]);
				System.out.println("L'ordi � jou� " + tab[0]);
			} else {
				Random ColonneRandom = new Random();
				int nb = ColonneRandom.nextInt(nombreDeCoupSansPerdre - 1);
				jouer(numeroJoueur, tab[nb]);
				System.out.println("L'ordi � jou� " + tab[nb]);

			}

		}

	}

	public static void jeuA2Joueurs(int numeroJoueur, int nombreDeCoup) {
		Scanner sc = null;
		while (aGagneOuNulle(numeroJoueur, nombreDeCoup) == false) {// tant que personne n'a gagne et qu'il reste de
			// la
			// place dans la grille, on rejoue un coup

			sc = new Scanner(System.in);
			afficheGrille();// on reaffiche la grille avant chaque coup
			System.out.println();
			numeroJoueur = 3 - numeroJoueur;// On change de joueur a chaque coup via cette fonction
			System.out.println("Quel coup pour le joueur " + numeroJoueur + " ?");
			try {
// On recupère un numero de colonne
				int numeroColonne = sc.nextInt();

				if (verifieJouabiliteCoup(numeroColonne)) {// on verifie si l'entier entre est valide
					jouer(numeroJoueur, numeroColonne);
					nombreDeCoup++;// on incremente le nombre de coup � chaque coup pour savoir si il reste de la
									// place dans la grille ou non
					System.out.println();
					System.out.println();
					System.out.println();
				} else {
					System.out.println("Joueur " + numeroJoueur + ", veuillez rejouer un coup valide.");
					numeroJoueur = 3 - numeroJoueur;// On demande au joueur de rejouer un coup valide
				}
			} catch (Exception e) {// on catch touts les exeptions possibles lors de l'etree d'un numero de colonne
// notament MismatchInputExeption
				System.out.println("Veuillez entrer un entier");
				numeroJoueur = 3 - numeroJoueur;
			}
		}

		afficheGrille();// Une fois que quelqu'un a gagne, on reaffiche la grille et on affiche qui a
// gagne et comment
		afficheCommentGagne(numeroJoueur, numeroLigneGagne(numeroJoueur), numeroColonneGagne(numeroJoueur));
		if (sc != null)
			sc.close();
	}

	public static void jeuA1Joueurs(int numeroJoueur, int nombreDeCoup) {
		Scanner sc = null;
		while (aGagneOuNulle(numeroJoueur, nombreDeCoup) == false) {// tant que personne n'a gagne et qu'il reste de
			// la
// place dans la grille, on rejoue un coup

			sc = new Scanner(System.in);
			afficheGrille();// on reaffiche la grille avant chaque coup
			System.out.println();
			numeroJoueur = 3 - numeroJoueur;// On change de joueur a chaque coup via cette fonction
			if (numeroJoueur == 1) {
				System.out.println("Quel coup voulez-vous jouer ?");
				try {
//On recup�re un numero de colonne
					int numeroColonne = sc.nextInt();

					if (verifieJouabiliteCoup(numeroColonne)) {// on verifie si l'entier entre est valide
						jouer(numeroJoueur, numeroColonne);
						nombreDeCoup++;// on incremente le nombre de coup � chaque coup pour savoir si il reste de
// la
//place dans la grille ou non
					} else {
						System.out.println("Veuillez rejouer un coup valide.");
						numeroJoueur = 3 - numeroJoueur;// On demande au joueur de rejouer un coup valide
					}
				} catch (Exception e) {// on catch toutes les exceptions possibles lors de l'etree d'un numero de
// colonne
// notament MismatchInputExeption
					System.out.println("Veuillez entrer un entier");
					numeroJoueur = 3 - numeroJoueur;
				}
			} else {
				System.out.println();
				System.out.println();
				System.out.println();
				if (victoireEn1Coup(numeroJoueur, nombreDeCoup) != -1) {
					System.out.println("L'ordi � jou� " + victoireEn1Coup(numeroJoueur, nombreDeCoup));
					jouer(numeroJoueur, victoireEn1Coup(numeroJoueur, nombreDeCoup));
				} else {
					ordiJoueMeilleurCoup(numeroJoueur, nombreDeCoup);

				}
				nombreDeCoup++;
			}
		}
	}

	public static void main(String[] args) {

		initialiseGrille();
		int numeroJoueur = 2;	// On l'initialise a joueur 2 car avant chaque coup(m�me le premier) on a
								// numeroJoueur=3-numeroJoueur
		int nombreDeCoup = 1;
		Scanner sc = null;

		int nombreDeJoueurs = 0;
		while ((nombreDeJoueurs != 1) && (nombreDeJoueurs != 2)) {
			try {
				System.out.println("Entrez 2 pour jouer � 2  joueurs et 1 pour jouer contre l'ordinateur");
				sc = new Scanner(System.in);
				nombreDeJoueurs = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Entrez un entier entre 1 et 2 svp");
			}
		}
		if (nombreDeJoueurs == 2) {
			jeuA2Joueurs(numeroJoueur, nombreDeCoup);
			afficheGrille();// Une fois que quelqu'un a gagne, on reaffiche la grille et on affiche qui a
			// gagne et comment
			afficheCommentGagne(numeroJoueur, numeroLigneGagne(numeroJoueur), numeroColonneGagne(numeroJoueur));
			if (sc != null)
				sc.close();

		} else if (nombreDeJoueurs == 1) {
			jeuA1Joueurs(numeroJoueur, nombreDeCoup);
			afficheGrille();// Une fois que quelqu'un a gagne, on reaffiche la grille et on affiche qui a
			// gagne et comment
			afficheCommentGagne(numeroJoueur, numeroLigneGagne(3-numeroJoueur), numeroColonneGagne(3-numeroJoueur));
			if (sc != null)
				sc.close();
		}
	}
}

/**
 * ere erreur si modification les variable globale 
 * de taille le programme crash car il y a pour l'ia un tableau de créé avec une taille static 
 */