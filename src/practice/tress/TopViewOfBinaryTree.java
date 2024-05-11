package practice.tress;




import tree.Pair;

import java.util.*;

public class TopViewOfBinaryTree {

    /**
     * This uses a vertext concept to the view the nodes of the tree
     * https://www.youtube.com/watch?v=Et9OCDNvJ78
     * @param args
     */
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);

        root.right.right = new TreeNode(7);

        System.out.println(topView(root));

    }

    public static List<Integer> topView(TreeNode node)
    {
        if(node==null) return null;
        List<Integer> result = new ArrayList<>();
        Queue<Pair<TreeNode,Integer>> queue = new LinkedList<>();
        Map<Integer,TreeNode> vertexNodeMap = new TreeMap<>(); // map of the vertex to the node

        queue.offer(new Pair(node,0)); // Pair is the node and the vertex

        while(!queue.isEmpty())
        {
            Pair<TreeNode,Integer> pair = queue.poll();

            int vertex =  pair.getValue();
            TreeNode currnode = pair.getKey();


            if(!vertexNodeMap.containsKey(vertex))
            {
                vertexNodeMap.put(vertex,currnode);
            }

            TreeNode left =  currnode.left;
            if(left!=null)
                queue.offer(new Pair(left,vertex-1));

            TreeNode right =  currnode.right;
            if(right!=null)
                queue.offer(new Pair(right,vertex+1));

        }

        System.out.println(vertexNodeMap.entrySet());
        for(Map.Entry<Integer,TreeNode> entry : vertexNodeMap.entrySet())
        {
            result.add(entry.getValue().value);
        }

        return result;


    }
}
