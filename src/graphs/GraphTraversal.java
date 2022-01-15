package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class GraphTraversal {

    public static void main(String[] args) {

        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n0.addEdge(n1);
        n1.addEdge(n0);
        n1.addEdge(n3);
        n1.addEdge(n2);
        n2.addEdge(n1);
        n2.addEdge(n4);
        n3.addEdge(n1);
        n3.addEdge(n4);
        n3.addEdge(n5);
        n4.addEdge(n2);
        n4.addEdge(n3);
        n5.addEdge(n3);

        //System.out.println(bfsTraveral(n0));
        System.out.println(dfsTraveral(n0));

    }

    private static Set dfsTraveral(final Node root) {
        Set<Integer> visited = new HashSet<>();
        dfsTraversalUtil(root,visited);
        return visited;
    }

    private static void dfsTraversalUtil(final Node node, final Set<Integer> visited) {
        System.out.println(node.val);
        visited.add(node.val);
        for(Node current : node.neighbors)
            if(!visited.contains(current.val))
                dfsTraversalUtil(current,visited);
    }

    public static Set bfsTraveral(Node root) {

        Queue<Node> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.offer(root);
        visited.add(root.val);

        while(!q.isEmpty())
        {
            Node currentNode = q.remove();
            System.out.println(currentNode.val);

            for(Node node : currentNode.neighbors)
            {
                if(!visited.contains(node.val))
                {
                    visited.add(node.val);
                    q.offer(node);
                }
            }

        }

        return visited;
    }

}
