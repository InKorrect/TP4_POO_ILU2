package Produit;

import personnages.Gaulois;

public class Sanglier extends Produit{
	private int poids;
	private Gaulois chasseur;

	public Sanglier(String nom, unite unite , Gaulois chasseur) {
		super(nom, unite);
		this.chasseur = chasseur;
	}
	public Sanglier(int poids , Gaulois chasseur) {
		super("Sanglier",unite.KILOGRAMME);
		this.poids = poids;
		this.chasseur = chasseur;
	}

	@Override
	public String decrireProduit() {
		return getNom() + " de " + poids + " " + getUnite().toString()
				+ " chassé par " + chasseur.getNom();
	}
	
	@Override
	public double calculerPrix(int prix) { // on part du principe que
		// les prix sont exprimés au kilo
		if (getUnite().toString().equals("pièce")) {
			return (double)prix;
		} else if (getUnite().toString().equals("gramme")) {
			return (double)(poids*prix)/1000000;
		} else if (getUnite().toString().equals("kilogramme")) {
			return (double)(poids*prix)/1000;
		} else {
			return (double)(poids*prix)/1000;
		}
	}
}