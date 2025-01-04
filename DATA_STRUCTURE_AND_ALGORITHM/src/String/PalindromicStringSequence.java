/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package String;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author khushi pandey
 */
public class PalindromicStringSequence {

     public static int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[] leftCount = new int[26]; // Count of characters to the left
        int[] rightCount = new int[26]; // Count of characters to the right

        // Initialize rightCount with frequencies of all characters in the string
        for (char c : s.toCharArray()) {
            rightCount[c - 'a']++;
        }

        Set<String> uniquePalindromes = new HashSet<>();

        // Iterate through the string, treating each character as the middle character
        for (int i = 0; i < n; i++) {
            char middleChar = s.charAt(i);
            rightCount[middleChar - 'a']--; // Remove the middle character from rightCount

            // For each character, check if it can form a palindrome with the middleChar
            for (int c = 0; c < 26; c++) {
                if (leftCount[c] > 0 && rightCount[c] > 0) {
                    // Form the palindrome and add it to the set
                    String palindrome = "" + (char) (c + 'a') + middleChar + (char) (c + 'a');
                    uniquePalindromes.add(palindrome);
                }
            }

            // Update leftCount for the middle character
            leftCount[middleChar - 'a']++;
        }

        return uniquePalindromes.size();
    }

    public static void main(String[] args) {
        String s1 = "aabca";
        String s2 = "adc";
        String s3 = "bbcbaba";
        String s4 = "tnapzbjeznakaxowyeqefiwxpoxswedvabnyyuihjenxmpzxyyokldoijgvekjxxvxsvcnrinonkofilfyllcacophzuusnbyhpxoqtnbhezbvwtnejsxcyxsbffqaxfryagvvzzvjvbdgrwkowqfwthrkkhxvmpqkslrfqcxmeiygryknhocdvwyomdzmcfvetugpldpbytefioyiyxjfqkdhbefrlwbgnodzbrknqeyjdcgjovtdfqobqxyqhqltrpizlxdnjdqezzwjaudlsofkvjykktlkjiksffefwrqxotkqfdcqhvuqbfoejnelskrhtoekufkmwdyiyptwrucawbwixfdfvjxpvmshcoxdknqeomzrxzrdltdjjearvypexzyoxzxbdhkdzurzisycpuaxkewehnxmxbghllbttlcodzqtajxjarsiuwukiysomgxxcrincvucbjeuuwaauwqeqwlwucdsftccyaugbcinmfzpehrwbeaefdozssbeizeqppnhlvtnrzgtbbitqvctsatcpxjrrbgvltmmtizepbjmmywzmxldtkadizqkaurepeckdiakhyofmslyezbybimhgyukaieqrlddhsuwjzblkfigwixzuopifdiqzfpgvmmanctqcmpxygluuhdwbgqivmdhizpnvqypdttfuhukvagdaqtcmxdqoptchhsledydwojisoqqkivahoowbsdbbdnygtziktmonqkevvlcxggqobvfbfgdwnitratmrsobpfpaspjxefnxthonefpiigdhapqnkebutwfotvrxvjbqowgnifeimsslktxmpuryccaabahalsycjqztjhqhaddlyzxdqyuwyecslxshaobrfkjalmeaxrywssfgrzervzbowosusthcjvojxsoiqkpjztdrxrkycgdyqlorxixzdiqtwozuvkvwzonogoytrumivjynvfjktcqlvxeauncdbygkvocvaadeubgykjkshkflpmpbmaiaswjocrqjzmabmxmocssxltgzaiuwfkadwuylnmskyqbpsmxhehicevfmauuxubeirvflsxcdtyoljsansqcmhokbgyjkxxwdeorlzjgbuekogddsabucrpawdxwuemmckqouddnwbnzogtvjfgblwuarykpwtdpuxqtephulabcxdqjkmuxhniiynkwrsypromcminqgghhnixxojhvnkglrtxduhrjoiupeswqfuveqmgmhondpgzvzaeyylzphofblzpmkdejubwhoguyrfxoaiqhlfqogovdoifuvfqyctzhmcvfleefcgippkfccsltjpjohwmunimqvpjspsjufikghgpmaygslukijmsxcgfjzmewqpvvzjtcxcsbcylhwhxfingcbruyyeoyxgvfsbcvedmtsdygawtnanbdbedwvohgecgqtbjalurkoknzyjpsttnknmufpjhpkjjifalqdwutqhgaflmmmwmkbyxxhbmkqlpjnmywmjfxezdshafnakulqhbndlmta";

        System.out.println(countPalindromicSubsequences(s1)); // Output: 3
        System.out.println(countPalindromicSubsequences(s2)); // Output: 0
        System.out.println(countPalindromicSubsequences(s3)); // Output: 4
        System.out.println(countPalindromicSubsequences(s4)); // Expected: Solution within time limits
    }
}
