package org.bhawanisingh.java.demo;

/**
 * 
 * @author Bhawani Singh
 */
public class StringDemo {
	static int wordCount(String s) {
		s = StringDemo.allTrim(s);
		if (s.length() == 0) {
			return 0;
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == (s.length() - 1)) {
				count++;
			}

			else if (s.charAt(i) == ' ') {
				if (s.charAt(i + 1) == ' ') {
					continue;
				}
				count++;
			}
		}
		return count;
	}

	static int spaceCount(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int count = 0;
		char c[] = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (c[i] == ' ') {
				count++;
			}
		}
		return count;
	}

	static int charCount(String s) {
		char c[] = s.toCharArray();
		int count = 0;
		for (char element : c) {
			if (element != ' ') {
				count++;
			}
		}
		return count;
	}

	static String reverseString(String s) {
		char c[] = s.toCharArray();
		char c1[] = new char[s.length()];
		for (int i = 0; i < c.length; i++) {
			c1[i] = c[c.length - (i + 1)];
		}
		String s1 = new String(c1);
		return s1;
	}

	static boolean pallindrome(String s) {
		String s1 = StringDemo.reverseString(s);
		char c[] = s.toCharArray();
		char c1[] = s1.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] != c1[i]) {
				return false;
			}
		}
		return true;
	}

	static String lTrim(String s) {
		char c[] = s.toCharArray();
		int j = 0;
		loop: for (int i = 0; i < c.length; i++) {
			if (c[i] != ' ') {
				j = i;
				break loop;
			}
		}
		char c1[] = new char[(c.length - j)];
		for (int i = 0; j < c.length; j++, i++) {
			c1[i] = c[j];
		}
		s = new String(c1);
		return s;
	}

	static String rTrim(String s) {
		s = StringDemo.reverseString(s);
		s = StringDemo.lTrim(s);
		s = StringDemo.reverseString(s);
		return s;
	}

	static String allTrim(String s) {
		s = StringDemo.lTrim(s);
		s = StringDemo.rTrim(s);
		return s;
	}

	static String squeeze(String s) {
		s = StringDemo.allTrim(s);
		int count = StringDemo.spaceCount(s);
		char c[] = s.toCharArray();
		char c1[] = new char[c.length - count];
		for (int i = 0, j = 0; i < c.length; i++) {
			if (c[i] != ' ') {
				c1[j] = c[i];
				j++;
			}
		}
		s = new String(c1);
		return s;
	}

	static int vowelCount(String s) {
		char c[] = s.toCharArray();
		int count = 0;
		for (char element : c) {
			switch (element) {
				case 'A':
				case 'E':
				case 'I':
				case 'O':
				case 'U':
				case 'a':
				case 'e':
				case 'i':
				case 'o':
				case 'u':
					count++;
			}
		}
		return count;
	}

	static int length(String s) {
		int i = 0;
		try {
			for (i = 0; i >= i; i++) {
				s.charAt(i);
			}
		} finally {
			return i;
		}
	}

	static void sequenceCount(String s) {
		char c[] = s.toCharArray();
		int count;
		int temp;
		for (int i = 0; i < c.length; i++) {
			if (c[i] != ' ') {
				temp = i;
				count = 0;
				for (int j = i; j < c.length; j++) {
					if ((c[i] == c[j]) && (j == (c.length - 1))) {
						count++;
						i = (i + count) - 1;
						break;

					}
					else if (c[i] == c[j]) {
						count++;
					}
					else {
						i = (i + count) - 1;
						break;
					}
				}
				System.out.println(c[temp] + "\t:\t" + count);
			}
		}
	}

	static void frequencyCount(String s) {
		char c[] = s.toCharArray();
		int count;
		for (int i = 0; i < c.length; i++) {
			count = 0;
			for (int j = 0; j < c.length; j++) {
				if ((j < i) && (c[j] == c[i])) {
					break;
				}
				else if ((j >= i) && (c[i] == c[j])) {
					count++;
				}
			}
			if (count != 0) {
				System.out.println(c[i] + "\t:\t" + count);
			}
		}
	}

	static String changeCase(String s) {
		byte b[] = s.getBytes();
		for (int i = 0; i < b.length; i++) {
			if ((b[i] >= 65) && (b[i] <= 90)) {
				b[i] = (byte) (b[i] + 32);
			}
			else if ((b[i] >= 97) && (b[i] <= 122)) {
				b[i] = (byte) (b[i] - 32);
			}
		}
		s = new String(b);
		return s;
	}

	static String singleOccurance(String s) {
		char c[] = s.toCharArray();
		int count = 0;
		int temp;
		for (int i = 0; i < c.length; i++) {
			if (c[i] != ' ') {
				temp = i;
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] == c[j]) {
						count++;
					} else {
						i = j - 1;
						break;
					}
				}
			}
		}
		System.out.println(count);
		char c1[] = new char[c.length - count];
		for (int i = 0, k = 0; i < c.length; i++, k++) {
			c1[k] = c[i];
			for (int j = i; j < c.length; j++) {
				if (c[i] != c[j]) {
					i = j - 1;
					break;
				}
			}
		}
		s = new String(c1);
		return s;
	}

	static String sortedOrder(String s) {
		byte b[] = s.getBytes();
		byte temp;
		for (int i = 0; i < b.length; i++) {
			for (int j = i; j < b.length; j++) {
				if (b[i] > b[j]) {
					temp = b[i];
					b[i] = b[j];
					b[j] = temp;
				}
			}
		}
		s = new String(b);
		return s;
	}

	static String sortedWord(String s) {
		int size = StringDemo.wordCount(s);
		String s1[] = new String[size];
		String temp;
		for (int i = 0; i < size; i++) {
			if (i == (size - 1)) {
				s1[i] = s.substring(0);
			} else {
				s1[i] = s.substring(0, s.indexOf(' '));
				s = s.substring(s.indexOf(' ') + 1);
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (s1[i].compareToIgnoreCase(s1[j]) > 0) {
					temp = s1[i];
					s1[i] = s1[j];
					s1[j] = temp;
				}
			}
		}
		s = s1[0];
		for (int i = 1; i < size; i++) {
			s = s + " " + s1[i];
		}
		return s;
	}

	static boolean find(String s, String f) {
		if (s.length() < f.length()) {
			return false;
		}
		char c[] = s.toCharArray();
		char c1[] = f.toCharArray();
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c1.length; j++) {
				if ((c[i] == c1[j]) && (j == (c1.length - 1))) {
					return true;
				} else if ((c[i] == c1[j]) && (i == (c.length - 1))) {
					return false;
				} else if (c[i] == c1[j]) {
					i++;
				}
			}
		}
		return false;
	}

	static String replace(String s, String f, String r) {
		if (s.length() < f.length()) {
			return "";
		}
		if (r.length() == 0) {
			return "Error!!! String Cannot Be Replaced With Empty String";
		}
		char c[] = s.toCharArray();
		char c1[] = f.toCharArray();
		String retString = null;
		String tempString = null;
		int index = -1;
		boolean flag = false;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c1.length; j++) {
				if ((c[i] == c1[j]) && (j == (c1.length - 1))) {
					flag = true;
					index = i;
					System.out.println(index);
				} else if ((c[i] == c1[j]) && (i == (c.length - 1))) {
					index = -1;
					flag = false;
				} else if (c[i] == c1[j]) {
					i++;
					index = i;
				}
			}
			if (index != -1) {
				break;
			}
		}
		if (flag && (index != -1)) {
			retString = StringDemo.replace(s.substring(index + 1), f, r);
			if (retString.equals("String Not Found")) {
				return s.substring(0, (index - f.length()) + 1) + r + s.substring(index + 1);
			}
			return s.substring(0, (index - f.length()) + 1) + r + retString;
		}
		return "String Not Found";
	}

	static boolean equals(String s, String s1) {
		if (s.length() != s1.length()) {
			return false;
		}
		char c[] = s.toCharArray();
		char c1[] = s1.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			if (c[i] != c1[i]) {
				return false;
			}
		}
		return true;
	}

	static void triangle1(String s) {
		char c[] = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.println();
			for (int j = 0; j <= i; j++) {
				System.out.print(c[j]);
			}
		}
	}

	static void triangle2(String s) {
		char c[] = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.println();
			for (int j = 0; j < (c.length - i); j++) {
				System.out.print(c[j]);
			}
		}
	}

	static void triangle3(String s) {
		char c[] = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.println();
			for (int j = 0; j < c.length; j++) {
				if (i < j) {
					System.out.print(" ");
				} else {
					System.out.print(c[j]);
				}
			}
		}
	}

	static void triangle4(String s) {
		char c[] = s.toCharArray();
		for (int i = 0; i < c.length; i++) {
			System.out.println();
			for (int j = 0; j < c.length; j++) {
				if (j < (c.length - i)) {
					System.out.print(c[j]);
				} else {
					System.out.print(" ");
				}
			}
			for (int j = 0; j < c.length; j++) {
				if (i <= j) {
					System.out.print(c[j]);
				} else {
					System.out.print(" ");
				}
			}
		}
	}

	static int compare(String s, String s1) {
		if ((s.length() - s1.length()) != 0) {
			return s.length() - s1.length();
		}
		byte b[] = s.getBytes();
		byte b1[] = s1.getBytes();
		for (int i = 0; i < b.length; i++) {
			if ((b[i] - b1[i]) != 0) {
				return b[i] - b1[i];
			}
		}
		return 0;
	}

	public static void wordFrequencyCount(String s) {
		int count = StringDemo.wordCount(s);
		String ar[] = new String[count];
		int ocr = 0;
		for (int i = 0; i < count; i++) {
			if (i == (count - 1)) {
				ar[i] = s.substring(0);
			} else {
				ar[i] = s.substring(0, s.indexOf(' '));
				s = s.substring(s.indexOf(' ') + 1);
			}
		}
		for (int i = 0; i < count; i++) {
			ocr = 0;
			for (int j = 0; j < count; j++) {
				if ((j < i) && (StringDemo.compare(ar[i], ar[j]) == 0)) {
					break;
				} else if ((j >= i) && (StringDemo.compare(ar[i], ar[j]) == 0)) {
					ocr++;
				}
			}
			if (ocr != 0) {
				System.out.println(ar[i] + "\t:\t" + ocr);
			}
		}
	}

	public static void main(String... s) {
		// Word Count Function
		System.out.println("1.\tTotal Number Of Words :\t" + StringDemo.wordCount("Incredible India"));

		// Space Count Function
		System.out.println("\n2.\tTotal Number Of Spaces :\t" + StringDemo.spaceCount("Incredible India"));

		// Char Count Function
		System.out.println("\n3.\tTotal Number Of Charatcters :\t" + StringDemo.charCount("Incredible India"));

		// Reverse Function
		System.out.println("\n4.\tReversed String :\t" + StringDemo.reverseString("Awesome"));

		// Pallindrome Function
		System.out.println("\n5.\tPallindrome Check :\t" + StringDemo.pallindrome("madam1"));

		// lTrim Function
		System.out.println("\n6.\tLeft Trim :\t" + StringDemo.lTrim("     nvidia") + "\t\tLength After Left Trimming :\t" + StringDemo.lTrim("      nvidia").length());

		// rTrim Function
		System.out.println("\n7.\tRight Trim :\t" + StringDemo.rTrim("nvidia     ") + "\t\tLength After Right Trimming :\t" + StringDemo.rTrim("nvidia     ").length());

		// allTrim Function
		System.out.println("\n8.\tAll Trim:\t" + StringDemo.allTrim("    nvidia    ") + "\t\tLength After Trimming :\t" + StringDemo.allTrim("    nvidia    ").length());

		// Squeeze Function
		System.out.println("\n9.\tSqueeze :\t" + StringDemo.squeeze(" n v i d i a "));

		// Vowel Count Function
		System.out.println("\n10.\tTotal Number Of Vowels :\t" + StringDemo.vowelCount("World Is Awesome"));

		// Length function
		System.out.println("\n11.\tLength Is :\t" + StringDemo.length("World Is Awesome"));

		// Sequence Count Function
		System.out.println("\n12.\tSequence Count :\t");
		StringDemo.sequenceCount("Cool India");

		// Frequency Count Function
		System.out.println("\n13.\tFrequency Count :\t");
		StringDemo.frequencyCount("INDIA IS GREAT");

		// Change Case Function
		System.out.println("\n14.\tAfter Changing Case :\t" + StringDemo.changeCase("WoRlD"));

		// Single Occurrance Function
		System.out.println("\n15.\tSingle Occurance :\t" + StringDemo.singleOccurance("IIIIIIIIIINNNNNNNNNNNNNDDDDDDDDDDDDDDDDDIIIIIIIIIIIIIIIAAAA   IIIISSSS BBBBEEEESSST"));

		// Sorted Order Function
		System.out.println("\n16.\tSorted Order :\t" + StringDemo.sortedOrder("india"));

		// Sorted Word Function
		System.out.println("\n17.\tSorted Word :\t" + StringDemo.sortedWord("Java C++ Ducat Kool World"));

		// Find Function
		System.out.println("\n18.\tFind :\t" + StringDemo.find("Java :- Good Programming Language", "Language"));

		// Replace Function
		System.out.println("\n19.\tReplace :\t" + StringDemo.replace("Java C++ Python Ruby English Php", "English", "Visual Basic"));

		// Equals Function
		System.out.println("\n20.\tEquals :\t" + StringDemo.equals("Ducat India", "Ducat India"));

		// Triangle1 Function
		System.out.println("\n21.\tTriangle1:");
		StringDemo.triangle1("Ducat");

		// Triangle2 Function
		System.out.println("\n\n22.\tTriangle2:");
		StringDemo.triangle2("Ducat");

		// Triangle3 Function
		System.out.println("\n\n23.\tTriangle3:");
		StringDemo.triangle3("Ducat");

		// Triangle4 Function
		System.out.println("\n\n24.\tTriangle4:");
		StringDemo.triangle4("Ducat");

		// Compare Function
		System.out.println("\n\n25.\tCompare :\t" + StringDemo.compare("Ducat", "Ducat"));

		// Word Frequency Count Function
		System.out.println("\n26.\tWord Frequency Count :\t");
		StringDemo.wordFrequencyCount("Life Is Incredible India Is Incredible Earth Is Best Planet Punjab Is Best");
	}
}