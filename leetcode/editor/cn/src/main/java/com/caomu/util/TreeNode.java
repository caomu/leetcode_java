package com.caomu.util;

/**
 * @author : CAOMU
 * @version : 1.0
 * @project : leetcode_java
 * @since : 2021/02/10, 水, 18:07
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
//        TreeNodeUtils.prettyPrintTree(this);
        return TreeNodeUtils.treeNodeToString(this);
    }
}
