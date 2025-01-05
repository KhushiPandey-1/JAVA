/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package String;

/**
 *
 * @author khushi pandey
 */
public class shiftLetterTwo {
public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shiftArr = new int[n + 1]; // Extra space to manage prefix sums

        // Process the shifts array and update shiftArr
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // Forward shift increment or backward shift decrement
            shiftArr[start] += (direction == 1) ? 1 : -1;
            shiftArr[end + 1] += (direction == 1) ? -1 : 1;
        }

        // Compute the prefix sum for net shifts at each index
        int netShift = 0;
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            netShift += shiftArr[i];
            int shiftValue = (netShift % 26 + 26) % 26; // Ensure positive shifts
            result[i] = (char) ('a' + (result[i] - 'a' + shiftValue) % 26);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        // Test case 1
        String s1 = "abc";
        int[][] shifts1 = { {0, 1, 0}, {1, 2, 1}, {0, 2, 1} };
        System.out.println(shiftingLetters(s1, shifts1)); // Output: "ace"

        // Test case 2
        String s2 = "dztz";
        int[][] shifts2 = { {0, 0, 0}, {1, 1, 1} };
        System.out.println(shiftingLetters(s2, shifts2)); // Output: "catz"
    }
    
}
