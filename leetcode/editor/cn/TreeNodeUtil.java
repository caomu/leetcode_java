import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author : CAOMU
 * @version : 1.0
 * @project : leetcode_java
 * @since : 2021/02/10, 水, 18:06
 */
public class TreeNodeUtil {
    public static TreeNode arrayToTreeNode(String s) {
        List<Integer> array = Arrays.stream(s.substring(s.indexOf("[") + 1, s.lastIndexOf("]")).split(",")).map(i ->
                i.equals("null") ? null : Integer.valueOf(i)
        ).collect(Collectors.toList());
        return arrayToTreeNode(array);
    }

    public static TreeNode arrayToTreeNode(List<Integer> array) {
        if (array.isEmpty()) {
            return null;
        }
        TreeNode root = new TreeNode(array.get(0));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isLeft = true;
        for (int i = 1; i < array.size(); i++) {
            TreeNode node = queue.peek();
            if (isLeft) {
                if (array.get(i) != null) {
                    node.left = new TreeNode(array.get(i));
                    queue.offer(node.left);
                }
                isLeft = false;
            } else {
                if (array.get(i) != null) {
                    node.right = new TreeNode(array.get(i));
                    queue.offer(node.right);
                }
                queue.poll();
                isLeft = true;
            }
        }
        return root;
    }

}
