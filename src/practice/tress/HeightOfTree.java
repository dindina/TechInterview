package practice.tress;

public class HeightOfTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(22);
        root.right.left = new TreeNode(33);
        root.right.left.right = new TreeNode(34);

        System.out.println(height(root));
        System.out.println(leftheight(root));
        System.out.println(rightheight(root));


    }

    public static int height(TreeNode node)
    {
        if (node==null)
            return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        return 1 + Math.max(lh,rh);

    }

    public static int leftheight(TreeNode node)
    {
        if (node==null)
            return 0;
        return 1 + height(node.left);

    }

    public static int rightheight(TreeNode node)
    {
        if (node==null)
            return 0;
        return 1 + height(node.right);

    }
}
