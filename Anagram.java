import java.util.HashMap;

/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent", "listen")); // true
		System.out.println(isAnagram("William Shakespeare", "I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie", "Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort!!!")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));

		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");

		// Performs a stress test of randomAnagram
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass)
				break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String name1, String name2) {
		// Replace the following statement with your code
		name1 = preProcess( removeSpace(name1) );

		name2 = preProcess( removeSpace(name2) );

		if (name1.length() != name2.length()) {
			return false;
		}
		for (int i = 0; i < name1.length(); i++) {
			char c = name1.charAt(i);
			int nametochare = name2.indexOf(c);
			if (nametochare == -1) {
				return false;
			}
			else{
			name2 = remove(nametochare, name2);
		}
	}	
		return true;

		
	}



	public static String removeSpace(String str) {
		String space = " ";
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (space.indexOf(c) != -1) {
				str = remove(i, str);
				i--;
			}
		}
		return str;
	}

	public static String remove(int index, String str) {
		String prefix = str.substring(0, index);
		String suffix = "";
		if (str.length() > index + 1) {
			suffix = str.substring(index + 1);
		}
		return prefix + suffix;
	}

	// Returns a preprocessed version of the given string: all the letter characters
	// are converted
	// to lower-case, and all the other characters are deleted, except for spaces,
	// which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		// Replace the following statement with your code
		String alphabet = "abcdefghijklmnopqrstuvwxysz ";
		str = str.toLowerCase();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (alphabet.indexOf(c) == -1) {
				str = remove(i, str);
				i--;
			}
		}
		return str;
	}

	// Returns a random anagram of the given string. The random anagram consists of
	// the same
	// characters as the given string, re-arranged in a random order.
	public static String randomAnagram(String str) {
		// Replace the following statement with your code
		String randomStr = "";
		int length = str.length();
		for (int i = 0; i < length; i++) {
			int randomIndex = (int) (Math.random() * str.length());
			randomStr += str.charAt(randomIndex);
			str = remove(randomIndex, str);
		}

		return randomStr;
	}
}
