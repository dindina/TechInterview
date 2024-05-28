package tree;

import graphs.bfs.TreeNode;

public class SumOfLeftLeaves {

    public int total=0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left= new TreeNode(9);
        root.right= new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(7);
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(root));
    }
    public void helper(TreeNode root, boolean leftFlag)
    {
        if(root ==null)
            return ;

        if(leftFlag && root.left==null & root.right==null)
            total+=root.val;

        helper(root.left,true); helper(root.right,false);
    }
    public int sumOfLeftLeaves(TreeNode root) {

        if(root.left==null && root.right==null)
            return 0;
        helper(root,false);

        return total;

    }
}
