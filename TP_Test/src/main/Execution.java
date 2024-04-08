package main;



import java.util.Scanner;

import test.JeuTest;

public class Execution {
	public static void main(String[] args) {

		Anagramme anagramme = new Anagramme(new Scanner(System.in));
		// Entrée utilisateur
		System.out.println("\nEntrée utilisateur : ");
		char[] mot = anagramme.recupererEntree();
		System.out.println(anagramme.constructionAnagramme(mot));
	}
}
