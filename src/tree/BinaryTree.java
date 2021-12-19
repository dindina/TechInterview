package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


class Node
{
    Node(int x)
    {
        value=x;
        this.left=null;
        this.right = null;
    }
    int value;
    Node right;
    Node left;

    @Override public String toString() {
        return "Node{" +
                "value=" + value +
                ", right=" + right +
                ", left=" + left +
                '}';
    }
}
public class BinaryTree {
    Node root;
    BinaryTree()
    {
        root= null;
    }
    public void preorder(Node node) {
            if (node == null)
                return;
            System.out.print(node.value +"->");
        preorder(node.left);
        preorder(node.right);
    }

    private void postorder(final Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value +"->");
    }

    private void inorder(final Node node) {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.value +"->");
        inorder(node.right);

    }
    public Node lookup(int value)
    {
        Node current = root;
        while(current!= null)
        {
            if(current.value == value)
                return current;
            else if(value <= current.value)
                current = current.left;
            else
                current = current.right;

        }
        return null;
    }
    public void insert(int value)
    {
        Node newNode = new Node(value);
        if(root==null)
        {
            root = newNode;
        }
        else
        {
            Node next = root;
            Node prev = root;
            while(next != null)
            {
                if(value < next.value) {
                    prev = next;
                    next = next.left;
                }
                else {
                    prev = next;
                    next = next.right;
                }
            }

            if(value < prev.value) {
                prev.left = newNode;
            }
            else {
                prev.right = newNode;
            }
        }
    }

    public List<Integer> depthfirstsearch_dfs()
    {
        List<Integer> path = new ArrayList<>();
        Node current = root;
        Queue<Node> nodesToVisit = new ArrayDeque<>();
        nodesToVisit.offer(current); // offer is add to the q

        while(nodesToVisit.size() >0)
        {
            Node visitedNode  = nodesToVisit.poll();
            path.add(visitedNode.value);
            if(visitedNode.left!=null)
            {
                nodesToVisit.offer(visitedNode.left);
            }

            if(visitedNode.right!=null) {
                nodesToVisit.offer(visitedNode.right);
            }
        }

        return path;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(9);
        tree.insert(4);
        tree.insert(6);
        tree.insert(20);
        tree.insert(170);
        tree.insert(15);
        tree.insert(1);
        System.out.println("pre order");
        tree.preorder(tree.root);
        System.out.println("\npost order");
        tree.postorder(tree.root);
        System.out.println("\nin order");
        tree.inorder(tree.root);

       //System.out.println("\n" + tree.lookup(3 ));
        System.out.println("\n dfs");
        System.out.println(tree.depthfirstsearch_dfs());
    }


}
