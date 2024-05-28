package tree;

import graphs.bfs.TreeNode;

/*
https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertTree {
    public static void main(String[] args) {


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(new InvertTree().invertTree(root));
    }


    public TreeNode invertBTree(TreeNode root) {

        if(root == null) {
            return null;
        }

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        invertBTree(root.right);
        invertBTree(root.left);

        return  root;

    }

    public TreeNode invertTree(TreeNode root) {

        return  invertBTree(root);
    }
    public TreeNode invertTreeMine(TreeNode root) {
        TreeNode result =null;
        if(root!=null){
            result = new TreeNode(root.val);
            result.val = root.val;
            helper(root,result);

        }
        return result;

    }

    public void helper(TreeNode node,TreeNode result)
    {
        if(node ==null)
            return;

        if(node.right !=null)
        {
            result.left =new TreeNode(node.right.val);
        }
        if(node.left !=null)
        {
            result.right =new TreeNode(node.left.val);
        }
        helper(node.left,result.right);
        helper(node.right,result.left);

    }


}
