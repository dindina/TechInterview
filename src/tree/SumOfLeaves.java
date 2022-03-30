package tree;

import graphs.bfs.TreeNode;

public class SumOfLeaves {


    public int sumOfAll(TreeNode node)
    {
        if (node ==null) return 0;

        if(node.left ==null && node.right ==null)
        {
            return node.val;
        }

        return sumOfAll(node.left) + sumOfAll(node.right);
    }
    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        System.out.println(new SumOfLeaves().sumOfAll(root));
    }
}
