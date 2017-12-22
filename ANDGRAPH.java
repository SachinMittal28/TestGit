import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class ANDGRAPH {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		while (n-- > 0) {
			String num1 = scanner.next();
			String num2 = scanner.next();
			int n1 = Integer.parseInt(num1,2);
			int n2 = Integer.parseInt(num2,2);

			System.out.println(maxPaths(n1, n2));
		}
		scanner.close();
	}

	private static long maxPaths(int s, int t) {
		
		//List<Long> list = new ArrayList<Long>(Collections.nCopies(t-s+1, -1L));
		List<Long> list = new ArrayList<Long>(t-s+1);
		for(int i=0;i<list	.size();i++) {
			list.add(i,-1l);
		}
		list.add(0,0l);
		long out = 0l;

		if (s == t)
			return 0l;

		if ((s & t) == 0)
			out++;

		for (int i = s + 1; i <= t; i++) {
			if ((s & i) == 0) {
				
				if (list.get(t - i) == -1L)
					list.add(t - i, maxPaths(i, t));
				
				out = out + list.get(t - i);

			}
		}

		return out % 998244353;

	}
}