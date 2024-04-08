package test;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import main.Anagramme;

public class JeuTest {
	private static ArrayList<String> cas;
	private static ArrayList<String> oracles;

	public static void lectureFichier(String nom_jeu_test) {
		cas = new ArrayList<>();
		oracles = new ArrayList<>();
		
		String line = null;
		BufferedReader br = null;
		try {
			FileReader fileReader = new FileReader( "TP_Test/src/test/" + nom_jeu_test);
			br = new BufferedReader(fileReader);
			while ((line = br.readLine()) != null) {
	 			try {
					String[] lineSplit = line.split(";");
					if(lineSplit.length == 2 ) {
						cas.add(lineSplit[0]);
						oracles.add(lineSplit[1]);
					}
					else {
						cas.add(line);
						oracles.add("");
					}
				} catch (NoSuchElementException e) {
					line = null;
				} 
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void testAnagaramme() {
		lectureFichier("valeurs_test.txt");
		System.out.println("Tests :");
		Anagramme anagramme = new Anagramme(new Scanner(System.in));
		for (int i = 0; i<cas.size();i++) {
			char[] c = cas.get(i).toCharArray();
			char[] oracle = oracles.get(i).toCharArray();
			char[] res = anagramme.constructionAnagramme(c);
			if (Arrays.equals(oracle, res)) {
				System.out.println("Test " + (i+1) + " passed -> \"" + cas.get(i) 
				+ "\" : \"" + String.copyValueOf(oracle) + "\"");
			}else {
				System.out.println("Test " + (i+1) + " failed -> \"" + cas.get(i) +
						"\" expected \"" + String.copyValueOf(oracle) + "\" but was \"" + String.copyValueOf(res) + "\"");
			}
		}
	}
	
	public static void testFonctionnels() {
		lectureFichier("tests_fonctionnels.txt");
		System.out.println("\nTests Fonctionnels:");
		Anagramme anagramme = new Anagramme(new Scanner(System.in));
		for (int i = 0; i<cas.size();i++) {
			char[] c = cas.get(i).toCharArray();
			char[] res = anagramme.constructionAnagramme(c);
			try {
				System.out.println("Test " + (i+1) + " : \"" + cas.get(i) + "\" -> \"" + String.copyValueOf(res) + "\"");
			}
			catch(Exception e) {
				System.out.println("Test " + (i+1) + " : \"" + cas.get(i) + "\" -> failed : error ");
			}
		}
	}
	
	public static void testMutants() {
		lectureFichier("valeurs_test.txt");
		System.out.println("\nTests de mutation :");
		Mutants mutants;
		for (int j = 1; j<=4;j++) {
			mutants = new Mutants(j);
			boolean survived = true;
			for (int i = 0; i<cas.size() && survived;i++) {
				char[] c = cas.get(i).toCharArray();
				char[] oracle = oracles.get(i).toCharArray();
				try {
					char[] res = mutants.anagrammeMutants(c);
					survived = Arrays.equals(oracle, res);
					if (!survived) {
						System.out.println("\tTest " + (i+1) + " failed -> Wrong result");
					}
				} catch (Exception e) {
					survived = false;
					System.out.println("\tTest " + (i+1) + " failed -> Error");
				}
			}
			if(survived) {
				System.out.println("\tAll tests passed\nMutant " + j + " survived");
			}else {
				System.out.println("Mutant " + j + " killed");
			}
		}
	}
	
	public static void main(String[] args) {
		// Test coverage
		//char[] mot = "mouton".toCharArray();
		//System.out.println("mouton -> " + String.copyValueOf(new Anagramme(null).constructionAnagramme(mot)));
		
		// Tests
		testAnagaramme();
		testFonctionnels();
		testMutants();		
	}
	
	
}
