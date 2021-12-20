package breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrderTraversal {


    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = traverse(root);
        System.out.println("Level order traversal: " + result);

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(0,2);
        list.add(3);
        System.out.println(list);

    }

    private static List<List<Integer>> traverse(TreeNode root) {

        if(root == null)
            return null;
        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for(int i=0 ; i< size ; i++) {
                TreeNode current = queue.poll();

                assert current != null;
                if(leftToRight)
                    currentLevel.add(current.getValue());
                else
                    currentLevel.add(0,current.getValue());
                    if (current.getLeft() != null)
                        queue.offer(current.getLeft());
                    if (current.getRight() != null)
                        queue.offer(current.getRight());

            }

            result.add(currentLevel);
            leftToRight=!leftToRight;
            // [[12], [7, 1], [9, 10, 5]]

        }

        return result;
    }
}

