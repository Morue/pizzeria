package com.pizzeria.console;

import java.util.Collections;
import java.util.Scanner;
import com.pizzeria.model.CategoriePizzaEnum;

public class Pizzeria {
	public static void main(String[] args) {

		boolean continuer = true;
		int option = 0;
		String codePizza = "";
		String nom = "";
		Double prix = 0.0;
		String pizzaModif = "";
		String nouveauCode = "";
		String nouveauNom = "";
		String pizzaASupprimer = "";
		String categorie;
		String nouvelleCategorie;
		Double nouveauPrix = 0.0;
		Scanner sc = new Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		Scanner sc3 = new Scanner(System.in);
		Scanner sc4 = new Scanner(System.in);
		Scanner sc5 = new Scanner(System.in);
		Scanner sc6 = new Scanner(System.in);
		Scanner sc7 = new Scanner(System.in);
		Scanner sc8 = new Scanner(System.in);
		Scanner sc9 = new Scanner(System.in);
		Scanner sc10 = new Scanner(System.in);

		PizzaMemDao piz = new PizzaMemDao();

		while (continuer) {

			try {
				System.out.println("***** Pizzeria Administration *****\n" + "1.\tListe des pizzas\n"
						+ "2.\tAjouter une pizza\n" + "3.\tMettre à jour une pizza\n" + "4.\tSupprimer une pizza ?\n"
						+ "5.\tTrier par prix croissant\n" + "6.\tTrier par code décroissant\n" + "99.\tSortir");

				// Affiche et sauvegarde de l'option donnée par l'utilisateur
				System.out.println("\nVeuillez faire un choix");
				option = sc.nextInt();

				if (option == 1) {
					System.out.println(piz.findAllPizzas());
				}

				if (option == 2) {
					System.out.println("Ajouter une pizza");

					System.out.println("\nVeuillez entrer le code");
					codePizza = sc5.nextLine();

					System.out.println("Veuillez saisir le nom (sans espace)");
					nom = sc7.nextLine();

					System.out.println("Veuillez saisir le prix");
					prix = sc8.nextDouble();

					System.out.println("Veuillez saisir la catégorie(Viande/Fromage/Poisson/Autre)");
					categorie = sc9.nextLine();

					categorie = categorie.toUpperCase();

					try {
						CategoriePizzaEnum categorieEnum = CategoriePizzaEnum.valueOf(categorie);
						Pizza pizza = new Pizza(codePizza, nom, prix, categorieEnum);

						piz.saveNewPizza(pizza);
					}

					catch (Exception e) {
						System.out.println("Erreur dans la saisie de la catégorie");
					}
				}

				if (option == 3) {

					System.out.println("Veuillez choisir le code de la pizza à modifier");
					pizzaModif = sc1.nextLine();

					System.out.println("Veuillez saisir le code");
					nouveauCode = sc2.nextLine();

					System.out.println("Veuillez saisir le nom (sans espace)");
					nouveauNom = sc3.nextLine();

					System.out.println("Veuillez saisir le prix");
					nouveauPrix = sc4.nextDouble();

					System.out.println("Veuillez saisir la catégorie(Viande/Fromage/Poisson/Autre)");
					nouvelleCategorie = sc10.nextLine();

					nouvelleCategorie = nouvelleCategorie.toUpperCase();

					try {
						CategoriePizzaEnum categorieEnum = CategoriePizzaEnum.valueOf(nouvelleCategorie);
						Pizza newPizza = new Pizza(nouveauCode, nouveauNom, nouveauPrix, categorieEnum);

						piz.updatePizza(pizzaModif, newPizza);
					}

					catch (Exception e) {
						System.out.println("Erreur dans la saisie de la catégorie");
					}
				}

				if (option == 4) {

					System.out.println("Veuillez choisir le code de la pizza à supprimer");
					pizzaASupprimer = sc6.nextLine();

					piz.deletePizza(pizzaASupprimer);
				}

				if (option == 5) {

					Collections.sort(piz.findAllPizzas(), new ComparatorPrix());
					System.out.println(piz.findAllPizzas());
				}

				if (option == 6) {

					Collections.sort(piz.findAllPizzas(), new ComparatorCode());
					System.out.println(piz.findAllPizzas());
				}

				if (option == 99) {

					System.out.println("Au revoir");

					// fermeture des scanners
					sc.close();
					sc1.close();
					sc2.close();
					sc3.close();
					sc4.close();
					sc5.close();
					sc6.close();
					sc7.close();
					sc8.close();
					sc9.close();
					sc10.close();

					// Sortie de la boucle
					continuer = false;
				}
			}

			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}