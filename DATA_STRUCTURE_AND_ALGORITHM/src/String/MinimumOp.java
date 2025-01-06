/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package String;

import java.util.Arrays;

/**
 *
 * @author khushi pandey
 */
public class MinimumOp {

  public static void main(String[] args) {
        String boxes1 = "110";
        System.out.println(Arrays.toString(minOperations(boxes1))); // Output: [1, 1, 3]

        String boxes2 = "001011";
        System.out.println(Arrays.toString(minOperations(boxes2))); // Output: [11, 8, 5, 4, 3, 4]
    }

    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];

        // Left to right pass
        int count = 0; // Count of balls seen so far
        int operations = 0; // Number of operations for current pass
        for (int i = 0; i < n; i++) {
            answer[i] += operations;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            operations += count;
        }

        // Right to left pass
        count = 0;
        operations = 0;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations;
            count += boxes.charAt(i) == '1' ? 1 : 0;
            operations += count;
        }

        return answer;
    }
}
