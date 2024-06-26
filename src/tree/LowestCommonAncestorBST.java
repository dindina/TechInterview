package tree;

import graphs.bfs.TreeNode;

/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
'
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”



Example 1:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:


Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 */
public class LowestCommonAncestorBST {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(6);
        node.left = new TreeNode(2);
        node.left.left = new TreeNode(0);
        node.left.right = new TreeNode(4);
        node.left.right.left = new TreeNode(3);
        node.left.right.right = new TreeNode(5);

        node.right = new TreeNode(8);
        node.right.left = new TreeNode(7);
        node.right.right = new TreeNode(9);

        System.out.println(new LowestCommonAncestorBST().lowestCommonAncestor(node,
                new TreeNode(2),new TreeNode(8)));

        //dfs_inorder(node);
    }

    private static void dfs_inorder(TreeNode node) {
        if(node == null) return;
        dfs_inorder(node.left);
        System.out.println(node.val);
        dfs_inorder(node.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;

        // check if both p and q are in left of root
        if(p.val < root.val && q.val < root.val)
        {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if (p.val > root.val && q.val > root.val)
        {
            return lowestCommonAncestor(root.right,p,q);
        }
        else
            return root;

    }




}
