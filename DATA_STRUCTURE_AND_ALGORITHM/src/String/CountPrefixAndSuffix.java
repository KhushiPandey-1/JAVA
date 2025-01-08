package String;
public class CountPrefixAndSuffix {
public int countPrefixSuffixPairs(String[] words) {
        int cnt = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static boolean isPrefixAndSuffix(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        return len1 <= len2 && str2.startsWith(str1) && str2.endsWith(str1);
    }

    public static void main(String[] args) {
        CountPrefixAndSuffix solution = new CountPrefixAndSuffix();

        // Test cases
        String[] words1 = {"a", "aba", "ababa", "aa"};
        System.out.println(solution.countPrefixSuffixPairs(words1)); // Output: 4

        String[] words2 = {"pa", "papa", "ma", "mama"};
        System.out.println(solution.countPrefixSuffixPairs(words2)); // Output: 2

        String[] words3 = {"abab", "ab"};
        System.out.println(solution.countPrefixSuffixPairs(words3)); // Output: 0
    }
    
}
