package com.pizzeria.console;

import java.util.Scanner;

/**
 * @author Mélanie Diligent Lancement application
 */

public class App {
	public static void main(String[] args) {

		// Déclaration et initialisation des variables
		int option = 0;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		Scanner sc5 = new Scanner(System.in);
		Scanner sc6 = new Scanner(System.in);
		Scanner sc7 = new Scanner(System.in);
		Scanner sc8 = new Scanner(System.in);
		Boolean continuer = true;
		Pizza[] pizzas = new Pizza[8];
		String code, nouveauCode;
		String nom, nouveauNom;
		String pizzaModif, pizzaSupprim;
		double prix, nouveauPrix;

		pizzas[0] = new Pizza("PEP", "Pépéroni", 12.50);
		pizzas[1] = new Pizza("MAR", "Margherita", 14.00);
		pizzas[2] = new Pizza("REIN", "La Reine", 11.50);
		pizzas[3] = new Pizza("FRO", "La 4 Fromages", 12.00);
		pizzas[4] = new Pizza("CAN", "Cannibale", 12.50);
		pizzas[5] = new Pizza("SAV", "Savoyarde", 13.00);
		pizzas[6] = new Pizza("ORI", "L'orientale", 13.50);
		pizzas[7] = new Pizza("IND", "L'indienne", 14.00);

		// Tant que continuer est à vrai, on affiche le menu
		while (continuer) {

			System.out.println("***** Pizzeria Administration *****\n" + "1.\tLister des pizzas\n"
					+ "2.\tAjouter une nouvelle pizza\n" + "3.\tMettre à jour une pizza\n" + "4.\tSupprimer une pizza\n"
					+ "99.\tSortir");

			// Affichage et sauvegarde de l'option donnée par l'utilisateur
			System.out.println("\nVeuillez faire un choix");
			option = sc.nextInt();

			// Choix utilisateur 1
			if (option == 1) {
				System.out.println("Liste des pizzas");

				// Liste des pizzas
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}
			}

			// Choix utilisateur 2
			if (option == 2) {
				System.out.println("Ajout d'une nouvelle pizza");

				// Ajout d'une pizza avec code, désignation et prix
				System.out.println("Veuillez saisir le code");
				code = sc1.nextLine();

				System.out.println("Veuillez saisir le nom (sans espace)");
				nom = sc2.nextLine();

				System.out.println("Veuillez saisir le prix");
				prix = sc3.nextDouble();

				// Création d'une nouvelle pizza avec les informations saisies par l'utilisateur
				Pizza pizza = new Pizza(code, nom, prix);

				// Création d'un tableau temp avec un taille incrémenté de 1 du tableau pizza
				Pizza[] pizzasTemp = new Pizza[pizzas.length + 1];

				// Boucle pour tranférer les données au tableau temporaire pizzasTemp
				for (int i = 0; i < pizzasTemp.length - 1; i++) {
					pizzasTemp[i] = pizzas[i];
				}

				// Redimension du tableau pizzas à la taille du tableau pizzasTemp
				pizzas = new Pizza[pizzasTemp.length];

				// Réaffectation des valeurs de pizzasTemp à pizzas
				for (int i = 0; i < pizzas.length; i++) {
					pizzas[i] = pizzasTemp[i];
				}

				pizzas[pizzas.length - 1] = pizza;
			}

			// Choix utilisateur 3
			if (option == 3) {
				System.out.println("Mise à jour d'une pizza");

				// Affichage de la liste de pizzas
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}

				System.out.println("Veuillez choisir le code de la pizza à modifier");
				pizzaModif = sc4.nextLine();

				for (Pizza pizza : pizzas) {

					// Vérification si le code de la pizza est égal au code donné par l'utilisateur
					if (pizzaModif.equals(pizza.getCode())) {

						// Saisies des modifications données par l'utilisateur
						System.out.println("Veuillez saisir le code");
						nouveauCode = sc5.nextLine();
						pizza.setCode(nouveauCode);

						System.out.println("Veuillez saisir le nom (sans espace)");
						nouveauNom = sc6.nextLine();
						pizza.setDesignation(nouveauNom);

						System.out.println("Veuillez saisir le prix");
						nouveauPrix = sc7.nextDouble();
						pizza.setPrix(nouveauPrix);
					}
				}
			}

			// Choix utilisateur 4
			if (option == 4) {
				System.out.println("Suppression d'une pizza");

				// Liste des pizzas
				for (Pizza pizza : pizzas) {
					System.out.println(pizza.toString());
				}

				System.out.println("Veuillez choisir le code de la pizza à supprimer");
				pizzaSupprim = sc8.nextLine();

				// Création d'un tableau temporaire pizzaTemp2 à la taille de pizzas décrémentée
				// de 1
				Pizza[] pizzaTemp2 = new Pizza[pizzas.length - 1];

				// Compteur de l'index pizzaTemp2
				int j = 0;

				// Pour chaque pizza du tableau pizzas
				for (Pizza pizza : pizzas) {

					// On vérifie si le code est égal à celui donné à l'utilisateur
					if (pizzaSupprim.equals(pizza.getCode())) {

						// On affecte une valeur valeur nulle à l'objet pizza
						pizza = null;

						// Utilisation du garbage collector pour supprimer l'objet
						System.gc();
					}

					// Sinon la valeur de pizzaTemp2 à l'index j prend la valeur de pizza
					else if (!pizzaSupprim.equals(pizza.getCode())) {
						pizzaTemp2[j] = pizza;
						j++;
					}
				}

				// Redimension du tableau pizza à la taille de pizzaTemp2
				pizzas = new Pizza[pizzaTemp2.length];

				// Pour chaque index i, on affecte la valeur de pizzaTemp2 à pizzas
				for (int i = 0; i < pizzas.length; i++) {

					pizzas[i] = pizzaTemp2[i];
				}
			}

			// Choix utilisateur 5
			if (option == 99) {
				System.out.println("Au revoir");

				// Fermeture des scanners
				sc.close();
				sc1.close();
				sc2.close();
				sc3.close();
				sc4.close();
				sc5.close();
				sc6.close();
				sc7.close();
				sc8.close();

				// Pour sortir de la boucle, continuer passe à faux
				continuer = false;
			}
		}
	}
}