package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import main.Anagramme;

public class JeuTest {
	private String[] cas;
	private String[] oracles;
	private int nombreCas;
	
	public JeuTest() {
		lectureFichier();
	}
	
	public void lectureFichier() {
		try {
			FileReader fileReader = new FileReader("C:\\Users\\Ninon\\Desktop\\TP\\workspace\\TP_Test\\src\\test\\valeurs_test.txt");
			BufferedReader reader = new BufferedReader(fileReader);
			String line = reader.readLine();	
			cas = line.split(";");
			line = reader.readLine();
			oracles = line.split(";");
			nombreCas = cas.length;
			reader.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void testAnagaramme() {
		Anagramme anagramme = new Anagramme();
		for (int i = 0; i<nombreCas;i++) {
			char[] c1 = cas[i].toCharArray();
			char[] oracle1 = oracles[i].toCharArray();
			char[] res1 = anagramme.constructionAnagramme(c1);
			if (Arrays.equals(oracle1, res1)) {
				System.out.println("test" + (i+1) + " pass");
			}else {
				System.out.println("test" + (i+1) + " fail");
			}
		}
	}
	
	public void testMutants() {
		Mutants mutants = new Mutants();
		for (int j = 1; j<=7;j++) {
			boolean survived = true;
			for (int i = 0; i<nombreCas && survived;i++) {
				char[] c1 = cas[i].toCharArray();
				char[] oracle1 = oracles[i].toCharArray();
				try {
					char[] res1 = mutants.anagrammeMutants(c1, j);
					survived = Arrays.equals(oracle1, res1);
				} catch (Exception e) {
					survived = false;
				}
			}
			if(survived) {
				System.out.println("Mutant" + j + " survived");
			}else {
				System.out.println("Mutant" + j + " killed");
			}
		}
	}
	
	
}
