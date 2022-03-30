package binarysearch;

import graphs.bfs.TreeNode;

public class BSTSearch {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        System.out.println(new BSTSearch().find(root,2.3));

    }

    private int find(TreeNode node, double target) {
        if(node ==null) return -1;
        int closest = node.val;
        while(node!=null)
        {
            int val = node.val;

            if(Math.abs(val-target) < Math.abs(closest-target))
            {
                closest=val;
            }
            if(target > node.val)
            {
                node = node.right;
            }
            else
                node = node.left;
        }
        return closest;
    }
}
