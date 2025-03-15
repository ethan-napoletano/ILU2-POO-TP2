package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolé " + nomVendeur + ", mais il faut être un habitant du village pour commercer ici.");
			return;
		}
		if (!controlPrendreEtal.resteEtals()) {
			System.out.println("Désolé " + nomVendeur + ", je n'ai plus d'étal qui ne soit pas déjà occupé.");
			return;
		}
		System.out.println(" Bonjour Bonemine, je vais regarder\r\n"
				+ " si je peux vous trouver un étal.");
		installerVendeur(nomVendeur);	
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !");
		
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int quantite = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");

		
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, quantite);

		if (numeroEtal != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est installé à l'étal n°" + numeroEtal + ".");
		} else {
			System.out.println("Erreur lors de l'installation du vendeur.");
		}
	}
}
