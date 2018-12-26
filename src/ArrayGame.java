import java.util.ArrayList;
import java.util.List;

public class ArrayGame {
    public static void main(String [] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(2);list.add(3);
        countMoves(list);
        System.out.println(countMoves(list));
    }
    public static long countMoves(List<Integer> numbers){
        long sum = 0;
        long min = Long.MAX_VALUE;
        for(int num : numbers){
            sum += num;
            min = Math.min(num, min);
        }
        return sum-min*numbers.size();
    }
}
