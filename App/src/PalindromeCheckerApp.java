import java.util.Scanner; // Import Scanner for user input
import java.util.Stack;

/**
 * Description: This class validates a palindrome using a Stack
 * data structure which follows the LIFO principle.
 * @version 5.0
 * Author Sandeep Rathore
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        // Initialize Scanner to read from console
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter input: ");
        // Read the user input string
        String input = scanner.nextLine();

        // Create a Stack to store characters.
        Stack<Character> stack = new Stack<>();

        // Step 1: Push each character of the string into the stack.
        for (char c : input.toCharArray()) {
            stack.push(c); // Pushes characters into a stack
        }

        // Step 2: Pop and compare with the original sequence.
        boolean isPalindrome = true; // Assume palindrome initially

        for (char c : input.toCharArray()) {
            // Pop Operation - removes characters in reverse order
            if (c != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        // Step 3: Print result
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + isPalindrome);

        scanner.close(); // Close the scanner resource
    }
}