package tree;

import breadthfirstsearch.TreeNode;

public class ValidBST {
    public boolean dfs_helper(TreeNode root, int min, int max)
    {
        if(root ==null) return true;
        if(root.val <= min || root.val >= max) return true;

        return dfs_helper(root.left,min,root.val) && dfs_helper(root.right,root.val,max);

    }

    public boolean isValidBST(TreeNode root) {
        if (root ==null)
            return false;
        return dfs_helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        /*node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(5);
        */
        node.right = new TreeNode(8);
        /*node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);
        */

        System.out.println(new ValidBST().isValidBST(node));
    }

}
