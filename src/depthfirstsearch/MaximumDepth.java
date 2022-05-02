package depthfirstsearch;

import graphs.bfs.TreeNode;


public class MaximumDepth {

    public static int inorder(TreeNode node)
        {
            if(node == null)
                return 0;
            int leftDepth = inorder(node.left);
            int rightDepth = inorder(node.right);

            // Choose the larger one and add the root to it.
            if (leftDepth > rightDepth)
                return leftDepth + 1;
            else
                return rightDepth + 1;
        }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(51);
        //List<List<Integer>> result = traverse(root);
        System.out.println(inorder(root));
    }
}
