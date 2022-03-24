package practice;

import graphs.Node;

import java.util.HashMap;

public class CloneGraph {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        node1.addEdge(node2);
        node1.addEdge(node3);
        node2.addEdge(node4);
        node3.addEdge(node5);

        Node cloned = cloneGraph1(node1);

    }

    static HashMap<Node,Node> map = new HashMap<>();
    private static Node cloneGraph1(Node node1) {
        if(node1 == null) return null;

        Node clone = new Node(node1.val);
        map.put(node1,clone);
        for(Node neighbour : node1.neighbors)
        {
            if(map.containsKey(neighbour))
            {
                clone.neighbors.add(map.get(neighbour));
            }
            else
            {
                clone.neighbors.add(cloneGraph1(neighbour));
            }
        }

        return clone;


    }
}
