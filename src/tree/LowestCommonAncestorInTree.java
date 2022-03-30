package tree;

import graphs.bfs.TreeNode;

public class LowestCommonAncestorInTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        if(root.val == p.val || root.val == q.val) // if val is same , ancestor can be root only

            return root;

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left !=null && right !=null)
            return root;

        if (left !=null) return left ;
        else return right;


    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(51);
        System.out.println(new LowestCommonAncestorInTree().
                lowestCommonAncestor(root,new TreeNode(12), new TreeNode(7)));
        System.out.println(new LowestCommonAncestorInTree().
                lowestCommonAncestor(root,new TreeNode(10), new TreeNode(5)));

    }

}
