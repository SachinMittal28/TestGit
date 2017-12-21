import java.util.Scanner;

class BINTREE {

	int longestCommonPrefixIndex(String s, String s2) {
		String small, large;
		if (s.length() > s2.length()) {
			small = s2;
			large = s;
		} else {
			small = s;
			large = s2;
		}
		int index = 0;
		for (char c : large.toCharArray()) {
			if (index == small.length())
				break;
			if (c != small.charAt(index))
				break;
			index++;
		}

		// System.out.println("small.length()-index = " + (small.length()-index) );
		// System.out.println("large.length()-index = " + (large.length()-index) );

		// System.out.println("small.length()-index + large.length()-index = " +
		// (small.length()-index+ large.length()-index) );

		return (small.length() - index + large.length() - index);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		while (n-- > 0) {

			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();

			BINTREE obj = new BINTREE();

			String n1 = Integer.toBinaryString(num1);
			String n2 = Integer.toBinaryString(num2);
			int out = obj.longestCommonPrefixIndex(n1, n2);
			System.out.println(out);

		}
		scanner.close();
	}
}