import java.util.ArrayList;
import java.util.List;

public class MathWorksOA3 {
    public static int cost = 0;
    public static void main(String [] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
//        list.add(2);
        System.out.println(calculateCost(list));
    }


    public static int calculateCost(List<Integer> arr) {
        return helper(arr, 0, arr.size()-1);
    }
    public static int helper(List<Integer> arr, int start, int end){
        if(start>=arr.size() || start<0 || end>=arr.size() || end<0){
            return 0;
        }
        if(start==end) {
            return 0;
        }
       int minCost = Integer.MAX_VALUE;
//        int maxIndex = start;
        for(int i=start;i<=end;i++){
            int leftMax = getMax(start,i, arr);
            int rightMax = getMax(i+1, end, arr);
            int cost = leftMax*rightMax;
            cost += helper(arr, start, i);
            cost += helper(arr, i+1, end);
            minCost = Math.min(cost, minCost);
        }
        return minCost;

    }

    private static int getMax(int start, int end, List<Integer> arr) {
        if(start<0 || end<0 || start>=arr.size() || end>=arr.size()){
            return 0;
        }
        int maxNumber = arr.get(start);
        for(int i=start;i<end;i++){
             maxNumber = Math.max(maxNumber, arr.get(i));
        }
        return maxNumber;
    }

}
