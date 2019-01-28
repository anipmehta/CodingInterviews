import java.util.*;
import java.util.stream.Collectors;

public class Amazon2 {
    public static void main(String [] args){
        Amazon2 amazon2 = new Amazon2();
        List<List<Integer>> list = new ArrayList<>();
        int [] arr1 = {1,2};
        int [] arr2 = {3,4};
        int [] arr3 = {1,-1};
        list.add(Arrays.stream(arr1).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(arr2).boxed().collect(Collectors.toList()));
        list.add(Arrays.stream(arr3).boxed().collect(Collectors.toList()));
        list = amazon2.deliveryPlan(list, 2);
        System.out.println(list.size());
    }
    public List<List<Integer>> deliveryPlan(List<List<Integer>> list, int X){
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> maxHeap = new PriorityQueue<>(X + 1, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int x1 = o1.get(0);
                int y1 = o1.get(1);
                int x2 = o2.get(0);
                int y2 = o2.get(1);
                int d1 = x1*x1 + y1*y1;
                int d2 = x2*x2 + y2*y2;
                if(d2>d1){
                    return 1;
                }
                else if(d1>d2){
                    return -1;
                }
                return 0;
            }
        });
        for(List<Integer> coordinate : list){
            maxHeap.add(coordinate);
            if(maxHeap.size()>X){
                maxHeap.poll();
            }
        }
        while (!maxHeap.isEmpty()){
         result.add(maxHeap.poll());
        }
        Collections.reverse(result);
        return result;
//        Collections.sort(list, new Comparator<List<Integer>>() {
//            @Override
//            public int compare(List<Integer> o1, List<Integer> o2) {
//                int x1 = o1.get(0);
//                int y1 = o1.get(1);
//                int x2 = o2.get(0);
//                int y2 = o2.get(1);
//                int d1 = x1*x1 + y1*y1;
//                int d2 = x2*x2 + y2*y2;
//                return d1-d2;
//            }
//        });
//        return queue;
    }
}
