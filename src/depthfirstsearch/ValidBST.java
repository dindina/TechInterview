package depthfirstsearch;

import graphs.bfs.TreeNode;

import java.io.IOException;


public class ValidBST {


    public static boolean isValidBST(TreeNode root) {

        return isValidBSTUtil(root, Long.MIN_VALUE,Long.MAX_VALUE);


    }

    public static boolean isValidBSTUtil(TreeNode root , long min , long max) {

        if (root == null)
            return true;

        if(root.val<= min || root.val >= max)
            return false;

        return isValidBSTUtil(root.left, min,root.val)
                && isValidBSTUtil(root.right,root.val,max);

    }

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(5);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(17);
        root.right.right.right = new TreeNode(51);

        /*TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);*/


        //System.out.println(root);
        System.out.println(isValidBST(root));

    }
}
