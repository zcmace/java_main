package java_main;

public class test {
//this is coming from a change on github
	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 } };

		switchMaxMin(array);
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.println(array[i][j]);
			}
		}

	}

	public static void switchMaxMin(int[][] array) {

		int tempMax = 0;

		int maxRow = 0;

		int maxCol = 0;

		int tempMin = 100000000;

		int minRow = 0;

		int minCol = 0;

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] > tempMax) {
					tempMax = array[i][j];
					maxRow = i;
					maxCol = j;

				}
			
				if (array[i][j] < tempMin) {
					tempMin = array[i][j];
					minRow = i;
					minCol = j;
				}
			}

		}
		array[minRow][minCol] = tempMax;

		array[maxRow][maxCol] = tempMin;
	}

}
