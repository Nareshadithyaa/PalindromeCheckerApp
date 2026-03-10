import java.util.Scanner;
class PalindromeChecker {
    public boolean checkPalindrome(String input) {
        char[] stack = new char[input.length()];
        int top = -1;
        for (int i = 0; i < input.length(); i++) {
            stack[++top] = input.charAt(i);
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = stack[top--];
            if (input.charAt(i) != ch) {
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
        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(input);
        if (result) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        sc.close();
    }
}