/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Array_List;

import java.util.ArrayList;
import java.util.List;

public class Course_Schedule_IV {
 public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        // Initialize a boolean matrix to store direct and indirect prerequisites
        boolean[][] isPrerequisite = new boolean[numCourses][numCourses];

        // Fill the matrix with the direct prerequisites
        for (int[] prereq : prerequisites) {
            isPrerequisite[prereq[0]][prereq[1]] = true;
        }

        // Use Floyd-Warshall algorithm to compute the transitive closure
        for (int k = 0; k < numCourses; k++) {
            for (int i = 0; i < numCourses; i++) {
                for (int j = 0; j < numCourses; j++) {
                    if (isPrerequisite[i][k] && isPrerequisite[k][j]) {
                        isPrerequisite[i][j] = true;
                    }
                }
            }
        }

        // Answer the queries based on the computed matrix
        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            result.add(isPrerequisite[query[0]][query[1]]);
        }

        return result;
    }

    public static void main(String[] args) {
        Course_Schedule_IV solver = new Course_Schedule_IV();

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        int[][] queries1 = {{0, 1}, {1, 0}};
        System.out.println(solver.checkIfPrerequisite(numCourses1, prerequisites1, queries1)); // Output: [false, true]

        int numCourses2 = 2;
        int[][] prerequisites2 = {};
        int[][] queries2 = {{1, 0}, {0, 1}};
        System.out.println(solver.checkIfPrerequisite(numCourses2, prerequisites2, queries2)); // Output: [false, false]

        int numCourses3 = 3;
        int[][] prerequisites3 = {{1, 2}, {1, 0}, {2, 0}};
        int[][] queries3 = {{1, 0}, {1, 2}};
        System.out.println(solver.checkIfPrerequisite(numCourses3, prerequisites3, queries3)); // Output: [true, true]
    }
    
}
