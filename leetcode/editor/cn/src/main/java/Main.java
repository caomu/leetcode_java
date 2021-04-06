import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : CAOMU
 * @version : 1.0
 * @project : leetcode_java
 * @since : 2021/03/31, Wed, 23:01
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(similarWords("dog",
                new String[]{"pig", "dog", "good", "proud", "god", "doog", "gip"})));
    }

    private static String[] similarWords(String str, String[] words) {
        boolean[] hashMap = new boolean[26];
        for (char c : str.toCharArray()) {
            hashMap[c - 'a'] = true;
        }
        Set<String> similarWords = new HashSet<>();
        for (String word : words) {
            boolean[] wordHashMap = new boolean[26];
            for (char c : word.toCharArray()) {
                wordHashMap[c - 'a'] = true;
            }
            boolean isSimilar = true;
            for (int i = 0; i < 26; i++) {
                if (hashMap[i] != wordHashMap[i]) {
                    isSimilar = false;
                    break;
                }
            }
            if (isSimilar) {
                similarWords.add(word);
            }
        }
        return similarWords.toArray(new String[0]);
    }
}
