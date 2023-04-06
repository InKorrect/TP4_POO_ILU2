package Produit;

public enum unite {
	LITRE("L"),
	GRAMME("g"),
	KILOGRAMME("kg"),
	CENTILITRE("cL"),
	MILLILITRE("mL"),
	PIECE("piece");

	
	private final String nomU;

	private unite(String nomU) {
		this.nomU=nomU;
	}

	
}
