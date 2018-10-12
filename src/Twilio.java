import java.util.Arrays;

public class Twilio {
    public static void main(String [] args){
        int [] nums = {1, 4, 2 ,4};
        int [] maxes = {3, 5};

        counts(nums, maxes);
    }
    static int[] counts(int[] nums, int[] maxes) {
        Arrays.sort(nums);
        for (int num : maxes){
            System.out.println(countSmall(nums, num));
        }

        return nums;
    }

    public static int countSmall(int [] arr, int num){
        int low = 0;
        int high = arr.length-1;
        int mid = 0;
        while(low<high){
            mid = low + (high - low) / 2;
            if(arr[mid]==num){
                return mid+1;
            }
            else if(arr[mid]<num){
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        return high+1;
    }

}
