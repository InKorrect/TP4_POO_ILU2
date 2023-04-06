package Produit;

public abstract class Produit implements IProduit {
	private String nom;
	private unite unite;
	
	protected Produit(String nom, unite unite) {
		this.nom = nom;
		this.unite = unite;
	}

	@Override
	public String getNom() { return this.nom; }
	unite getUnite() {return this.unite;}
	
	@Override
	public abstract String decrireProduit();
	
	void setNom(String nom) {
		this.nom = nom;
	}

	public double calculerPrix(int prix) {
		return (double)prix;
	}
	
	
}