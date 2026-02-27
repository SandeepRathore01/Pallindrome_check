import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //version 4
        System.out.println("--- UC4: Palindrome Checker (Character Array) ---");
        System.out.print("Enter a string to check: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("\"" + input + "\" is a palindrome.");
        } else {
            System.out.println("\"" + input + "\" is NOT a palindrome.");
        }

        scanner.close();
    }

    /**
     * Validates if a string is a palindrome using a char array and two pointers.
     */
    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        // Step 1: Convert string to char[] for index-based access
        // We often normalize to lowercase to ensure 'A' == 'a'
        char[] charArray = str.toLowerCase().toCharArray();

        // Step 2: Initialize two pointers
        int left = 0;
        int right = charArray.length - 1;

        // Step 3: Compare characters moving toward the center
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false; // Mismatch found, not a palindrome
            }
            left++;  // Move start pointer forward
            right--; // Move end pointer backward
        }

        return true; // All characters matched
    }
}

