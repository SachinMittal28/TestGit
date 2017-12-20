import java.util.Scanner;

public class DIGJUMP {

	void initialiseAdjacencyMatrix(int adjacency_matrix[][], String inputStrng) {

		int length = inputStrng.length();

		for (int i = 0; i < length; i++) {
			for (int j = i; j < length; j++) {
				if ((inputStrng.charAt(i) == inputStrng.charAt(j) && i != j) || j == i + 1) {
					adjacency_matrix[i][j] = 1;
					adjacency_matrix[j][i] = 1;
				}

			}
		}

	}

	void printMatrix(int adjacency_matrix[][]) {

		System.out.println("adjacency matrix is -");
		for (int i = 0; i < adjacency_matrix.length; i++) {

			for (int j = 0; j < adjacency_matrix[i].length; j++)
				System.out.print(adjacency_matrix[i][j]);

			System.out.println();
		}
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String inputStrng = scanner.next();
		int length = inputStrng.length();
		int adjacency_matrix[][] =  new int[length][length];
		
		DIGJUMP obj = new DIGJUMP();
		obj.initialiseAdjacencyMatrix(adjacency_matrix, inputStrng);
		//obj.printMatrix(adjacency_matrix);
		
		
	}

}
