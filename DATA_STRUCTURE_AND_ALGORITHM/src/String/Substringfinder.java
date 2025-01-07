/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package String;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khushi pandey
 */
public class Substringfinder {

    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break; // No need to check further, move to the next word.
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String[] words1 = {"mass", "as", "hero", "superhero"};
        String[] words2 = {"leetcode", "et", "code"};
        String[] words3 = {"blue", "green", "bu"};

        System.out.println(stringMatching(words1)); // Output: ["as", "hero"]
        System.out.println(stringMatching(words2)); // Output: ["et", "code"]
        System.out.println(stringMatching(words3)); // Output: []
    }
    
}
