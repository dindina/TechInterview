package graphs.bfs;


public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public static void inorder(TreeNode node)
    {
        if(node == null)
            return;

        System.out.print(node.getVal() + ",");
        inorder(node.left);
        inorder(node.right);

    }

    @Override
    public String toString()
    {
        return String.valueOf(this.val);
    }
}
