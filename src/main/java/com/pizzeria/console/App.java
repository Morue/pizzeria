package com.pizzeria.console;

import java.util.Scanner;

/**
 * @author Mélanie Diligent
 * Lancement application
 */

public class App {
	public static void main(String[] args) {
		
		int option = 0;
		Scanner sc = new Scanner(System.in);
		Boolean continuer = true;
	
		//Tant que continuer est à vrai, le menu est affiché
		while (continuer) {
			
			System.out.println("***** Pizzeria Administration *****\n1.\t"
					+ "Lister des pizzas\n2.\t"
					+ "Ajouter une nouvelle pizza\n"
					+ "3.\tMettre à jour une pizza\n4.\t"
					+ "Supprimer une pizza\n"
					+ "99.\tSortir");
			
			//Demande de choix
			System.out.println("\nVeuillez faire un choix");
			option = sc.nextInt();
			
			//Différentes options
			if (option == 1) {
				
				System.out.println("Liste des pizzas");
				Pizza pizza = new Pizza("MAR","MARGARITA", 9.20);
				System.out.println(pizza.toString());
			}
			
			if (option == 2) {
				System.out.println("Ajout d'une nouvelle pizza");		
			}
			
			if (option == 3) {	
				System.out.println("Mise à jour d'une pizza");				
			}
			
			if (option == 4) {
				System.out.println("Suppression d'une pizza");			
			}
			
			if (option == 99) {
				System.out.println("Au revoir");
				sc.close();
				
				//Sortie de la boucle si c'est faux
				continuer = false ;			
			}
			
		}
	}
}
