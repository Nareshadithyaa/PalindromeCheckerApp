import java.util.*;
public class PalindromeCheckerApp {
    static boolean stackMethod(String input) {
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
    static boolean dequeMethod(String input) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = sc.nextLine();
        long start1 = System.nanoTime();
        boolean r1 = stackMethod(input);
        long end1 = System.nanoTime();
        long start2 = System.nanoTime();
        boolean r2 = dequeMethod(input);
        long end2 = System.nanoTime();

        System.out.println("Stack Result: " + r1);
        System.out.println("Stack Time: " + (end1 - start1));
        System.out.println("Deque Result: " + r2);
        System.out.println("Deque Time: " + (end2 - start2));
        sc.close();
    }
}