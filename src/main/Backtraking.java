package main;

import java.util.Arrays;

public class Backtraking {

	static int[] acumula(int[] nums, int i, int acum, int profundidad, int[] solution) {

		int[] finalSolution = null;
		
		int[] tmpSolution = Arrays.copyOf(solution, solution.length);
		
		++profundidad;

		for (int j = i; j < nums.length; j++) {

			tmpSolution[profundidad] = nums[j];

			if (acum + nums[j] == 31) {
				finalSolution = Arrays.copyOf(tmpSolution, tmpSolution.length);
				break;
			} else {

				finalSolution = acumula(nums, j + 1, acum + nums[j], profundidad, tmpSolution);
				
				if (finalSolution!=null) break;
			}
		}

		return finalSolution;
	}

	static void imprimir(int[] sol) {
		System.out.print(" Encontrado: ");
		for (int i : sol) {
			System.out.print(" --> " + i);
		}
	}

	public static void main(String args[]) {
		int[] nums = { 11, 13, 24, 7};
		int[] solution = new int[5];

		solution = acumula(nums, 0, 0, -1, solution);
		
		imprimir(solution);
	}
}
