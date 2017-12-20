import java.util.Scanner;

public class DIGJUMP {

	void initialiseAdjacencyMatrix(int adjacency_matrix[][], int input) {

		String inputStrng = String.valueOf(input);
		int length = inputStrng.length();
		adjacency_matrix = new int[length][length];

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				adjacency_matrix[i][j] = 0;

		for (int i = 0; i < length; i++) {
			for (int j = i ; j < length; j++) {
				if ((inputStrng.charAt(i) == inputStrng.charAt(j) && i!=j) || j==i+1) {
					adjacency_matrix[i][j] = 1;
				}

			}
		}

		for (int i = 0; i < length; i++)
			for (int j = 0; j < length; j++)
				if (adjacency_matrix[i][j] == 1 && adjacency_matrix[j][i] == 0)
					adjacency_matrix[j][i] = 1;

		System.out.println("adjacency matrix is -");

		for (int i = 0; i < length; i++) {

			for (int j = 0; j < length; j++)
				System.out.print(adjacency_matrix[i][j]);

			System.out.println();
		}

	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		int adjacency_matrix[][] = null;

		DIGJUMP obj = new DIGJUMP();
		obj.initialiseAdjacencyMatrix(adjacency_matrix, input);

	}

}
