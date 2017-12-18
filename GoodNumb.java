import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GoodNumb {

	public static List<Integer> divisors(int numbers) {
		int n = numbers;
		List<Integer> divisors = new ArrayList<Integer>();
		divisors.add(1);
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				divisors.add(i);
			}
		}

		return divisors;
	}

	public static boolean isPrime(int n) {
		if (n==1) return false;
		// fast even test.
		if (n > 2 && (n & 1) == 0)
			return false;
		// only odd factors need to be tested up to n^0.5
		for (int i = 3; i * i <= n; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	public static boolean isPerfectSquare(int numb) {
		double sqrt = Math.sqrt(numb);
		int x = (int) sqrt;
		if (Math.pow(sqrt, 2) == Math.pow(x, 2)) {
			return true;
		}
		return false;
	}

	public static boolean isGoodNumb(int numb) {
		List<Integer> divisors = divisors(numb);

		// LETS FIRST CHECK IF IT IS SQUARE FREE
		for (int i : divisors)
			if (i > 1)
				if (isPerfectSquare(i)) // if any of the divisor is perfect square then its numb is not Square free
					return false;

		int s = 0, c = 0;

		for (int i : divisors)
			s += i;

		for (Integer integer : divisors(s))
			if (isPrime(integer))
				c += 1;
		
		if (isPrime(c))  return true;
		
		return false;
	}

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
        while(n-->0)
        {
		int L = 0;
		int R = 0;
		L = reader.nextInt(); // Scans the next token of the input as an int.
		R = reader.nextInt();
		int outputSum = 0;
		for (int i = L; i <= R; i++) {
			if (i != 1 && isGoodNumb(i)) {
				

				for (Integer integer : divisors(i)) {
					outputSum += integer;
				}
			}
		}
		
		System.out.println(outputSum);
	}}
}
