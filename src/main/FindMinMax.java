package main;

public class FindMinMax {

	static long[] findMinMax(int[] arr, int prof, int pos, long actSum, long[] actSolution) {

		long tmpSum;

		++prof;

		for (int i = pos; i < arr.length; i++) {

			tmpSum = actSum + arr[i];

			if (prof == 4) {
				actSolution[0] = (tmpSum < actSolution[0]) ? tmpSum : actSolution[0];
				actSolution[1] = (tmpSum > actSolution[1]) ? tmpSum : actSolution[1];
			} else {
				// Si ya no puedo alcanzar la profundidad de 4 desde esta
				// posicion
				if ((arr.length - pos) < (4 - prof)) {
					break;
				} else {
					actSolution = findMinMax(arr, prof, i + 1, tmpSum, actSolution);
				}
			}
		}

		return actSolution;
	}

	public static void main(String[] args) {

		int[][] arr = tests();

		for (int[] test : arr) {

			long[] sol = { Long.MAX_VALUE, 0 };

			sol = findMinMax(test, 0, 0, 0, sol);

			for (long i : sol) {
				System.out.print(i + " ");
			}
			
			System.out.println("");
		}
	}

	/**
	 * Casos de prueba
	 * @return
	 */
	static int[][] tests() {

		int[][] tests = { 
				{ new Double(Math.pow(10, 9)).intValue(), new Double(Math.pow(10, 9)).intValue(), new Double(Math.pow(10, 9)).intValue(), new Double(Math.pow(10, 9)).intValue(), new Double(Math.pow(10, 9)).intValue() }, 
				{0,0,0,0,0}, 
				{1,2,3,4,5}, 
				{5,4,3,2,1}, 
				{1,5,4,3,2} 
			};

		return tests;
	}

}
