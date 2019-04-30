import java.util.ArrayList;
import java.util.List;
/*
[1,2,3]
 */
public class FacebookSubSet {
    public static void main(String [] args){
        FacebookSubSet facebookSubSet = new FacebookSubSet();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        for(List<Integer> integers: facebookSubSet.subset(list)){
            for(Integer num : integers){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> subset(List<Integer> list){
        List<List<Integer>> result = new ArrayList<>();
        helper(list, new ArrayList<>(), 0, result);
        return result;
    }

    private void helper(List<Integer> list, ArrayList<Integer> current, int index, List<List<Integer>> result) {
        if(index>=list.size()){
            result.add(new ArrayList<>(current));
            return;
        }
        current.add(list.get(index));
        helper(list, current, index+1, result);
        current.remove(list.get(index));
        helper(list, current, index+1, result);
    }
}
