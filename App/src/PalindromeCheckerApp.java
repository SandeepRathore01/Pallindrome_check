import java.util.*;

/**
 * Description:  : Compare the performance of different palindrome approaches..
 * @version 13.0
 * Author Sandeep Rathore
 */
// --- STRATEGY INTERFACE (UC12) ---
interface PalindromeStrategy {
    boolean check(String input);
}

// --- UC4 & UC11: TWO-POINTER / OO LOGIC ---
class SimpleStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        int start = 0, end = input.length() - 1;
        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) return false;
            start++; end--;
        }
        return true;
    }
}

// --- UC5: STACK-BASED LOGIC (LIFO) ---
class StackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) stack.push(c);
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) return false;
        }
        return true;
    }
}

// --- UC6: QUEUE + STACK LOGIC (FIFO vs LIFO) ---
class QueueStackStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != stack.pop()) return false;
        }
        return true;
    }
}

// --- UC7 & UC8: DEQUE / LINKED LIST LOGIC ---
class DequeStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : input.toCharArray()) deque.addLast(c);
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}

// --- UC9: RECURSIVE LOGIC ---
class RecursiveStrategy implements PalindromeStrategy {
    public boolean check(String input) {
        return checkRecursive(input, 0, input.length() - 1);
    }
    private boolean checkRecursive(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return checkRecursive(s, start + 1, end - 1);
    }
}

// --- MAIN APPLICATION ---
public class PalindromeCheckerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Palindrome Checker App (UC4 - UC13) ===");
        System.out.print("Enter string to check: ");
        String originalInput = scanner.nextLine();

        System.out.println("\nSelect Algorithm:");
        System.out.println("1. Two-Pointer (UC4)");
        System.out.println("2. Stack LIFO (UC5)");
        System.out.println("3. Queue + Stack (UC6)");
        System.out.println("4. Deque / Linked List (UC7/8)");
        System.out.println("5. Recursive (UC9)");
        System.out.println("6. Case-Insensitive/Ignore Spaces (UC10)");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();

        String processingInput = originalInput;
        PalindromeStrategy strategy;

        // UC10 Logic: Normalization
        if (choice == 6) {
            processingInput = originalInput.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            strategy = new SimpleStrategy();
        } else {
            switch (choice) {
                case 2: strategy = new StackStrategy(); break;
                case 3: strategy = new QueueStackStrategy(); break;
                case 4: strategy = new DequeStrategy(); break;
                case 5: strategy = new RecursiveStrategy(); break;
                default: strategy = new SimpleStrategy(); break;
            }
        }

        // UC13 Logic: Performance Benchmarking
        long startTime = System.nanoTime();
        boolean result = strategy.check(processingInput);
        long endTime = System.nanoTime();

        System.out.println("\n--- Results ---");
        System.out.println("Input: " + originalInput);
        System.out.println("Is Palindrome: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");

        scanner.close();
    }
}