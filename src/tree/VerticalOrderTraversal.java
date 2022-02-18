package tree;

/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.
Input: root = [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]

Input: root = [3,9,8,4,0,1,7]
Output: [[4],[9],[3,0,1],[8],[7]]
 */

import breadthfirstsearch.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        bfs(root);

        return null;
    }

    void bfs(TreeNode node)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        Map<Integer,List<TreeNode>> columnMap = new HashMap<>();
        int column =0;
        List<TreeNode> initial = new ArrayList<>();
        initial.add(node);
        columnMap.put(column,initial);
        while(!queue.isEmpty())
        {
            TreeNode temp = queue.poll();

            System.out.println(temp.val);

            /*if (temp != null) {
                if (!columnMap.containsKey(column)) {
                    columnMap.put(column, new ArrayList<TreeNode>());
                }
                columnMap.get(column).add(temp);
            }*/

            // visit the left and right
            if(temp.left!=null) {
                List<TreeNode> existing = columnMap.get(column-1);
                if(existing !=null && !existing.isEmpty()) {
                    existing.add(temp.left);
                    columnMap.put(column - 1, existing);
                }
                else
                {
                    List<TreeNode> initial1 = new ArrayList<>();
                    initial1.add(temp.left);
                    columnMap.put(column - 1, initial1);
                }

                queue.offer(temp.left);
            }

            if(temp.right!=null) {
                List<TreeNode> existing = columnMap.get(column+1);
                if(existing !=null && !existing.isEmpty()) {
                    existing.add(temp.right);
                    columnMap.put(column + 1, existing);
                }
                else
                {
                    List<TreeNode> initial2 = new ArrayList<>();
                    initial2.add(temp.right);
                    columnMap.put(column + 1, initial2);
                }

                queue.offer(temp.right);
            }

        }
        System.out.println("columnMap " + columnMap);

    }

    public List<List<Integer>> verticalOrder1(TreeNode root) {
        List<List<Integer>> output = new ArrayList();
        if (root == null) {
            return output;
        }

        Map<Integer, ArrayList> columnTable = new HashMap();
        Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque();
        int column = 0;
        queue.offer(new Pair(root, column));

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            root = p.getKey();
            column = p.getValue();

            if (root != null) {
                if (!columnTable.containsKey(column)) {
                    columnTable.put(column, new ArrayList<Integer>());
                }
                columnTable.get(column).add(root.val);

                queue.offer(new Pair(root.left, column - 1));
                queue.offer(new Pair(root.right, column + 1));
            }
        }

        System.out.println("columnTable " + columnTable);

        List<Integer> sortedKeys = new ArrayList<Integer>(columnTable.keySet());
        Collections.sort(sortedKeys);
        for(int k : sortedKeys) {
            output.add(columnTable.get(k));
        }

        return output;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.left.right = new TreeNode(151);
        System.out.println(new VerticalOrderTraversal().verticalOrder(root));

        System.out.println(new VerticalOrderTraversal().verticalOrder1(root));
    }
}
