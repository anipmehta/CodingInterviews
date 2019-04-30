import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacebookColOrderTraversal {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String [] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(15);
        root.right = new TreeNode(11);
        root.right.left = new TreeNode(20);
        List<List<Integer>> order = colTraverse(root);
        for(List<Integer> or : order){
            for(int value : or){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> colTraverse(TreeNode root){
        Map<Integer, List<Integer>> map = new HashMap<>();
        helper(map, root, 0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int key : map.keySet()){
            min = Math.min(key, min);
            max = Math.max(key, max);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=min;i<=max;i++){
            list.add(map.get(i));
        }
        return list;
    }

    private static void helper(Map<Integer, List<Integer>> map, TreeNode root, int level) {
        if(root==null){
            return;
        }
        if(!map.containsKey(level)){
            map.put(level, new ArrayList<>());
        }
        map.get(level).add(root.val);
        helper(map, root.left, level-1);
        helper(map, root.right, level+1);
    }

}
