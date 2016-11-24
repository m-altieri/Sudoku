package org.univoulu.tol.sqatlab.sudoku;

import org.junit.Assert;
import org.junit.Assert;
import org.junit.Test;

public class TestSudokuVerifier {

	@Test
	public void positiveDigitsFrom1To9Only() throws Exception {

		Assert.assertEquals(true, SudokuVerifier
				.verify("011111111111111111111111111111111111111111111111111111111111111111111111111111111")[0]);
		
		Assert.assertEquals(true, SudokuVerifier
				.verify("3581059fs3581059fs3581059fs3581059fs3581059fs3581059fs3581059fs3581059fs3581059fs")[0]);
	}

	@Test
	public void noRepeatedDigitsInEverySubgrid() throws Exception {

		Assert.assertEquals(true, SudokuVerifier
				.verify("111234567111345678111567893738591473738591473738591473738591473738591473753859147")[1]);
		
		Assert.assertEquals(true, SudokuVerifier
				.verify("111234567111345678111567893738591473738591473738591473738591473738591473753859147")[1]);
		
		Assert.assertEquals(false, SudokuVerifier
				.verify("417369825632158947958724316825437169791586432346912758289643571573291684164875293")[1]);
	}
	
	@Test
	public void noRepeatedDigitsInEveryRow() throws Exception {
		
		Assert.assertEquals(true, SudokuVerifier
				.verify("123456789123456789123456789123456789123456789123456789123456789123456789123456788")[2]);
		
	}
	
	@Test
	public void noRepeatedDigitsInEveryColumn() throws Exception {
		
		Assert.assertEquals(true,  SudokuVerifier
				.verify("417369825632158947958724316825437169791586432346912758289643571573291683164875293")[3]);
	}

}
