package graphs.bfs;

import graphs.Node;

import java.util.*;

public class LevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for(int i=0; i<size;i++)
            {
                Node node= queue.poll();
                level.add(node.val);
                for( Node temp : node.neighbors)
                {
                    queue.offer(temp);
                }
            }
            result.add(level);

        }

        return result;


    }

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

        n0.addEdge(n1);
        n0.addEdge(n2);
        n1.addEdge(n3);n1.addEdge(n4);
        n2.addEdge(n5);
        n5.addEdge(n6);

        System.out.println(new LevelOrderTraversal().levelOrder(n0));
    }
}
