package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class CloneGraph {
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

        System.out.println("original");
        Node.bfsTraveral(n0);

        Node clone = cloneGraph(n0);

        System.out.println("after cloned");
        Node.bfsTraveral(clone);


    }
    static Map<Node,Node> map = new HashMap<>();

    public static Node cloneGraph(Node node) {

        if( node == null)
            return null;

        Node clone = new Node(node.val);
        map.put(node,clone);

        for(Node neighbor : node.neighbors)
        {
            if(map.containsKey(neighbor))
            {
                clone.neighbors.add(map.get(neighbor));
            }
            else
            {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }


        return clone;

    }



}
