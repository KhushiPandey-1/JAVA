package String;
public class ValidParenthesString {
public boolean canBeValid(String s, String locked) {
        int n = s.length();

        // If the length of the string is odd, it cannot be valid
        if (n % 2 != 0) {
            return false;
        }

        // Left to right pass: Check if there are enough '(' to match ')' or replaceable slots
        int openCount = 0, freeCount = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                freeCount++;
            } else if (s.charAt(i) == '(') {
                openCount++;
            } else {
                if (openCount > 0) {
                    openCount--; // Use an open parenthesis
                } else if (freeCount > 0) {
                    freeCount--; // Use a free slot
                } else {
                    return false; // No way to balance
                }
            }
        }

        // Right to left pass: Check if there are enough ')' to match '(' or replaceable slots
        int closeCount = 0;
        freeCount = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                freeCount++;
            } else if (s.charAt(i) == ')') {
                closeCount++;
            } else {
                if (closeCount > 0) {
                    closeCount--; // Use a close parenthesis
                } else if (freeCount > 0) {
                    freeCount--; // Use a free slot
                } else {
                    return false; // No way to balance
                }
            }
        }

        // If both passes succeeded, the string can be valid
        return true;
    }

    public static void main(String[] args) {
        ValidParenthesString solution = new ValidParenthesString();

        // Test cases
        System.out.println(solution.canBeValid("))()))", "010100")); // Output: true
        System.out.println(solution.canBeValid("()()", "0000"));     // Output: true
        System.out.println(solution.canBeValid(")", "0"));           // Output: false
    }
    
}
