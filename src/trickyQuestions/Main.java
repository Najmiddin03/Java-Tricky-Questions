package trickyQuestions;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntPredicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import javax.imageio.ImageIO;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.Ints;

public class Main {

	static {
		//Printing hello world without main90 method
		System.out.println("Hello world");
	}
	
	public static void main(String[] args) {
		int m1[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int m2[][] = { { 10, 11 }, { 20, 21 }, { 30, 31 } };

		System.out.println("Matrix multiplication");
		int m[][] = f38(m1, m2);
		for (int arr[] : m) {
			System.out.println(Arrays.toString(arr));
		}

		System.out.println("Matrix transpose");
		m = f39(m1);
		for (int arr[] : m) {
			System.out.println(Arrays.toString(arr));
		}
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

	@SuppressWarnings("serial")
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
		// Execute comments \u000d
		System.out.println("This line is written in comment section");
	}

	static void f14() {
		// Compare site URL and IP address
		try {
			System.out.println(new URL("https://google.com").equals(new URL("https://172.217.18.14")));
		} catch (MalformedURLException e) {
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

	static void f16() {
		// Find length of String without length() method
		String str = "Hello";
		System.out.println(str.toCharArray().length);

		System.out.println(str.lastIndexOf(""));

		Matcher m = Pattern.compile("$").matcher(str);
		m.find();
		System.out.println(m.end());

		System.out.println(str.split("").length);
	}

	static void f17() {
		// StringJoiner
		StringJoiner sj = new StringJoiner("|", "[", "]");
		sj.add("Java").add("Python").add("C++");
		System.out.println(sj);
	}

	static int f18(String str, char ch) {
		// Finding occurrences of the character in String using Streams
		return (int) str.chars().filter(e -> (char) e == ch).count();
	}

	static void f19(String str) {
		// Count vowels
		IntPredicate vowel = new IntPredicate() {

			@Override
			public boolean test(int c) {
				return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I'
						|| c == 'O' || c == 'U';
			}
		};
		System.out.println(str.chars().filter(vowel).count());
	}

	static void f20(int arr1[], int[] arr2) {
		// Joining two arrays
		// Using streams
		IntStream s1 = Arrays.stream(arr1);
		IntStream s2 = Arrays.stream(arr2);
		int[] arr = IntStream.concat(s1, s2).toArray();
		System.out.println(Arrays.toString(arr));
		// Using Google Guava
		arr = Ints.concat(arr1, arr2);
		System.out.println(Arrays.toString(arr));
	}

	@SuppressWarnings("deprecation")
	static void f21(int[] arr) {
		// Calculate array average
		// Using streams
		double av = Arrays.stream(arr).average().getAsDouble();
		System.out.println(av);
		// Using Google guava
		double av2 = DoubleMath.mean(arr);
		System.out.println(av2);

	}

	static void f22(String str, String sub) {
		// Checking substring
		System.out.println(str.matches("(.*)" + sub + "(.*)"));
		System.out.println(str.contains(sub));
		System.out.println(str.indexOf(sub) != -1);
	}

	static void f23() {
		// Compare marks of the Students
		Student s1 = new Student("Noob", 56);
		Student s2 = new Student("Boba", 95);
		Student s3 = new Student("Scar", 40);
		Student s4 = new Student("Dell", 95);
		Student s5 = new Student("Melo", 85);
		List<Student> l = new ArrayList<>();
		l.add(s5);
		l.add(s4);
		l.add(s3);
		l.add(s2);
		l.add(s1);
		// Print where mark>80
		l.stream().filter(e -> e.getMark() > 80).forEach(e -> System.out.println(e.getName() + ": " + e.getMark()));
		// Who has the highest mark
		int hmark = l.stream().map(e -> e.getMark()).max(Integer::compare).get();
		System.out.println("Highest mark: " + hmark);
		System.out.println("Students with highest mark:");
		l.stream().filter(e -> e.getMark() == hmark).forEach(e -> System.out.println(e.getName()));
	}

	static void f24(int[] arr) {
		// Shift all zeros to right size of the array
		if (arr.length == 1) {
			return;
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (count != i) {
					arr[count] = arr[i];
					arr[i] = 0;
				}
				count++;
			}
		}
	}

	static void f25() {
		// Image format conversions
		try {
			URL url = new URL("https://avatars.githubusercontent.com/u/104941296?v=4");
			BufferedImage image = ImageIO.read(url);
			ImageIO.write(image, "jpg", new File("Images/naruto.jpg"));
			ImageIO.write(image, "png", new File("Images/naruto.png"));
			ImageIO.write(image, "bmp", new File("Images/naruto.bmp"));
			ImageIO.write(image, "gif", new File("Images/naruto.gif"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void f26(String str) {
		// Count characters in String
		Map<Character, Integer> m = new LinkedHashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (m.containsKey(str.charAt(i))) {
				m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
			} else {
				m.put(str.charAt(i), 1);
			}
		}
		System.out.println(m);
	}

	static void f27() {
		// Launching external applications
		Runtime runTime = Runtime.getRuntime();
		try {
			Process pr = runTime.exec("notepad.exe notepad.txt");
			Thread.sleep(4000);
			pr.destroy();
			String s[] = { "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe", "google.com" };
			runTime.exec(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static void f28() {
		// Generating random numbers
		// Random class
		Random random = new Random();
		System.out.println(random.nextInt());
		System.out.println(random.nextInt(20));// 0 to 19
		// Math.random()
		System.out.println(Math.random());
		System.out.println((int) (Math.random() * 20));// 0 to 20
		// ThreadLocalRandom
		System.out.println(ThreadLocalRandom.current().nextInt());
		System.out.println(ThreadLocalRandom.current().nextInt(10, 13));// 10 to 12
	}

	static void f29() {
		// Getting word count in text file
		Map<String, Integer> m = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader("text.txt"))) {
			String currentLine = reader.readLine();
			while (currentLine != null) {
				String words[] = currentLine.toLowerCase().split(" ");
				for (String word : words) {
					if (m.containsKey(word)) {
						m.put(word, m.get(word) + 1);
					} else {
						m.put(word, 1);
					}
				}
				currentLine = reader.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		m.forEach((k, v) -> System.out.println(k + ": " + v));
		System.out.println("Most occured words:");
		m.entrySet().stream().filter(e -> e.getValue() == Collections.max(m.values()))
				.forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
	}

	static void f30() {
		// Count total chars, words and lines in a given file
		int chars = 0;
		int words = 0;
		int lines = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
			String currLine = br.readLine();
			while (currLine != null) {
				lines++;
				String[] arr = currLine.split(" ");
				words += arr.length;
				for (String w : arr) {
					chars += w.length();
				}
				currLine = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Characters: " + chars);
		System.out.println("Words: " + words);
		System.out.println("Lines: " + lines);
	}

	static void f31() {
		// Set read/write/executable permissions for file
		File file = new File("src\\trickyQuestions\\Student.java");
		file.setExecutable(false);
		file.setReadable(false);
		file.setWritable(false);
		System.out.println("Done");
	}

	static boolean f32(String s1, String s2) {
		// Check if two Strings are Anagram
		if (s1.length() != s2.length()) {
			return false;
		}
		char[] c1 = s1.toLowerCase().toCharArray();
		char[] c2 = s2.toLowerCase().toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		return Arrays.equals(c1, c2);
	}

	static boolean f33(int n) {
		// Check if the given number is Armstrong number
		if (n < 0) {
			return false;
		}
		int m = n;
		int sum = 0;
		int pow = Integer.toString(n).length();
		while (m > 0) {
			sum += Math.pow(m % 10, pow);
			m = m / 10;
		}
		return sum == n;
	}

	static void f34(int arr[]) {
		// Find all leader elements
		if (arr.length == 0) {
			System.out.println("Empty array");
			return;
		}
		List<Integer> l = new ArrayList<>();
		int max = arr[arr.length - 1];
		l.add(max);
		for (int i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > max) {
				l.add(arr[i]);
				max = arr[i];
			}
		}
		System.out.println(l);
	}

	static int f35(String str) {
		// String to int without in-built functions
		int num = 0;
		for (char ch : str.toCharArray()) {
			num = num * 10 + ((int) ch - (int) '0');
		}
		return num;
	}

	static void f36(String str) {
		// Find percentage of different characters in String
		int upper = 0;
		int lower = 0;
		int num = 0;
		int spec = 0;
		for (char ch : str.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				upper++;
			} else if (Character.isLowerCase(ch)) {
				lower++;
			} else if (Character.isDigit(ch)) {
				num++;
			} else {
				spec++;
			}
		}
		System.out.println(upper * 100 / str.length() + " %");
		System.out.println(lower * 100 / str.length() + " %");
		System.out.println(num * 100 / str.length() + " %");
		System.out.println(spec * 100 / str.length() + " %");
	}

	static int[][] f37(int[][] m1, int[][] m2) {
		// Matrix addition
		if (m1.length != m2.length || m1[0].length != m2[0].length) {
			throw new RuntimeException("Matrixes cannot be added");
		}
		int[][] ans = new int[m1.length][m1[0].length];
		for (int r = 0; r < m1.length; r++) {
			for (int c = 0; c < m1[r].length; c++) {
				ans[r][c] = m1[r][c] + m2[r][c];
			}
		}
		return ans;
	}

	static int[][] f38(int[][] m1, int[][] m2) {
		// Matrix multiplication
		if (m1[0].length != m2.length) {
			throw new RuntimeException("Matrixes cannot be multiplied");
		}
		int[][] ans = new int[m1.length][m2[0].length];
		for (int r = 0; r < ans.length; r++) {
			for (int c = 0; c < ans[0].length; c++) {
				ans[r][c] = 0;
				for (int i = 0; i < m1[0].length; i++) {
					ans[r][c] += m1[r][i] * m2[i][c];
				}
			}
		}
		return ans;
	}

	static int[][] f39(int[][] m) {
		// Matrix transpose
		int[][] ans = new int[m[0].length][m.length];
		for (int r = 0; r < ans.length; r++) {
			for (int c = 0; c < ans[0].length; c++) {
				ans[r][c] = m[c][r];
			}
		}
		return ans;
	}

	static int i = f40();

	static int f40() {
		// Print "Hello world" without using main() method and static block
		System.out.println("Hello world");
		return 1;
	}
}
