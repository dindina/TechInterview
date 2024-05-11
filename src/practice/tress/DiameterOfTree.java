package practice.tress;

public class DiameterOfTree {

    public static int diameter=0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(21);
        root.left.right = new TreeNode(22);
        root.right.left = new TreeNode(33);
        root.right.left.right = new TreeNode(34);
        System.out.println(diameter);
        getDiameter(root);
        System.out.println(diameter);

    }

    public static int getDiameter(TreeNode node)
    {
        if(node ==null)
            return 0;

        int lh = getDiameter(node.left);
        int rh = getDiameter(node.right);
        diameter = Math.max(diameter,lh+rh);
        return 1 + Math.max(lh,rh);

    }


}
