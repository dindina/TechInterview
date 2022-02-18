package tree;

import apple.laf.JRSUIUtils;
import breadthfirstsearch.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*

https://leetcode.com/problems/cousins-in-binary-tree/
Given the root of a binary tree with unique values and the values of two different nodes of the tree x and y, return true if the nodes corresponding to the values x and y in the tree are cousins, or false otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

Note that in a binary tree, the root node is at the depth 0, and children of each depth k node are at the depth k + 1.


Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

 */
public class CousinsInATree {

    public boolean isCousins(TreeNode root, int x, int y) {

        traverse(root,x,y);
        return true;
    }

    public boolean traverse(TreeNode node, int x , int y )
    {
       Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int level=0;
        Map<Integer,Integer> levelMap = new HashMap<>();
        Map<Integer,Integer> parentMap = new HashMap<>();
        levelMap.put(node.val,0);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();

            if(temp.right!=null) {
                parentMap.put(temp.right.val,temp.val);
                levelMap.put(temp.right.val,levelMap.get(temp.val)+1);
                queue.offer(temp.right);
            }
            if(temp.left!=null) {
                parentMap.put(temp.left.val,temp.val);
                levelMap.put(temp.left.val,levelMap.get(temp.val)+1);
                queue.offer(temp.left);
            }


        }

        System.out.println("level " + level);
        System.out.println("parent Map " + parentMap);
        System.out.println("level Map " + levelMap);
        if( (levelMap.get(x) == levelMap.get(y) ) && (parentMap.get(x) != parentMap.get(y)))
            return true;
        return false;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(new CousinsInATree().isCousins(root,4,5));

    }
}
