import java.util.*;

public class GoogleQ1 {
    public static void main(String [] args){
        int [] A = {1, 1, 1, 2, 2};
        int [] E = {1, 2, 1, 3, 2, 4, 2, 5};
        GoogleQ1 googleQ1 = new GoogleQ1();
        googleQ1.undirectedTree(A, E);
    }
    public int undirectedTree(int [] A, int [] E){
        Map<Integer, List<Integer>> nodeEdgesMap = new HashMap<>();
        for(int i=0; i< E.length - 1; i = i+2){
            if(!nodeEdgesMap.containsKey(E[i])){
                nodeEdgesMap.put(E[i], new ArrayList<>());
            }
            nodeEdgesMap.get(E[i]).add(E[i+1]);
            if(!nodeEdgesMap.containsKey(E[i+1])){
                nodeEdgesMap.put(E[i+1], new ArrayList<>());
            }
            nodeEdgesMap.get(E[i+1]).add(E[i]);
        }
        int max = Integer.MIN_VALUE;
        boolean visit[] = new boolean[A.length];
        for(int node : nodeEdgesMap.keySet()){
            int currentMax = findLongestPath(nodeEdgesMap, node, A, visit, A[node-1]);
            System.out.println(currentMax);
            if(currentMax > max){
                max = currentMax;
            }
        }
        return max;
    }
    int findLongestPath(Map<Integer, List<Integer>> map, int start, int [] labels, boolean visit[], int target){
        List<Integer> edges = map.get(start);
        int currentMax = 0;
        for (int node : edges){
            if (visit[node-1]){
                continue;
            }
            if(labels[node-1]==target){
                visit[start-1] = true;
                currentMax = Math.max(currentMax, 1 + findLongestPath(map, node, labels, visit, target));
                visit[start-1] = false;
            }
        }
        return currentMax;
    }
    public boolean solution(int total_money, int total_damage, int[] costs, int[] damages) {
        // write your code in Java SE 8
        int size = costs.length;
        float [] damageCost = new float[costs.length];
        float tempFloat;
        int tempInt;
        for (int i=0;i< size; i++){
            damageCost[i] = damages[i] / (float) costs[i];
        }
        //Sorting damagesCost array in decreasing order of their ratio and then sorting damages and cost accordingly
        for(int i=0; i<size; i++){
            for(int j=0; j< size-i-1; j++){
                if(damageCost[j]  < damageCost[j+1]){
                    //Swap damageCost array
                    tempFloat = damageCost[j];
                    damageCost[j] = damageCost[j+1];
                    damageCost[j+1] = tempFloat;

                    tempInt = damages[j];
                    damages[j] = damages[j+1];
                    damages[j+1] = tempInt;

                    tempInt = costs[j];
                    costs[j] = costs[j+1];
                    costs[j+1] = tempInt;
                }
            }
        }
        int index = 0;
        while( total_money > 0){
            total_money -= costs[index];
            total_damage -= damages[index];
            //Check to see you have covered the damage and as well you are not low on cost
            if(total_damage<=0 && total_money>=0){
                return true;
            }
        }
        return false;
    }

    class Solution {
        public int solution(String S, String T) {
            // write your code in Java SE 8
            //If they are of same length
            if(S.length()==T.length()){
                return S.equals(T) ? 1 : 0;
            }
            int first = 0; //pointer to iterate over string S
            int second = 0; //pointer to iterate over string T
            while(second<T.length()){
                //Reached end of T
                if(first>=S.length()){
                    return 0;
                }
                if(S.charAt(first)==T.charAt(second)){
                    first++;
                    second++;
                }
                else{
                    first++;
                }
            }
            return 1;
        }
    }
}
