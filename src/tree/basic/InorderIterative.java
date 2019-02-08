package tree.basic;

import tree.Tree;
import tree.TreeNode;

import java.util.Stack;

public class InorderIterative {
    public static void main(String [] args){
        InorderIterative inorderIterative = new InorderIterative();
        inorderIterative.inOrder(Tree.getSampleTree());
    }
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            if(root!=null){
                stack.add(root);
                root = root.left;
            }
            else {
                if(stack.isEmpty()){break;}
                root = stack.pop();
                System.out.print(root.val + " ");
                root = root.right;
            }
        }
    }
}
