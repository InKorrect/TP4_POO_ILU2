package scenarioTest;

import personnages.Gaulois;
import Produit.IProduit;
import Produit.Poisson;
import Produit.Produit;
import Produit.Sanglier;
import villagegauloisold.DepenseMarchand;
import villagegaulois.Etal;
import villagegaulois.IEtal;
import IVillage.IVillage;

public class Scenario {

	public static void main(String[] args) {


		// fin
		IVillage village = new IVillage(){
			private int nbEtalActu = 0;
			private int nbEtalMax = 3;
			private IEtal[] marche = new IEtal[nbEtalMax];

			@Override
			public <P extends Produit> boolean installerVendeur(Etal<P> etal,
			Gaulois vendeur, P[] produit, int prix) {
				if (nbEtalActu < 3) {
					etal.installerVendeur(vendeur, produit, prix);
					marche[nbEtalActu++] = etal;
					return true;
				} else {
					return false;
				}
			}

			@Override
			public DepenseMarchand[] acheterProduit(String produit, int quantiteSouhaitee){
				DepenseMarchand[] depenses = new DepenseMarchand[nbEtalMax];
				int i = 0;
				int nbAvendre = 0;
				for (IEtal e : marche) {
					//System.out.println("quantité :" + quantiteSouhaitee);
					if (quantiteSouhaitee == 0)
						break;
					nbAvendre = e.contientProduit(produit, quantiteSouhaitee);
					if (nbAvendre > 0) {
						double prixPaye = e.acheterProduit(nbAvendre);
						depenses[i++] = new DepenseMarchand(e.getVendeur(),nbAvendre , produit, prixPaye);
						quantiteSouhaitee -= nbAvendre;
					}
				}
				return depenses;
			}
			
			@Override
			public String toString() {
				String stringVillage = ""; 
				for (IEtal e : marche) {
					stringVillage += e.etatEtal();
					stringVillage += "\n";
				}
				return stringVillage;
			}
			
		};

		Gaulois ordralfabetix = new Gaulois("Ordralfabétix", 9);
		Gaulois obelix = new Gaulois("Obélix", 20);
		Gaulois asterix = new Gaulois("Astérix", 6);

		Etal<Sanglier> etalSanglierObelix = new Etal<>();
		Etal<Sanglier> etalSanglierAsterix = new Etal<>();
		Etal<Poisson> etalPoisson = new Etal<>();

		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);

		Sanglier[] sangliersObelix = { sanglier1, sanglier2 };
		Sanglier[] sangliersAsterix = { sanglier3, sanglier4 };

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = { poisson1 };

		village.installerVendeur(etalSanglierAsterix, asterix, sangliersAsterix, 8);
		village.installerVendeur(etalSanglierObelix, obelix, sangliersObelix, 10);
		village.installerVendeur(etalPoisson, ordralfabetix, poissons, 5);

		System.out.println(village);

		DepenseMarchand[] depense = village.acheterProduit("sanglier", 3);

		for (int i = 0; i < depense.length && depense[i] != null; i++) {
			System.out.println(depense[i]);
		}

		System.out.println(village);

	}

}