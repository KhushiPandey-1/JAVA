package String;

public class StringSwapping {
     public static boolean canMakeEqualWithOneSwap(String s1, String s2) {
        if (s1.equals(s2)) return true; // If already equal, no swap needed

        int n = s1.length();
        int first = -1, second = -1; // To store the indices where s1 and s2 differ

        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (first == -1) {
                    first = i; // First differing index
                } else if (second == -1) {
                    second = i; // Second differing index
                } else {
                    return false; // More than 2 differences, swap not possible
                }
            }
        }

        if (second == -1) return false; // Only one difference, swap not possible

        // Swap must make s1 equal to s2
        return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }

    public static void main(String[] args) {
        System.out.println(canMakeEqualWithOneSwap("bank", "kanb")); // true
        System.out.println(canMakeEqualWithOneSwap("attack", "defend")); // false
        System.out.println(canMakeEqualWithOneSwap("kelb", "kelb")); // true
    }
}
