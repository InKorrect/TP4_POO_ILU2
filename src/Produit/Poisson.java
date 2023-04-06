package Produit;

public class Poisson extends Produit {
	private String datePeche;
	
	
	public Poisson(String nom, unite unit, String datePeche) {
		super(nom, unit);
		this.datePeche = datePeche;
	}

	public Poisson(String date) {
		super("Poisson",unite.GRAMME);
		this.datePeche = date;
	}
	
	@Override
	public String decrireProduit() {
		return (getNom()+" pêché "+ datePeche);
	}


}
