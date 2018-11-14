package fr.diginamic.model;

import java.util.ArrayList;

public class Question {
	private String intitule;
	private ArrayList<String> propositions;
	private String bonneReponse;
	
	public Question(String intitule, int nb) {
		super();
		this.intitule = intitule;
		this.propositions = new ArrayList<>(nb);
	}
	
	public boolean verifierReponse(String verif) {
		return verif.equals(bonneReponse);
	}
	
	public void addProposition(String proposition) {
	propositions.add(proposition);
	}
}
