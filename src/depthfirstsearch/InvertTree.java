package depthfirstsearch;

import breadthfirstsearch.TreeNode;


public class InvertTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(51);
        //List<List<Integer>> result = traverse(root);
        inorder(root);
        TreeNode newTree = invertTree(root);
        System.out.println();
        inorder(newTree);
    }

    public static void inorder(TreeNode node)
    {
        if(node == null)
            return;

        System.out.print(node.getValue() + ",");
        inorder(node.left);
        inorder(node.right);

    }

    private static TreeNode invertTree(final TreeNode node) {
        if(node == null)
            return null;

        TreeNode newTree = new TreeNode(node.value);
        newTree.left = invertTree(node.right);
        newTree.right = invertTree(node.left);
        return newTree;
    }

}
