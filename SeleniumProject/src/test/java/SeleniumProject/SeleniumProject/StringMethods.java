package SeleniumProject.SeleniumProject;

public class StringMethods {

	static void reverse(char str[], int start, int end) {
		char temp;

		while (start <= end) {
			temp = str[start];
			str[start] = str[end];
			str[end] = temp;
			start++;
			end--;
		}
	}

	// Function to reverse words
	static char[] reverseWords(char[] chArray) {
	
		int start = 0;
		for (int end = 0; end < chArray.length; end++) {
			if (chArray[end] == ' ') {
				reverse(chArray, start, end);
				start = end + 1;
			}
		}
		// Reverse the last word
		reverse(chArray, start, chArray.length - 1);

		// Reverse the entire String
		reverse(chArray, 0, chArray.length - 1);

		return chArray;
	}

	public static String reverseString(String str) {
		String reverse = "";
		char ch;
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			reverse = ch + reverse;
		}
		return reverse;
	}

	public static void main(String[] args) {

		/*String reversedString = reverseString("Geeks for Geeks");
		System.out.println(reversedString);*/

		String string = "much very program this like i ";
		char[] stringReversed = reverseWords(string.toCharArray());
		System.out.print(stringReversed);

	}

}
