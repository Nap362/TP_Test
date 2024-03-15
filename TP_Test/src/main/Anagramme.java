package main;

public class Anagramme {
	public Anagramme() {}
	
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
