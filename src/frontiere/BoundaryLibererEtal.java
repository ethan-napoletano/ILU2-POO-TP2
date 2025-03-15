package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!controlLibererEtal.isVendeur(nomVendeur)) {
			System.out.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		} else {
			
			String[] donneesEtal = controlLibererEtal.libererEtal(nomVendeur);
			
			
			if (donneesEtal[0].equals("true")) {
				String produit = donneesEtal[2];
				String quantiteInitiale = donneesEtal[3];
				String quantiteVendue = donneesEtal[4];

				System.out.println("Vous avez vendu " + quantiteVendue + " sur " + quantiteInitiale + " " + produit + ".");
				System.out.println("Au revoir " + nomVendeur + ", passez une bonne journée !");
			}
		}
	}

}
