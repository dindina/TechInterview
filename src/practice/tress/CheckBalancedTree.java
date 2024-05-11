package practice.tress;

public class CheckBalancedTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);


        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode node)
    {
        if(dfsHeight(node) ==-1)
            return false;
        else return true;
    }

    public static int dfsHeight(TreeNode node)
    {
        if(node ==null)
            return 0;

        int lh = dfsHeight(node.left);
        if(lh==-1) return -1;

        int rh = dfsHeight(node.right);
        if(rh==-1) return -1;

        if(Math.abs(lh-rh) >1) return -1;

        return 1 + Math.max(rh,lh);

    }
}
