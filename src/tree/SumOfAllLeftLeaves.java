package tree;

import breadthfirstsearch.TreeNode;

public class SumOfAllLeftLeaves
{

        public int sumOfLeftLeaves(TreeNode node) {
            if(node == null)
                return 0;

            int sum = helper(node,false);
            System.out.println("sum " + sum);
            return sum;

        }

        public int helper(TreeNode node , boolean isLeft )
        {
            if(node ==null ) return 0;
            if(node.left == null && node.right == null) {
                if(isLeft)
                    return node.val;
                else
                   return 0;
            }
            return helper(node.left,true) +helper(node.right,false);
        }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        new SumOfAllLeftLeaves().sumOfLeftLeaves(root);
    }
}
