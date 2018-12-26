import java.util.ArrayList;
import java.util.List;

public class DyDx {
    public static void main(String [] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(7);
        System.out.println(arithmeticBoggle(1, list));
    }
    public static boolean arithmeticBoggle(
            int magicNumber,
            ArrayList<Integer> numbers
    ) {
        if(numbers.size()==0){
            return magicNumber==0;
        }
        if(numbers.size()==1){
            return numbers.get(0)==magicNumber;
        }
        return helper(numbers, 0, 0, magicNumber);

    }
    public static boolean helper(List<Integer> list, int index, int target, int magicNumber){
        if (index >= list.size())
            return target==magicNumber;
        return
             helper(list, index+1, target-list.get(index), magicNumber)
                || helper(list, index+1, target+list.get(index), magicNumber);
    }
}
