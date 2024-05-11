package practice.tress;

import com.sun.source.tree.Tree;

public class TreeNode {

    public Integer value;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int value)
    {
        this.value=value;
        this.left=null;
        this.right=null;
    }

}
