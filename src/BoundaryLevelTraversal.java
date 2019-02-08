import java.util.Stack;

class TreeNode{
    int value;
    TreeNode left=null, right=null;
    public TreeNode(int x){
        this.value = x;
    }
}
public class BoundaryLevelTraversal {
    public static void main(String [] args){
        BoundaryLevelTraversal boundaryLevelTraversal = new BoundaryLevelTraversal();
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        root.right = new TreeNode(22);
        root.right.right = new TreeNode(25);
//        boundaryLevelTraversal.boundaryLevelTraversal(root);
        boundaryLevelTraversal.inorder(root);
    }
    public void inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.println(root.value);
            root = root.right;
        }
    }
    public void boundaryLevelTraversal(TreeNode root){
        System.out.print(root.value + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
    }
    public void printLeaves(TreeNode root){
        if(root==null){
            return;
        }
        printLeaves(root.left);
        if(root.left==null && root.right==null);
        {
            System.out.print(root.value + " ");
        }
        printLeaves(root.right);
    }
    public void printLeftBoundary(TreeNode root){
        if(root==null){
            return;
        }
        if(root.left!=null){
            System.out.print(root.value + " ");
            printLeftBoundary(root.left);
        }
        else if(root.right!=null){
            System.out.print(root.value + " ");
            printLeftBoundary(root.right);
        }
    }

    public void printRightBoundary(TreeNode root){
        if(root==null){
            return;
        }
        if(root.right!=null){
            printRightBoundary(root.right);
            System.out.print(root.value + " ");
        }
        else if(root.left!=null){
            printRightBoundary(root.left);
            System.out.print(root.value + " ");
        }
    }
}

