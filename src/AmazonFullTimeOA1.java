//public class AmazonFullTimeOA1{
//    public static void main(String [] args){
//
//    }
//    // IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
//// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
//// DEFINE ANY CLASS AND METHOD NEEDED
//import java.util.List;
//import java.util.*;
//    // CLASS BEGINS, THIS CLASS IS REQUIRED
//    public class Solution
//    {
//        // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
//        List<Integer> lengthSubsequenceShoppers(List<Character> inputList)
//        {
//            // WRITE YOUR CODE HERE
//            List<Integer> result = new ArrayList<>();
//            Map<Character, Interval> map = new LinkedHashMap<>();
//            if(inputList.isEmpty()){
//                return result;
//            }
//            // creating a map of occurrences to each char with their first
//            // and last occurence by creating an interval class
//            List<Interval> l = new ArrayList<>();
//            for(int i = 0; i < inputList.size(); i++){
//                char ch = inputList.get(i);
//                if(!map.containsKey(ch)){
//                    map.put(ch, new Interval(i));
//                }
//                else{
//                    map.get(ch).end = i;
//                }
//            }
//
//            List<Interval> intervals = new ArrayList<Interval>(map.values());
//            Interval prev = intervals.get(0);
//            // iterating over each intervals to find partitions
//            for(int i = 1; i < intervals.size(); i++){
//                Interval cur = intervals.get(i);
//
//                if( prev.end < cur.start ){
//                    // partiion condition
//                    result.add(prev.end - prev.start +1);
//                    prev.start = cur.start;
//                    prev.end = cur.end;
//                }
//                else{
//                    if(prev.end > cur.end){
//                        continue;
//                    }
//                    else{
//                        prev.end = cur.end;
//                    }
//                }
//            }
//            result.add(prev.end - prev.start + 1);
//            return result;
//        }
//
//
//        // METHOD SIGNATURE ENDS
//    }
//    class Interval {
//        int start;
//        int end;
//
//        Interval(int start){
//            this.start = start;
//            this.end = start;
//        }
//    }
//
//}
