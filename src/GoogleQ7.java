import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleQ7 {
    public static void main(String [] args){
       GoogleQ7 googleQ7 = new GoogleQ7();
//       int [] coupons = {5,3,4,2,3,4,5,7};
//       int [] coupons = {3,6,1,9};
        int [] coupons = {1,2};

       System.out.println(googleQ7.solution(coupons));
    }
    public int solution(int[] coupons) {
        // write your code in Java SE 8
    Map<Integer, Integer> couponToIndexDiff = new HashMap<>();
    Map<Integer, Integer> couponToLastSeen = new HashMap<>();
    for(int i=0;i<coupons.length;i++){
        if(couponToIndexDiff.containsKey(coupons[i])){
            int diff = i - couponToLastSeen.get(coupons[i]);
            couponToIndexDiff.put(coupons[i], Math.min(diff, couponToIndexDiff.get(coupons[i])));
        }
        else{
            couponToIndexDiff.put(coupons[i], Integer.MAX_VALUE);
        }
        couponToLastSeen.put(coupons[i], i);
    }
    int minDiff  = Integer.MAX_VALUE;
    for(int coupon : couponToIndexDiff.keySet()){
        minDiff = Math.min(minDiff, couponToIndexDiff.get(coupon));
    }
    return minDiff == Integer.MAX_VALUE ? -1 : minDiff+1;
    }
}
