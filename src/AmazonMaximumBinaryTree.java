public class AmazonMaximumBinaryTree {
    public class TreeNode{
        TreeNode left;
        TreeNode right;
        int value;
    }
    public TreeNode constructMaximumBinaryTree(int [] nums){
       return helper(nums, 0, nums.length);
    }
    public TreeNode helper(int [] nums, int start, int end){
        int maxIndex = -1;
        int max = Integer.MIN_VALUE;
        for(int i=start;i<end;i++){
            if(nums[i]>max){
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode();
        root.value = nums[maxIndex];
        root.left = helper(nums, start, maxIndex-1);
        root.right = helper(nums, maxIndex+1, end);
        return root;
    }
}
