//public class RemoveDuplicates {
//    public static void main(String [] args){
//        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
//        int [] nums = {0,0,1,1,1,1,2,3,3};
//        System.out.println(removeDuplicates.removeDuplicates(nums));
//    }
//    public int removeDuplicates(int[] nums) {
//        int frequency = 1;
//        int finalIndex = 1;
//        for(int i=1;i<nums.length;i++){
//            (nums[i]==nums[i-1]){
//                if(frequency<2){
//                    nums[finalIndex] = nums[i];
//                    frequency++;
//                    finalIndex++;
//                }
//                else{
//                    frequency=1;
//                }
//            }
//            else{
//                nums[finalIndex++] = nums[i];
//            }
//        }
//        return finalIndex;
//    }
//}
