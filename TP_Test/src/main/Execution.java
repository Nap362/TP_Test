package main;

import java.util.Scanner;

import test.JeuTest;

public class Execution {
	public static void main(String[] args) {
		// Entrée utilisateur
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Entrez un mot :");
//		String entree = scanner.next();
//		scanner.close();
//		char[] mot = entree.toCharArray();
//		System.out.println(anagrame.constructionAnagramme(mot));
		
		// Tests
		JeuTest test = new JeuTest();
		test.testAnagaramme();
		test.testMutants();
//		Anagramme anagramme = new Anagramme();
//		char[] mot = "mouton".toCharArray();
//		System.out.println(anagramme.constructionAnagramme(mot));
//		
		
	}
}
