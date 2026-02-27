# PalindromeCheck
**Goal**

The goal of this use case is to display a welcome message and application details when the program starts.

**Actor**

User

**Flow**

When the program starts, the JVM invokes the public static void main(String[] args) method. The application name is displayed, followed by the application version using System.out.println(). After showing these startup details, the program either continues to the next use case or exits.

**Key Concepts**

Class – Acts as a container for the Palindrome Checker application logic.
Main Method – Entry point of the Java application.
Static Keyword – Allows the JVM to call the main method without creating an object.
Console Output – Uses System.out.println() to display messages.
Application Flow Control – Defines the startup behavior before palindrome processing begins.

**Compilation and Execution**

* **To compile the program:**
javac UseCase1PalindromeCheckerApp.java

* **To run the program:**
java UseCase1PalindromeCheckerApp