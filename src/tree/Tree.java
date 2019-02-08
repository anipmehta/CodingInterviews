package tree;

public class Tree {
    public TreeNode root;
    public static TreeNode getSampleTree(){
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(9);
        root.right.left = new TreeNode(6);
        root.right.left.right = new TreeNode(7);
        return root;
    }
}

