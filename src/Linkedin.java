import java.util.*;

public class Linkedin {

    /*
     * Complete the 'socialGraphs' function below.
     *
     * The function accepts INTEGER_ARRAY counts as parameter.
     */

    public static void socialGraphs(List<Integer> counts) {
        // Write your code here
        // map for grouping elemnts together where key is the count[i] and values is the list having the same count
        Map<Integer, List<Integer>> countMap = new HashMap<>();
        for(int i=0; i<counts.size() ; i++){
            int count = counts.get(i);
            if(!countMap.containsKey(count)){
                countMap.put(count, new ArrayList<>());
            }
            countMap.get(count).add(i);
        }
        //treemap for keeping the overall sorting of the groups where key is the smallest element of each group and values is a list of elements in the group
        Map<Integer, List<Integer>> groupMap = new TreeMap<>();
        for(int count : countMap.keySet()){
            List<Integer> list = countMap.get(count);
            List<Integer> sortedList = new ArrayList<>();
            for(int i=0; i<list.size() ;i++){
                sortedList.add(list.get(i));
                if((i+1)%count==0){
                    // to separate each group once we get each group put it into a sorted map
                    groupMap.put(sortedList.get(0), sortedList);
                    sortedList = new ArrayList<>();
                }
            }
        }
        // finally printing out all groups
        for(int count : groupMap.keySet()){
            for(int num : groupMap.get(count)){
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }
    public static long subarraySum(List<Integer> arr) {
        // Write your code here
        long totalSum = 0;
        int n = arr.size();
        for(int i=0;i<n;i++){
            // doing each operation separately as it was timing out for one case
            long sum = arr.get(i)*(i+1);
            totalSum += sum*(n-i);
        }
        return totalSum;
    }

}
