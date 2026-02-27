import java.util.*;

/**
 * Description:  Encapsulate palindrome logic in a class.
 * @version 11.0
 * Author Sandeep Rathore
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = scanner.nextLine();

        // Instantiate the service class
        PalindromeService service = new PalindromeService();

        // Call the encapsulated logic
        boolean isPalindrome = service.checkPalindrome(input);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + isPalindrome);

        scanner.close();
    }
}

/**
 * Service class that contains the encapsulated palindrome logic.
 */
class PalindromeService {
    /**
     * Checks whether the input string is a palindrome.
     * @param input The string to check
     * @return true if palindrome, otherwise false
     */
    public boolean checkPalindrome(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }

        // Initialize pointers [cite: 311]
        int start = 0; // [cite: 312]
        int end = input.length() - 1; // [cite: 313, 314]

        // Bidirectional comparison [cite: 315]
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}