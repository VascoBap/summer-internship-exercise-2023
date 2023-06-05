package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

	public static Boolean verify(int[][]snail) {
		int[][] i = {{}};
		if(snail == null) { 
			System.out.println("The matrix is null");
			return false;
		}
		if(snail == i) { 
			System.out.println("The matrix is empty");
			return false;
		}
		if(snail.length != snail[0].length) {
			System.out.println("The matrix's height and width are different");
			return false;
			}
		for (int j = 1; j < snail.length; j++) {
	        if (snail[j].length != snail[j-1].length) {
	        	System.out.println("The matrix's width has to be always the same length!");
	            return false;
	        }
	    }
		
		
		return true;
	}
  public SnailShellPatternTest() {
	  
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    boolean isValidMatrix = verify(matrix);
    assertTrue("Invalid matrix", isValidMatrix);
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }
}
