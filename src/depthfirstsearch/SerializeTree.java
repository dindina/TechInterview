package depthfirstsearch;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import graphs.bfs.TreeNode;


public class SerializeTree {

    public static void serialize(TreeNode node, ObjectOutputStream outputStream) throws IOException {

        if(node == null)
        {
            outputStream.writeInt(Integer.MIN_VALUE);
            return;
        }
        outputStream.writeInt(node.val);
        serialize(node.left,outputStream);
        serialize(node.right,outputStream);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(ObjectInputStream inputStream) throws IOException {

         if(inputStream == null)
             return null;

         int val = inputStream.readInt();
         if(val == Integer.MIN_VALUE)
              return null;
         TreeNode treeNode = new TreeNode(val);
         treeNode.left = deserialize(inputStream );
         treeNode.right = deserialize(inputStream );
         return treeNode;
    }

    public static void main(String[] args) throws IOException {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.right.right = new TreeNode(51);

        //List<List<Integer>> result = traverse(root);
        ByteArrayOutputStream baostream = new ByteArrayOutputStream();
        ObjectOutputStream stream = new ObjectOutputStream(baostream);
        serialize(root, stream);
        stream.close();

        ByteArrayInputStream baistream = new ByteArrayInputStream(
                baostream.toByteArray());
        ObjectInputStream  istream = new ObjectInputStream(baistream);
        TreeNode root_deserialized = deserialize(istream);

        TreeNode.inorder(root);
        System.out.println();
        TreeNode.inorder(root_deserialized);




        //TreeNode newTree = invertTree(root);
        //System.out.println();
        //inorder(newTree);
    }
}
