package fr.diginamic.console;

import java.util.ArrayList;
import java.util.Scanner;

import fr.diginamic.exception.AjouterQuestionException;
import fr.diginamic.exception.StockageExceptionMere;
import fr.diginamic.model.Question;

public class Menu {
	
	static ArrayList<Question> questionList = new ArrayList<Question>();
	
	public static void afficherMenu() {
	System.out.println("**** Quizz Administration ****");
	System.out.println("1. Lister les questions");
	System.out.println("2. Ajouter une nouvelle question");
	System.out.println("3. Supprimer une question");
	System.out.println("4. Exécuter le quizz");
	System.out.println("99. Sortir");
	
	choixUtilisateur();
	
	}
	
	public static void listerQuestion(ArrayList<Question> questionList) {
		
		for (Question question : questionList) {
			System.out.println(question.getIntitule());
		}
	}
	
	public static void ajouterQuestion(ArrayList<Question> questionList) throws AjouterQuestionException {
		
		System.out.println("Veuillez saisir l'intitulé de la question :");
		Scanner questionUser = new Scanner(System.in);
		String intitule = questionUser.nextLine();
		Question q = new Question(intitule);
		System.out.println("Veuillez saisir le nombre de propositions :");
		int nb = Integer.parseInt(questionUser.nextLine());
		
		if (nb < 2) {
			throw new AjouterQuestionException("Le nombre de réponses doit être supérieur ou égal à 2");
		}
		
		for (int i = 0; i < nb; i++) {
			System.out.println("Veuillez saisir la proposition de réponse n° " + (i + 1));
			String reponse = questionUser.nextLine();
			q.addProposition(reponse);
		}
		
		System.out.println("Veuillez saisir la bonne réponse :");
		String bonneReponse = questionUser.nextLine();
		q.setBonneReponse(bonneReponse);
		
		questionList.add(q);

	}
	
	public static void supprimerQuestion(ArrayList<Question> questionList) {
		System.out.println("Veuillez choisir le numéro de la question à supprimer :");
		Scanner questionUser = new Scanner(System.in);
		int num = Integer.parseInt(questionUser.nextLine());
		questionList.remove(num-1);
	}
	
	public static void démarrerQuizz(ArrayList<Question> questionList) {
		int score = 0;
		int scoreTotal = 0;
		
		for (Question question : questionList) {
			System.out.println(question.getIntitule());
			for (String proposition : question.getPropositions()) {
				System.out.println(proposition);
			}
			System.out.println("Veuillez saisir la bonne réponse :");
			Scanner questionUser = new Scanner(System.in);
			String reponseSaisie = questionUser.nextLine();
			if (reponseSaisie.equals(question.getBonneReponse())) {
				System.out.println("Bonne réponse");
				scoreTotal = score + 1;
			} else {
				System.out.println("Mauvaise réponse");
			}
		}
		System.out.println("Vous avez " + scoreTotal + "bonne(s) réponse(s).");
	}
	
	public static void choixUtilisateur() {
		
		
		System.out.println("Veuillez faire un choix");
		Scanner questionUser = new Scanner(System.in);
		int a = questionUser.nextInt();
		switch (a) {
		case (1) :
			System.out.println("Liste des questions");
			listerQuestion(questionList);
			afficherMenu();
		break;	
		case (2) : 
			System.out.println("Ajout d'une nouvelle question");
			try {
				ajouterQuestion(questionList);
			} catch (StockageExceptionMere e) {
				System.out.println(e.getMessage());
			}
			afficherMenu();
		break;
		case (3) :
			System.out.println("Suppression d'une question");
			supprimerQuestion(questionList);
			afficherMenu();
		break;
		case (4) :
			System.out.println("Exécution du quizz");
			démarrerQuizz(questionList);
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

