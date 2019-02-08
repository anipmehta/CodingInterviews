public class LCAWithoutParents {
    public static void main(String [] args){
       TreeNode root = new TreeNode(20);
       root.left = new TreeNode(10);
       root.right = new TreeNode(30);
       root.left.left = new TreeNode(5);
       root.left.right = new TreeNode(15);
       root.left.left.left = new TreeNode(3);
       root.left.left.right = new TreeNode(7);
       root.left.right.right = new TreeNode(17);

       System.out.println( commonAncestor(root, root.left.left.left, root.left.right.right).value);
    }
    public static class TreeNode{
        public int value;
        TreeNode left=null, right=null;
        public TreeNode(int x){
            this.value = x;
        }
    }
    public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(!containsNode(root, p) || !containsNode(root, q)){
            return null;
        }
        boolean isPOnLeft = containsNode(root.left, p);
        boolean isQOnLeft = containsNode(root.left, q);
        if(isPOnLeft!=isQOnLeft){
            return root;
        }
        TreeNode recurse = isPOnLeft ? root.left : root.right;
        return commonAncestor(recurse, p, q);
    }

    public static boolean containsNode(TreeNode root, TreeNode node){
        if(root==null){
            return false;
        }
        if(root == node){
            return true;
        }
        return containsNode(root.left, node) || containsNode(root.right, node);
    }
}
