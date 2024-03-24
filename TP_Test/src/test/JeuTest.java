package test;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

import main.Anagramme;

public class JeuTest {
	private ArrayList<String> cas;
	private ArrayList<String> oracles;
	
	public JeuTest() {
		cas = new ArrayList<>();
		oracles = new ArrayList<>();
		lectureFichier();
	}
	
	public void lectureFichier() {
		Path currentDirectoryPath = FileSystems.getDefault().getPath("");
		String currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString();
		try {
			FileReader fileReader = new FileReader(currentDirectoryName + "/src/valeurs_test.txt");
			Scanner scanner = new Scanner(fileReader);
			String line = scanner.nextLine();
			String[] lineSplit;
			while (line!=null) {
				lineSplit = line.split(";");
				cas.add(lineSplit[0]);
				oracles.add(lineSplit[1]);
				try {
					line = scanner.nextLine();
				} catch (NoSuchElementException e) {
					line = null;
				} 
			}
			scanner.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testAnagaramme() {
		System.out.println("Tests fonctionnels :");
		Anagramme anagramme = new Anagramme(new Scanner(System.in));
		for (int i = 0; i<cas.size();i++) {
			char[] c = cas.get(i).toCharArray();
			char[] oracle = oracles.get(i).toCharArray();
			char[] res = anagramme.constructionAnagramme(c);
			if (Arrays.equals(oracle, res)) {
				System.out.println("Test " + (i+1) + " passed -> \"" + cas.get(i) + "\" : \"" + String.copyValueOf(oracle) + "\"");
			}else {
				System.out.println("Test " + (i+1) + " failed -> \"" + cas.get(i) + "\" expected \"" + String.copyValueOf(oracle) + "\" but was \"" + String.copyValueOf(res) + "\"");
			}
		}
	}
	
	public void testMutants() {
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
	
	
}
