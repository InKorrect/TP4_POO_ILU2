package scenarioTest;

import personnages.Gaulois;
import Produit.Poisson;
import Produit.Produit;
import Produit.Sanglier;
import Produit.unite;
import villagegaulois.Etal;
import villagegaulois.IEtal;
public class ScenarioTest {
	public static void main(String[] args) {
		Etal[] marche = new Etal[3];
		//Etal<Sanglier> etalSanglier1 = new Etal<>();
//		Etal<Sanglier> etalSanglier2 = new Etal<>();
		//Etal<Poisson>  etalPoisson1 = new Etal<>();
//		marche[0] = etalSanglier1;
//		marche[0] = etalPoisson1;
		//IEtal[] marche = new IEtal[3];
		//marche[0] = etalSanglier1;
		
		//marche[0] = etalSanglier1;
//		marche[1] = etalSanglier2;
		//marche[2] = etalPoisson1;
		//marche[0].occuperEtal(new Gaulois("Ordralfabétix",12), new Poisson("lundi",Unite.KILOGRAMME), 10);
		//IEtal<Poisson> etalPoisson = new Etal<>();
		//marche[0] = etalSanglier;
		//marche[1] = etalPoisson;
		
		Gaulois ordralfabetix = new Gaulois("Ordralfabétix",9);
		Gaulois obelix = new Gaulois("Obélix",20);
		Gaulois asterix = new Gaulois("Asterix", 6);
		
		Sanglier sanglier1 = new Sanglier(2000, obelix);
		Sanglier sanglier2 = new Sanglier(1500, obelix);
		Sanglier sanglier3 = new Sanglier(1000, asterix);
		Sanglier sanglier4 = new Sanglier(500, asterix);
		
		Sanglier[] sangliersObelix = {sanglier1, sanglier2};
		Sanglier[] sangliersAsterix = {sanglier3, sanglier4};

		Poisson poisson1 = new Poisson("lundi");
		Poisson[] poissons = {poisson1};

		marche[0] = new Etal();
		marche[0].setNbProduit(sangliersObelix.length);
		marche[1] = new Etal();
		marche[1].setNbProduit(sangliersAsterix.length);
		marche[2] = new Etal();
		marche[2].setNbProduit(poissons.length);
		marche[0].installerVendeur(obelix, sangliersObelix, 8);
		marche[1].installerVendeur(asterix, sangliersAsterix, 10);
		marche[2].installerVendeur(ordralfabetix, poissons, 7); 
		
		System.out.println("ETAT MARCHE");
		System.out.println(marche[0].etatEtal());
		System.out.println(marche[1].etatEtal());
		System.out.println(marche[2].etatEtal());
	}
}