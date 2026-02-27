import java.util.*;

/**
 * Description: Using Deque to compare front and rear elements.
 * @version 7.0
 * Author Sandeep Rathore
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        // Define the input string [cite: 131]
        String input = scanner.nextLine();

        // Create a Deque to store characters [cite: 133, 134]
        Deque<Character> deque = new ArrayDeque<>();

        // Add each character to the deque [cite: 135, 136]
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        // Flag to track palindrome result [cite: 138, 139]
        boolean isPalindrome = true;

        // Continue comparison while more than one element exists [cite: 140, 141]
        while (deque.size() > 1) {
            // Remove first & last and compare [cite: 102, 118, 119]
            if (deque.removeFirst() != deque.removeLast()) {
                isPalindrome = false;
                break;
            }
        }

        // Print result [cite: 143, 144]
        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + isPalindrome);

        scanner.close();
    }
}