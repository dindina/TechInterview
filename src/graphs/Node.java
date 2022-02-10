package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;

    }

    public void addEdge(Node to) {
        neighbors.add(to);
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

    public String toString()
    {
        return String.valueOf(this.val);
    }

}
