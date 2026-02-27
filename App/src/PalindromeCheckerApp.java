import java.util.*;

/**
 * Description: Demonstrate FIFO vs LIFO using Queue and Stack
 * @version 6.0
 * Author Sandeep Rathore
 */
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = scanner.nextLine();

        // Create a Queue (FIFO) and a Stack (LIFO)
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Insert each character into both structures
        for (char c : input.toCharArray()) {
            queue.add(c);  // Enqueue
            stack.push(c); // Push
        }

        boolean isPalindrome = true; //

        // Compare characters until the queue is empty
        while (!queue.isEmpty()) {
            // Compare dequeue (front) vs pop (top)
            if (queue.poll() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome?: " + isPalindrome);
        scanner.close();
    }
}