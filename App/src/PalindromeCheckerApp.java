import java.util.*;

/**
 * Description:  Strategy Pattern for Palindrome Algorithms (Advanced).
 * @version 12.0
 * Author Sandeep Rathore
 */
/**
 * Interface defining the contract for palindrome checking algorithms.
 */
interface PalindromeStrategy {
    boolean check(String input);
}

/**
 * Concrete implementation using a Stack data structure.
 */
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();

        // Push characters onto stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        // Pop and compare with original sequence
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = scanner.nextLine();

        // Dynamically select the strategy (In this case, StackStrategy)
        PalindromeStrategy strategy = new StackStrategy();

        // Execute the selected algorithm
        boolean isPalindrome = strategy.check(input);

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + isPalindrome);

        scanner.close();
    }
}
