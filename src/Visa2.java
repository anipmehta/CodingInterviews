import java.util.*;

public class Visa2 {
    public static void main(String [] args){
        findSchedules(56, 8, "???8???");
        System.out.println(findSchedules(24,4, "08?in ?840"));
//        (findSched);
    }
    public static List<String> findSchedules(int workHours, int dayHours, String pattern){
        Set<String> list = new TreeSet<>();
        helper(workHours, pattern, 0, pattern, list, dayHours);
        List result = new ArrayList(list);
        return result;

    }
    public static void helper(int sum, String pattern, int index, String curr, Set<String> results, int range){
        if(sum==0 && !curr.contains("?")){
            results.add(curr);
            return;
        }
        if(index == pattern.length()){
            return;
        }
        if(pattern.charAt(index)=='?'){
            for(int i=0;i<=range;i++){
                String newCurr = curr.substring(0, index) + String.valueOf(i) + curr.substring(index+1);
                helper(sum - i, pattern, index+1, newCurr, results, range);
            }
        }
        else if(Character.isDigit(pattern.charAt(index))){
            helper(sum - Character.getNumericValue(pattern.charAt(index)), pattern,index+1, curr, results, range);
        }


    }
}
