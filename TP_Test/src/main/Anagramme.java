package main;

import java.util.Scanner;

public class Anagramme {
	private Scanner scanner;
	
	public Anagramme(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public char[] recupererEntree() {
		System.out.println("Entrez un mot :");
		String entree = scanner.next();
		scanner.close();
		return entree.toCharArray();
	}
	
	public char[] constructionAnagramme(char[] anagramme) {
		int taille_anagramme = anagramme.length;
		char car;
		for (int i = 0; i <= taille_anagramme - 1; i++) {
			car = anagramme[i];
			int j = i;
			while ((j>0) && (car<anagramme[j-1])) {
				anagramme[j] = anagramme[j-1];
				j--;
			}
			anagramme[j] = car;
		}
		return anagramme;
	}
}
