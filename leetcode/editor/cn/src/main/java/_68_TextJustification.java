//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to","explain
//",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 
// 👍 123 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class _68_TextJustification {

    private static final Logger logger = Logger.getLogger(_68_TextJustification.class.toString());

    public static void main(String[] args) {
        long startTimeMillis = System.currentTimeMillis();
        Solution solution = new _68_TextJustification().new Solution();

        // assert solution == ;
        logger.warning(solution.fullJustify(new String[]{"This", "is", "an", "example", "of",
                "text", "justification."}, 16).toString());
        logger.warning(solution.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"},
                16).toString());

        logger.warning(solution.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough",
                        "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"},
                20).toString());

        logger.info("time cost: [" + (System.currentTimeMillis() - startTimeMillis) + "] ms");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> fullJustify = new ArrayList<>();
            int i = 0;
            int width = maxWidth;
            int start = 0;
            int end = 0;
            while (i < words.length) {
                String word = words[i];
                width -= word.length();
                if (width > 0) {
                    end = i;
                    width--;
                    if (width == 0 || i == words.length - 1) {
                        fullJustify.add(this.generateJustify(words, start, end, maxWidth));
                        width = maxWidth;
                        start = i + 1;
                    }
                    i++;
                } else if (width == 0) {
                    end = i;
                    fullJustify.add(this.generateJustify(words, start, end, maxWidth));
                    width = maxWidth;
                    i++;
                    start = i;
                } else {
                    fullJustify.add(this.generateJustify(words, start, end, maxWidth));
                    start = i;
                    width = maxWidth;
                }
            }
            return fullJustify;
        }

        private String generateJustify(String[] words, int start, int end, int maxWidth) {
            int spaceSlotCnt = end - start;
            int width = maxWidth;
            for (int i = start; i <= end; i++) {
                width -= words[i].length();
            }
            int spaceWidth = spaceSlotCnt > 0 ? (width / spaceSlotCnt) : 0;
            int remainderSpaceCnt = spaceSlotCnt > 0 ? (width % spaceSlotCnt) : 0;
            StringBuilder sb = new StringBuilder();
            for (int i = start; i < end; i++) {
                sb.append(words[i]);
                if (end < words.length - 1) {
                    IntStream.range(0, spaceWidth).forEach(s -> sb.append(' '));
                    if (remainderSpaceCnt > 0) {
                        sb.append(' ');
                        remainderSpaceCnt--;
                    }
                } else {
                    sb.append(' ');
                }
            }
            sb.append(words[end]);
            IntStream.range(sb.length(), maxWidth).forEach(s -> sb.append(' '));
            return sb.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
