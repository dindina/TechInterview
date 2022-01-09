package depthfirstsearch;

import breadthfirstsearch.TreeNode;


public class SameTree {

    static boolean isSameTree(TreeNode tree1, TreeNode tree2) {

        if(tree1 ==null && tree2 == null)
            return true;
        if(tree1 ==null || tree2 == null)
            return false;
        if(tree1.val != tree2.val)
            return false;
        return isSameTree(tree1.left,tree2.left) && isSameTree(tree1.right,tree2.right);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(51);

        TreeNode root1 = new TreeNode(12);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(9);
        root1.right.left = new TreeNode(10);
        root1.right.right = new TreeNode(5);
        root1.right.right.right = new TreeNode(51);
        root1.right.right.right.left = new TreeNode(511);

        System.out.println(isSameTree(root,root1));

    }
}
