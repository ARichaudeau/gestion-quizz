package fr.diginamic.model;

public class Question {
	private String intitule;
	private String[] propositions;
	private String bonneReponse;
	
	public Question(String intitule, int nb) {
		super();
		this.intitule = intitule;
		this.propositions = new String[nb];
	}
	
	public boolean verifierReponse(String verif) {
		return verif.equals(bonneReponse);
	}
}
