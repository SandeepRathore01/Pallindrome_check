import java.util.*;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        System.out.println("Welcome to palindrome checker app management system");
        System.out.println("Version 1.0");
        //Author : Sandeep Rathore
        System.out.println("System initialized successfully");
        System.out.print("Enter a string: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        boolean isPalindrome = true;
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("It is a Palindrome.");
        } else {
            System.out.println("It is not a Palindrome.");
        }

        sc.close();
    }
}
