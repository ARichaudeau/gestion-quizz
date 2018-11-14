package fr.diginamic.console;

import java.util.Scanner;

public class Menu {

	public static void afficherMenu() {
	System.out.println("**** Quizz Administration ****");
	System.out.println("1. Lister les questions");
	System.out.println("2. Ajouter une nouvelle question");
	System.out.println("3. Supprimer une question");
	System.out.println("4. Exécuter le quizz");
	System.out.println("99. Sortir");
	
	}
	
	public static void choixUtilisateur() {
		System.out.println("Veuillez faire un choix");
		Scanner questionUser = new Scanner(System.in);
		int a = questionUser.nextInt();
		switch (a) {
		case (1) :
			System.out.println("Liste des questions");
			afficherMenu();
		break;	
		case (2) : 
			System.out.println("Ajout d'une nouvelle question");
			afficherMenu();
		break;
		case (3) :
			System.out.println("Suppression d'une question");
			afficherMenu();
		break;
		case (4) :
			System.out.println("Exécution du quizz");
			afficherMenu();
		case (99) :
			System.out.println("Au revoir");
		break;
		default : 
			System.out.println("Mauvaise saisie");
		break;
		}
	}
}

