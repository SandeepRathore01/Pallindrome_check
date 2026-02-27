import java.util.*;

/**
 * Description: Check palindrome using recursion.
 * @version 9.0
 * Author Sandeep Rathore
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = scanner.nextLine();

        // Perform recursive check starting from index 0 to length-1
        boolean isPalindrome = check(input, 0, input.length() - 1);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? " + isPalindrome);

        scanner.close();
    }

    /**
     * Recursively checks whether a string is a palindrome.
     * @param s Input string
     * @param start Starting index
     * @param end Ending index
     * @return true if palindrome, otherwise false
     */
    private static boolean check(String s, int start, int end) {
        // Base Condition: If pointers meet or cross, it's a palindrome
        if (start >= end) {
            return true;
        }

        // Check if characters at current positions match
        if (s.charAt(start) != s.charAt(end)) {
            return false;
        }

        // Recursive call: Move inward
        return check(s, start + 1, end - 1);
    }
}