import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SuperBalancedBinaryTree{
    public static class BinaryTreeNode {

        public int value;
        public BinaryTreeNode left;
        public BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        public BinaryTreeNode insertLeft(int leftValue) {
            this.left = new BinaryTreeNode(leftValue);
            return this.left;
        }

        public BinaryTreeNode insertRight(int rightValue) {
            this.right = new BinaryTreeNode(rightValue);
            return this.right;
        }
    }

    public static boolean isBalanced(BinaryTreeNode treeRoot) {
        // determine if the tree is superbalanced
        return helper(treeRoot, new ArrayList<>(), 0);
    }
    public static boolean helper(BinaryTreeNode root, List<Integer> depths, int currDepth){
        if(root.left == null && root.right == null){
            if(!depths.contains(currDepth)){
              depths.add(currDepth);
            }
            if(depths.size()>2 || Math.abs(depths.get(0) - depths.get(1)) > 1){
                return false;
            }
            if(root.left!=null){
                helper(root.left, depths, currDepth+1);
            }
            if(root.right!=null){
                helper(root.right, depths, currDepth+1);
            }
        }
        return true;
    }
}
