import java.util.*;
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}
class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }
        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}
class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}
public class PalindromeCheckerApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = sc.nextLine();
        System.out.println("Choose Strategy: 1.Stack 2.Deque");
        int choice = sc.nextInt();
        PalindromeStrategy strategy;
        if (choice == 1) {
            strategy = new StackStrategy();
        } else {
            strategy = new DequeStrategy();
        }
        boolean result = strategy.checkPalindrome(input);
        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        sc.close();
    }
}