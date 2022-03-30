package tree;

import graphs.bfs.TreeNode;

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;

        if(p.val!=q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
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

        System.out.println(new SameTree().isSameTree(root1,root));
    }


}
