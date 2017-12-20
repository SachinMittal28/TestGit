import java.util.LinkedList;
import java.util.Queue;
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

	void bfs(int adjacency_matrix[][]) {
		  Queue<Integer> queue = new LinkedList<Integer>();;
		  queue.add(0);
		  int steps=0;
		  int[] visited = new int[adjacency_matrix.length];
		  int[] d = new int[adjacency_matrix.length];
		
		  for(int i=0;i<d.length;i++)
			 d[i]=100;  //it is proven in digjump-editorial that d[] can not be greater than 19.
		  
		  visited[0] = 1;
		  d[0]=0;
		  
		  while (!queue.isEmpty()) {
			  int popElement = queue.remove();
			  for (int j =0;j<adjacency_matrix[popElement].length;j++) {
				  if (adjacency_matrix[popElement][j]==1 && visited[j]==0) {
					 
					  visited[j]=1;
					  queue.add(j);
					  
					  if(d[j]>d[popElement]+1) {
						  d[j]=d[popElement]+1;
					  }
				  }
			  }
		  }
		  System.out.println(d[adjacency_matrix.length-1]);
	}
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String inputStrng = scanner.next();
		int length = inputStrng.length();
		int adjacency_matrix[][] =  new int[length][length];
		
		DIGJUMP obj = new DIGJUMP();
		obj.initialiseAdjacencyMatrix(adjacency_matrix, inputStrng);
		//obj.printMatrix(adjacency_matrix);
		
		obj.bfs(adjacency_matrix);
	}

}
