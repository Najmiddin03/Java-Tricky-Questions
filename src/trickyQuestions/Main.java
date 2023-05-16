package trickyQuestions;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 5, 6, 7, 8, 9 };
		System.out.println(f15(arr, 9));

	}

	static void f1() {
		// Print 1...100 without using numbers
		int one = " ".length();
		String s1 = "..........";

		for (int i = one; i <= (s1.length() * s1.length()); i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = " ".length(); i <= 'd'; i++) {
			System.out.print(i + " ");
		}
	}

	static void f2(int num) {
		// Print 1...100 without using loop
		// Using IntStream
		if (num == 1) {
			IntStream.range(1, 101).forEach(e -> System.out.print(e + " "));
			System.out.println();
		}
		// Using recursive function
		if (num <= 100) {
			System.out.print(num + " ");
			f2(++num);
		}
	}

	static void f3() {
		// Print 1...100 without using loop and recursion
		// Using arrays fill
		Object[] num = new Object[100];
		Arrays.fill(num, new Object() {
			int count = 0;

			@Override
			public String toString() {
				return Integer.toString(++count);
			}
		});
		System.out.println(Arrays.toString(num));
		// Using BitSet
		String set = new BitSet() {
			{
				set(1, 101);
			}
		}.toString();
		System.out.append(set, 1, set.length());
	}

	static void f4() {
		// Print Hello world without using semicolon ';'
		if (System.out.printf("Hello World") == null) {
		}
	}

	static void f5() {
		// Compare two int numbers (Integer caching)
		Integer num1 = 190;
		Integer num2 = 190;
		if (num1 == num2) {
			System.out.println("Equal");
		} else {
			System.out.println("Not equal");
		}
	}

	static void f6() {
		// What is NaN - Not a Number
		System.out.println(2.0 / 0.0);
		System.out.println(0.0 / 0.0);
		System.out.println(Math.sqrt(-1));
		System.out.println(Float.NaN == Float.NaN);
	}

	static void f7() {
		// Dividing by zero
		System.out.println(5.0 / 0);// Infinity
		System.out.println(8f / 0); // Infinity
		System.out.println(8 / 0.0);// Infinity
		System.out.println(6d / 0); // Infinity
		System.out.println(0.0 / 0);// NaN
		System.out.println(0 / 0.0);// NaN
	}

	static void f8() {
		// Long without L
		long l = 100 * 60 * 60 * 24 * 365;
		System.out.println(l);// -1141367296 -> 32 bit
		long l2 = 100 * 60 * 60 * 24 * 365L;
		System.out.println(l2);// 3153600000 -> 36 bit

	}

	static void f9() {
		// What is the value of double MIN_VALUE
		// Which one is bigger - Double MIN_VALUE or 0.0d
		// Which one is bigger - Double MIN_VALUE or NEGATIVE_INFINITY
		System.out.println(Double.MIN_VALUE);
		System.out.println(Math.max(Double.MIN_VALUE, 0.0d));
		System.out.println(Math.max(Double.MIN_VALUE, Double.NEGATIVE_INFINITY));
	}

	static void f10(Object o) {
		System.out.println("Object argument");
	}

	static void f10(String s) {
		System.out.println("String argument");
	}

	static void f11(int[] arr) {
		// find duplicates
		Set<Integer> set = new HashSet<>();
		for (int x : arr) {
			if (!set.add(x)) {
				System.out.println(x);
			}
		}
	}

	static void f12(String str) {
		if (str == null) {
			return;
		}
		Map<Character, Integer> m = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (m.containsKey(str.charAt(i))) {
				m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
			} else {
				m.put(str.charAt(i), 1);
			}
		}
		Set<Map.Entry<Character, Integer>> entrySet = m.entrySet();
		for (Map.Entry<Character, Integer> es : entrySet) {
			if (es.getValue() > 1) {
				System.out.println(es);
			}
		}
	}

	static void f13() {
		// Execute comments \u000dSystem.out.println("This line is written in comment section");
	}

	static void f14() {
		// Compare site URL and IP address
		try {
			System.out.println(new URL("https://google.com").equals(new URL("https://172.217.18.14")));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static int f15(int[] arr, int count) {
		int expSum = count * (count + 1) / 2;
		int actualSum = 0;
		for (int i = 0; i < arr.length; i++) {
			actualSum += arr[i];
		}
		return expSum - actualSum;
	}
}
