package main;



import java.util.Scanner;

import test.JeuTest;

public class Execution {
	public static void main(String[] args) {
		// Tests
		JeuTest test = new JeuTest();
		test.testAnagaramme();
		test.testMutants();
		
		Anagramme anagramme = new Anagramme(new Scanner(System.in));
		// Test entrée utilisateur
		System.out.println("\nEntrée utilisateur : ");
		char[] mot = anagramme.recupererEntree();
		System.out.println(anagramme.constructionAnagramme(mot));
		
		// Test coverage
//		mot = "mouton".toCharArray();
//		System.out.println("mouton -> " + String.copyValueOf(anagramme.constructionAnagramme(mot)));
		
	}
}
