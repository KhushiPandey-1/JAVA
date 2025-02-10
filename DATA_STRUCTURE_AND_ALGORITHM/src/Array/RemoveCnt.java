package Array;

public class RemoveCnt {
    public class RemoveDigits {
    public static String removeDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0) {
            int digitIndex = findFirstDigit(sb);
            if (digitIndex == -1) break; // No more digits left
            
            // Find closest non-digit character to the left
            int leftIndex = digitIndex - 1;
            while (leftIndex >= 0 && Character.isDigit(sb.charAt(leftIndex))) {
                leftIndex--;
            }
            
            // Remove the digit
            sb.deleteCharAt(digitIndex);
            
            // Remove the closest non-digit character if found
            if (leftIndex >= 0) {
                sb.deleteCharAt(leftIndex);
            }
        }
        return sb.toString();
    }
    
    private static int findFirstDigit(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(removeDigits("abc")); // Output: "abc"
        System.out.println(removeDigits("cb34")); // Output: ""
        System.out.println(removeDigits("a1b2c3d4")); // Output: ""
        System.out.println(removeDigits("x9yz8w7v6")); // Output: ""
    }
}

}
