import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import graphs.Node;


public class practice {

    public static void main(String[] args) {

        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        n0.addEdge(n1);
        n1.addEdge(n0);n1.addEdge(n3);n1.addEdge(n2);
        n2.addEdge(n1);n2.addEdge(n4);
        n3.addEdge(n1);n3.addEdge(n4);n3.addEdge(n5);
        n4.addEdge(n2);n4.addEdge(n3);
        n5.addEdge(n3);

        System.out.println(bfs(n0));

        System.out.println(dfs(n0));

    }
    public static Set<Integer> dfs(Node node)
    {
        Set<Integer> visited = new HashSet<>();
        dfsUtil(node,visited);
        return visited;
    }

    private static void dfsUtil( Node node,  Set<Integer> visited) {
        visited.add(node.val);
        for(Node neighbor : node.neighbors)
        {
            if(!visited.contains(neighbor.val))
                dfsUtil(neighbor,visited);
        }

    }

    public static Set<Integer> bfs(Node node)
    {
        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(node);
        visited.add(node.val);
        while(!queue.isEmpty())
        {
            Node current = queue.poll();

            List<Node> neighbours = current.neighbors;
            for(Node temp : neighbours)
            {
                if(!visited.contains(temp.val))
                {
                    visited.add(temp.val);
                    queue.offer(temp);
                }
            }

        }
        return visited;
    }

}
