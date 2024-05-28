package tree;

import graphs.bfs.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(isSymmetric(root));

    }


    public static boolean isSymmetric(TreeNode root)
    {
        return helper(root.left,root.right);
    }

    public static boolean helper(TreeNode left , TreeNode right)
    {
        if(left==null && right ==null)
            return true;

        if(left==null || right ==null)
            return false;

        if(left.val != right.val)
            return false;

        return helper(left.left,right.right) && helper(left.right,right.left);
    }
}
