public class KRotatedArray {
    public static void main(String [] args){
        KRotatedArray kRotatedArray = new KRotatedArray();
        int [] arr = {8,9,10,2,5,6};
//        int [] arr = {1,2,3,4};
        System.out.println(rotatedK(arr));
    }
    public static int rotatedK(int [] arr){
        int start = 0;
        int end = arr.length - 1;
        while (start<end){
            int mid = start  + (end - start) / 2 ;
            if(mid-1 > 0 && arr[mid]<arr[mid-1]){
                return mid;
            }
            else if(arr[mid]<arr[end]){
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return 0;
    }
}
