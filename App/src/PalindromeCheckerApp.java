import java.util.*;

/**
 * Description: Case-Insensitive & Space-Ignored Palindrome
 * @version 10.0
 * Author Sandeep Rathore
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = scanner.nextLine();

        // Step 1: Normalize the string (Remove non-alphanumeric and lowercase)
        // Using regex to replace all non-word characters [cite: 245, 254]
        String normalized = input.replaceAll("[^a-zA-Z0-0]", "").toLowerCase();

        boolean isPalindrome = true;

        // Step 2: Compare characters from both ends
        for (int i = 0; i < normalized.length() / 2; i++) {
            // Compare symmetric characters [cite: 271]
            if (normalized.charAt(i) != normalized.charAt(normalized.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Output results
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + isPalindrome);

        scanner.close();
    }
}