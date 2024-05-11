package practice.tress;

public class IdenticalTrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(22);
        root.right.left = new TreeNode(33);
        root.right.left.right = new TreeNode(34);
        root.right.left.right.left = new TreeNode(341);



        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(21);
        root1.left.right = new TreeNode(22);
        root1.right.left = new TreeNode(33);
        root1.right.left.right = new TreeNode(34);

        System.out.println(isIdentical(root,root1));


    }

    public static boolean isIdentical(TreeNode node1, TreeNode node2)
    {
        if(node1 == null && node2==null)
            return true;

        if(node1 ==null || node2 == null)
            return false;

        if (node1.value!=node2.value)
            return false;

        return isIdentical(node1.left,node2.left) && isIdentical(node1.right,node2.right);

    }


}
