import java.util.List;

public class SlidingWindowSubarraySum {
    public static void main(String [] args){
        int [] arr = {1,4,6,21,0};
        SlidingWindowSubarraySum slidingWindowSubarraySum = new SlidingWindowSubarraySum();
        System.out.println(slidingWindowSubarraySum.subArraySum(arr, 0));

    }
    public boolean subArraySum(int [] arr, int target){
        int start = 0;
        int end = 0;
        int currentSum = 0;
        while (end<arr.length){
            currentSum += arr[end];
            end++;
            while (currentSum > target && start < end-1){
                currentSum -= arr[start];
                start++;
            }
            if(currentSum==target){
                return true;
            }
        }
        return false;
    }
}
