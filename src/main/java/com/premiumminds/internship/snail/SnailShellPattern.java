package com.premiumminds.internship.snail;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] snail) {
	  int row = 0;
		int col = 0;
		int l = snail.length;
		int ini = 0;
		int pointer = 0;
		int[] result = new int [snail.length*snail.length];
		Future<int[]> futureResult = CompletableFuture.completedFuture(result);
		boolean reverse = false;
		
		while(true) {
			
			if(col < l-1 && !reverse) { // direção da esquerda para a direita
				
				result[pointer]=snail[row][col];
				pointer++;
				col++;
				
			}else if(col == l-1 && !reverse) { // direção a descer
				
				result[pointer]=snail[row][col];
				pointer++;
				row++;
				
			}else if(row == l-1 && col > ini &&  reverse) { //direção da direita para a esquerda
				
				result[pointer]=snail[row][col];
				pointer++;
				col--;
			}else if(col == ini &&  reverse) { //direção a subir
				
				result[pointer]=snail[row][col];
				pointer++;
				row--;
				
			} 
			
			if(col == l-1 && row == l-1) { // reverse serve para distinguir as direções horizontais e as verticais
				reverse = true;
			}
			
			
			if(col == ini && row == ini+1 && reverse) { //reduzir o tamanho da matriz para interar sobre as matrizes interiores
				ini++;
				reverse=false;
				l--;
			}
			
			
			if(result[snail.length*snail.length-1]!= 0) { //Se já tiver iterado pela matriz inteira saí do loop
				break;
			}
		}
		return futureResult;
	}
  }

