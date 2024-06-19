package practice.tress;



public class DFSTraversal {

    //root left right
    public static void preorder(TreeNode node)
    {
        if(node==null)
            return;
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // left root right
    public static void inorder(TreeNode node)
    {
        if(node==null)
            return;
        inorder(node.left);
        System.out.println(node.value);
        inorder(node.right);
    }

    // right root left
    public static void postorder(TreeNode node)
    {
        if(node==null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(22);
        root.right.left = new TreeNode(33);
        root.right.left.right = new TreeNode(34);

        //preorder(root);
        //inorder(root);
        postorder(root);




    }
}
