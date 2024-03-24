package test;

public class Mutants {
	private int numMutant;
	
	public Mutants(int numMutant) {
		this.numMutant = numMutant;
	}
	
	public char[] anagrammeMutants(char[] anagramme) {
		switch (numMutant) {
		case 1: {
			anagramme = mutant1(anagramme);
			break;
		}
		case 2: {
			anagramme = mutant2(anagramme);
			break;
		}
		case 3: {
			anagramme = mutant3(anagramme);
			break;
		}
		default: {
			anagramme = mutant4(anagramme);
			break;
		}
		}
		return anagramme;
	}
	
	public char[] mutant1(char[] anagramme) {
		int taille_anagramme = anagramme.length;
		char car;
		//changement <= en <
		for (int i = 0; i < taille_anagramme - 1; i++) {
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
	
	public char[] mutant2(char[] anagramme) {
		int taille_anagramme = anagramme.length;
		char car;
		// changemennt - en +
		for (int i = 0; i <= taille_anagramme + 1; i++) {
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
	
	public char[] mutant3(char[] anagramme) {
		int taille_anagramme = anagramme.length;
		char car;
		for (int i = 0; i <= taille_anagramme - 1; i++) {
			car = anagramme[i];
			int j = i;
			// changement && en ||
			while ((j>0) || (car<anagramme[j-1])) {
				anagramme[j] = anagramme[j-1];
				j--;
			}
			anagramme[j] = car;
		}
		return anagramme;
	}
	
	public char[] mutant4(char[] anagramme) {
		int taille_anagramme = anagramme.length;
		char car;
		for (int i = 0; i <= taille_anagramme - 1; i++) {
			car = anagramme[i];
			int j = i;
			// changement < en <=
			while ((j>0) && (car<=anagramme[j-1])) {
				anagramme[j] = anagramme[j-1];
				j--;
			}
			anagramme[j] = car;
		}
		return anagramme;
	}
}