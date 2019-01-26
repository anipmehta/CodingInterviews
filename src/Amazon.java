import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Amazon {
    public static void main(String [] args){
        Amazon amazon = new Amazon();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list.add(list1);
        list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        list.add(list1);
        list1 = new ArrayList<>();
        list1.add(1);
        list1.add(-1);
        list.add(list1);
        list = amazon.deliveryPlan(list, 2);
        System.out.println(list);
    }
    public List<List<Integer>> deliveryPlan(List<List<Integer>> list, int X){
        Collections.sort(list, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int x1 = o1.get(0);
                int y1 = o1.get(1);
                int x2 = o2.get(0);
                int y2 = o2.get(1);
                int d1 = x1*x1 + y1*y1;
                int d2 = x2*x2 + y2*y2;
                return d1-d2;
            }
        });
        return list;
    }

}
