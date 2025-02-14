package Array;

public class Best_SightSeeing_Pairs {
public int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0; // To store the maximum score
        int maxSoFar = values[0]; // Track the maximum value of values[i] + i so far
        
        for (int j = 1; j < values.length; j++) {
            // Calculate the score for the pair (i, j)
            maxScore = Math.max(maxScore, maxSoFar + values[j] - j);
            // Update maxSoFar for the next iteration
            maxSoFar = Math.max(maxSoFar, values[j] + j);
        }
        
        return maxScore;
    }
    
    public static void main(String[] args) {
       Best_SightSeeing_Pairs sol = new Best_SightSeeing_Pairs();
        
        int[] values1 = {8, 1, 5, 2, 6};
        System.out.println(sol.maxScoreSightseeingPair(values1)); // Output: 11
        
        int[] values2 = {1, 2};
        System.out.println(sol.maxScoreSightseeingPair(values2)); // Output: 2
    }
    
}
