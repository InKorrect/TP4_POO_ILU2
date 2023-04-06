package IVillage;

import personnages.Gaulois;
import Produit.IProduit;
import Produit.Produit;
import Produit.Sanglier;
import villagegaulois.Etal;
import villagegauloisold.DepenseMarchand;
import villagegaulois.IEtal;

public interface IVillage {
	public <P extends Produit> boolean installerVendeur(Etal<P> etal,
			Gaulois vendeur, P[] produit, int prix);

	public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee);
}