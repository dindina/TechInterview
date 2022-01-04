package breadthfirstsearch;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*Given a binary tree, populate an array to represent its level-by-level
 traversal. You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */
public class FindAllNodesInALevel {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = traverse(root);
        System.out.println("Level order traversal: " + result);

        List<List<Integer>> result1 = traverse_practice1(root);
        System.out.println("Level order traversal: " + result1);
    }

    private static List<List<Integer>> traverse(TreeNode root) {

        if(root == null)
            return null;
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0 ; i< size ; i++) {
                TreeNode current = queue.poll();

                currentLevel.add(current.getValue());

                    if (current.getLeft() != null)
                        queue.offer(current.getLeft());
                    if (current.getRight() != null)
                        queue.offer(current.getRight());

            }
            result.add(0,currentLevel);

        }

        return result;
    }

    private static List<List<Integer>> traverse_practice1(TreeNode root) {

        if(root == null)
            return null;
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0; i< size;i++)
            {
                TreeNode item = queue.poll();
                currentLevel.add(item.getValue());
                if(item.getRight() != null)
                {
                    queue.offer(item.getRight());

                }
                if(item.getLeft() != null)
                {
                    queue.offer(item.getLeft());

                }

            }
            result.add(currentLevel);


        }
        return  result;



    }



}
