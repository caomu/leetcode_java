//如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 
//个字符。） 
//
// 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 patt
//ern 匹配时， answer[i] 才为 true，否则为 false。 
//
// 
//
// 示例 1： 
//
// 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FB"
//输出：[true,false,true,true,false]
//示例：
//"FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
//"FootBall" 可以这样生成："F" + "oot" + "B" + "all".
//"FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer". 
//
// 示例 2： 
//
// 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FoBa"
//输出：[true,false,true,false,false]
//解释：
//"FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
//"FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
// 
//
// 示例 3： 
//
// 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"]
//, pattern = "FoBaT"
//输入：[false,true,false,false,false]
//解释： 
//"FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 100 
// 1 <= queries[i].length <= 100 
// 1 <= pattern.length <= 100 
// 所有字符串都仅由大写和小写英文字母组成。 
// 
// Related Topics 字典树 字符串 
// 👍 23 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class _1023_CamelcaseMatching {
    public static void main(String[] args) {
        Solution solution = new _1023_CamelcaseMatching().new Solution();
        System.out.println(solution.camelMatch(new String[]{"aksvbjLiknuTzqon", "ksvjLimflkpnTzqn", "mmkasvjLiknTxzqn", "ksvjLiurknTzzqbn", "ksvsjLctikgnTzqn", "knzsvzjLiknTszqn"},
                "ksvjLiknTzqn"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> result = new ArrayList<>();
            List<List<Character>> patternWords = this.splitByUpperCharacter(pattern, false);
            loop:
            for (String query : queries) {
                List<List<Character>> queryWords = this.splitByUpperCharacter(query, Character.isUpperCase(pattern.charAt(0)));
                if (queryWords.size() != patternWords.size()) {
                    result.add(false);
                    continue loop;
                }
                for (int i = 0; i < queryWords.size(); i++) {
                    List<Character> queryWord = queryWords.get(i);
                    List<Character> patternWord = patternWords.get(i);
                    int p = 0;
                    int q = 0;
                    while (p < patternWord.size() && q < queryWord.size()) {
                        if (Objects.equals(queryWord.get(q), patternWord.get(p))) {
                            p++;
                        }
                        q++;
                    }
                    if (p < patternWord.size()) {
                        result.add(false);
                        continue loop;
                    }
                }
                result.add(true);
            }
            return result;
        }

        List<List<Character>> splitByUpperCharacter(String str, boolean needStartUppercase) {
            List<List<Character>> result = new ArrayList<>();
            List<Character> word = new ArrayList<>();
            for (char c : str.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    if (!word.isEmpty()) {
                        result.add(word);
                    }
                    word = new ArrayList<>();
                    word.add(c);
                } else if (!needStartUppercase || !word.isEmpty()) {
                    word.add(c);
                }

            }
            if (!word.isEmpty()) {
                result.add(word);
            }
            return result;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}