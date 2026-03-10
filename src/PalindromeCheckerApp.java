import java.util.Scanner;
public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;
        Node(char data) {
            this.data = data;
        }
    }
    static Node head = null;
    static void insert(char c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    static boolean isPalindrome() {
        String original = "";
        String reversed = "";
        Node temp = head;
        while (temp != null) {
            original += temp.data;
            reversed = temp.data + reversed;
            temp = temp.next;
        }
        return original.equals(reversed);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = sc.nextLine();
        for (int i = 0; i < input.length(); i++) {
            insert(input.charAt(i));
        }
        if (isPalindrome()) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        sc.close();
    }
}