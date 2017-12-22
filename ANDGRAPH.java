import java.util.Scanner;

 class ANDGRAPH {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		
		while (n-- > 0) {
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();

			System.out.println(maxPaths(num1, num2));
		}
		scanner.close();
	}

	private static long maxPaths(int s, int t) {
		long out = 0l;

		if (s == t)
			return 0l;

		if ((s & t) == 0)
			out++;

		for (int i = s + 1; i <= t; i++) {
			if ((s & i) == 0) {

				out = out + maxPaths(i, t);

			}
		}

		return out % 998244353;

	}
}