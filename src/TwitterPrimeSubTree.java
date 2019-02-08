import java.sql.Array;
import java.util.*;

public class TwitterPrimeSubTree {
    public static void main(String [] args){
//        Integer [] a = {9,6,8,3,6,4,1,8,5,1};
        Integer [] a = {5,1,2,2,1,3};
//        Integer [] b = {9,9,9,5,7,8,8,10,8,2};
        Integer [] b = {5,2,4,2,5,3,6};
//        Integer [] c = {17, 29, 3, 20, 11, 8, 3, 23, 5, 15};
        Integer [] c = {2,2,6,5,4,3};
//        Integer [] d = {1,8,9,6,4,3};
        Integer [] d = {1,4,5,6,2};
        primeQuery(10, Arrays.asList(a), Arrays.asList(b), Arrays.asList(c), Arrays.asList(d));
    }
    public static List<Integer> primeQuery(int n, List<Integer> first, List<Integer> second, List<Integer> values, List<Integer> queries) {
        // Write your code here
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer,  List<Integer>> tree = new HashMap<>();
        for(int i=0;i<first.size();i++){
            int one = first.get(i);
            int two = second.get(i);
            if(one==two){continue;}
            if(!map.containsKey(one)){
                map.put(one, new ArrayList<>());
            }
            map.get(one).add(two);
            if(!map.containsKey(two)){
                map.put(two, new ArrayList<>());
            }
            map.get(two).add(one);
        }
        helper(tree, map, 1);
        List<Integer> result = new ArrayList<>();
        for(int query : queries){
            int count = helper2(tree, query, 0, values);
            result.add(count);
        }
        return result;

    }
    public static void helper(Map<Integer, List<Integer>> tree, Map<Integer, List<Integer>> map, int node){
    if(!map.containsKey(node)){return;}
        for(int child : map.get(node)){
            boolean flag = tree.containsKey(child) && checkParent(node, tree.get(child));
            if(flag==true){
                continue;
            }
            if(child!=node && !flag){
                if(!tree.containsKey(node)){
                    tree.put(node, new ArrayList<>());
                }
                tree.get(node).add(child);
            }
            helper(tree, map, child);
        }
    }
    public static boolean checkParent(int parent, List<Integer> children){
        for(int num : children){
            if(num==parent){
                return true;
            }
        }
        return false;
    }
    public static int helper2(Map<Integer, List<Integer>> tree, int query, int count, List<Integer> values){
        if(checkPrime(values.get(query-1))){
            count ++;
        }
        if(!tree.containsKey(query)){
            return count;
        }
        for(int child : tree.get(query)){
            count = helper2(tree, child, count, values);
        }
        return count;


    }

    public static boolean checkPrime(int number){
        if(number == 0 || number ==1){
            return false;
        }
        int m = number/2;
        for(int i=2;i<=m;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
}
