package breadthfirstsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReverseLevelOrder {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> result = reverse_traverse(root);
        System.out.println("Level order traversal: " + result);
    }

    private static List<List<Integer>> reverse_traverse(TreeNode root) {

        if(root == null)
            return null;
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(! queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0; i< size ; i++)
            {
               TreeNode current = queue.poll();
               levelList.add(current.getVal());
               if(current.getLeft()!=null)
                   queue.offer(current.getLeft());
                if(current.getRight()!=null)
                    queue.offer(current.getRight());
            }
            result.add(0,levelList);
            //result.add(levelList);

        }
        return  result;
    }
}
