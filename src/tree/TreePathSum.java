package tree;

import breadthfirstsearch.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/path-sum/
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.
Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.

 */
public class TreePathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null)
            return false;
        targetSum = targetSum-root.val;
        if(root.left ==null && root.right ==null)
        {
            if (targetSum ==0)
                return true;
            else
                return false;
        }
        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);


    }

    public List<List<Integer>> allPathInTree(TreeNode node)
    {
        if(node == null)
        {
            return null;
        }
        List<List<Integer>> allPath = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path(node,path,allPath);
        System.out.println("all paths " + allPath);
        return allPath;

    }

    public void path(TreeNode node, List<Integer> path, List<List<Integer>> allPaths)
    {
        /*if(node == null) {
            return;
        }

        path.add(node.val);
        if(node.right == null && node.left ==null )
        {
            allPaths.add(new ArrayList<>(path));
            System.out.println("new path " + path);
        }
        else {
            path(node.left, path, allPaths);
            path(node.right, path, allPaths);
        }
        path.remove(node.val);*/

        if (node == null) {
            return ;
        }
        path.add(node.val);
        if(node.right == null && node.left ==null )
        {
            allPaths.add(new ArrayList<>(path));

        } else {
        path(node.left ,  path,allPaths);
        path(node.right,  path,allPaths);
        }
        path.remove(node.val);
    }


    public static void paths(TreeNode root, String path, List<String> paths){
        if(root == null){
            return;
        }

        path=path+(path.isEmpty()? "" : "-->")+root.val;

        if(root.left == null && root.right == null){
            System.out.println("path > "+path);
            paths.add(path);
            return;
        }

        paths(root.left, path, paths);
        paths(root.right, path, paths);
    }





    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        //System.out.println(new TreePathSum().hasPathSum(root,7));
        System.out.println(new TreePathSum().allPathInTree(root));
        //new TreePathSum().paths(root,new String(),new ArrayList<>());

    }
    
}
