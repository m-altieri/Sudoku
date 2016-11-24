package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public static final int ASCII_ZERO = 48;

	public static boolean[] verify(String candidateSolution) throws Exception {

		// Prerequisiti: la stringa di input deve avere lunghezza 81
		if (candidateSolution.length() != 81)
			throw new Exception();

		/*
		 * error[0] = true se viola la regola 1, false altrimenti error[1] =
		 * true se viola la regola 2, false altrimenti error[2] = true se viola
		 * la regola 3, false altrimenti error[3] = true se viola la regola 4,
		 * false altrimenti
		 */
		boolean[] error = { false, false, false, false };

		// CONTROLLO REGOLA 1
		for (int i = 0; i < candidateSolution.length(); i++)
			if (candidateSolution.charAt(i) - ASCII_ZERO < 1 || candidateSolution.charAt(i) - ASCII_ZERO > 9)
				error[0] = true;

		// CONTROLLO REGOLA 2
		String subgrid = "";

		for (int j = 0; j < 9; j++) {

			for (int i = candidateSolution.length() / 3 * j; i < candidateSolution.length() / 3 * (j + 1); i++)
				if (i % 9 >= j * 3 && i % 9 <= j * 3 + 2)
					subgrid += candidateSolution.charAt(i);

			if (repeated(subgrid))
				error[1] = true;
			
			subgrid = "";

		}
		
		// CONTROLLO REGOLA 3
		subgrid = "";
		
		for (int i = 0; i < 81; i += 9) {
			subgrid += candidateSolution.substring(i, i + 9);
			if (repeated(subgrid))
				error[2] = true;
		}
		
		// CONTROLLO REGOLA 4
		subgrid = "";
		
		for (int i = 0; i < 9; i++) {
			
			for (int j = 0; j < 9; j++)
				subgrid += candidateSolution.charAt(i + j*9);
			
			if (repeated(subgrid))
				error[3] = true;
			
			subgrid = "";
		}
		

		return error;
	}

	/**
	 * @param true
	 *            se si ripetono
	 * @return
	 */
	private static boolean repeated(String x) {
		boolean repeated = false;

		for (int i = 0; i < x.length() - 1; i++) {
			for (int j = i + 1; j < x.length(); j++) {
				if (x.charAt(i) == x.charAt(j))
					repeated = true;
			}
		}

		return repeated;
	}
}
