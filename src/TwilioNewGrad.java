import java.util.*;

public class TwilioNewGrad {
    static int numberOfPairs(int[] a, long k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : a){
            set.add(num);
            if(!map.containsKey(num)){
                map.put(num, 0);
            }
            map.put(num, map.get(num)+1);
        }
        Set<String> unique = new HashSet<String>();

        for (int i : a) {
            int complement = (int) k - i;
            if (set.contains(complement)) {
                if(complement==i && map.get(complement)<=1){
                    continue;
                }
                int[] pair = new int[] { complement, i };
                Arrays.sort(pair);
                unique.add(Arrays.toString(pair));
            }
        }

        return unique.size();

    }

    public static long kSub(int k, List<Integer> nums) {
        // Write your code here
        //
        long remainder[] = new long[k];
        int sumSoFar = 0;
        for (int i = 0; i < nums.size(); i++) {
            sumSoFar += nums.get(i);
            remainder[sumSoFar % k]++;
        }
        long result = 0;
        for (int i = 0; i < k; i++){
            if (remainder[i] > 1)
                result += (remainder[i] * (remainder[i] - 1)) / 2;
        }
        result += remainder[0];
        return result;
    }

}
