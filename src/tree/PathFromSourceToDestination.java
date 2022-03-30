package tree;

import graphs.bfs.TreeNode;

public class PathFromSourceToDestination {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(51);
        //System.out.println(new PathFromSourceToDestination().path(root,9,5));
    }

}
