package tree;

import graphs.bfs.TreeNode;

public class PrintLeaves {

    public void printLeaves(TreeNode node)
    {
        if(node == null)
            return;

        if(node.right ==null && node.left == null)
            System.out.println(node.val);
        printLeaves(node.left);
        printLeaves(node.right);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        new PrintLeaves().printLeaves(root);
    }
}
