package practice.tress;

import graphs.Node;

import java.util.*;
public class BFSTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(22);
        root.right.left = new TreeNode(33);
        root.right.left.right = new TreeNode(34);

        System.out.println(levelOrderTraversal((root)));
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode node)
    {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node);
        List<List<Integer>> result = new ArrayList<>();

        while(!queue.isEmpty())
        {

            int size = queue.size();
            List<Integer> currPath = new ArrayList<>();
            for(int i=0; i<size ;i++)
            {
                TreeNode temp = queue.poll();
                if(temp!=null) {
                    currPath.add(temp.value);
                    if (temp.left != null)
                        queue.offer(temp.left);
                    if (temp.right != null)
                        queue.offer(temp.right);
                }
            }
            result.add(currPath);
        }

        return result;

    }
}
