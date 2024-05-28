package tree;

import graphs.bfs.TreeNode;

public class LCATree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);

        System.out.println(new LCATree().lowestCommonAncestor(root,root.right.left,root.right.right));


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root ==null || root==q || root==p)
            return root;

        TreeNode left =     lowestCommonAncestor(root.left,p,q);
        TreeNode right =     lowestCommonAncestor(root.right,p,q);
        if(left==null)
            return right;
        else if( right ==null)
            return left;
        else
            return root;

    }


}
