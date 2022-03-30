package tree;

import graphs.bfs.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
public class LevelOrderTraversal {

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

        System.out.println(new LevelOrderTraversal().levelOrderTraversal(node));

        //dfs_inorder(node);
    }

    public List<List<Integer>> levelOrderTraversal(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if(root ==null)
            return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            List<Integer> levelList = new ArrayList<>();
            result.add(levelList);
            int level_length = queue.size();
            for(int i=0; i< level_length; i++) {
                TreeNode node = queue.poll();
                levelList.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
        }

        return result;

    }

}
