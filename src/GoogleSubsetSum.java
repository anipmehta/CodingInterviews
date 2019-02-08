import java.util.ArrayList;
import java.util.List;

public class GoogleSubsetSum {
    private static List<Integer> output;
    public static void main(String [] args){
        GoogleSubsetSum googleSubsetSum = new GoogleSubsetSum();
        int [] a = {12, 1, 61, 5, 9, 2, 1};
        List<Integer> out = googleSubsetSum.subSetSum(a, 24);
        System.out.println(out);
    }
    public List<Integer> subSetSum(int [] a, int target){
    List<Integer> list = new ArrayList<>();
    if(helper(a, 0, list, target)){
        return output;
    }
    return null;
    }
    public boolean helper(int [] a, int index, List<Integer> list, int sum){
        if(sum==0){
            output = new ArrayList<>();
        output.addAll(list);
        return true;
        }
        if(index>=a.length){
            return false;
        }
        list.add(a[index]);
        boolean consume = helper(a, index+1, list, sum - a[index]);
        list.remove(list.size()-1);
        boolean no = helper(a, index+1, list, sum);
        return consume || no;
    }
}
