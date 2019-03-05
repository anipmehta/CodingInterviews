import java.util.*;

public class PhoneCombination{
    public static void main(String [] args){
        PhoneCombination phoneCombination = new PhoneCombination();
        System.out.println(phoneCombination.combinations("23"));
    }
    public Set<String> combinations(String digits){
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "ABC");
        map.put(3, "DEF");
        map.put(4, "GHI");
        map.put(5, "JKL");
        map.put(6, "MNO");
        map.put(7, "PQRS");
        map.put(8, "TUV");
        map.put(9, "WXYZ");
        return helper(digits, map);
    }
    public Set<String> helper(String digits, Map<Integer, String> map){
        if(digits.length() == 1){
            Set<String> set = new TreeSet<>();
            for(Character ch : map.get(Integer.parseInt(digits)).toCharArray()){
                set.add(String.valueOf(ch));
            }
            return set;
        }
        String mapping = map.get(Integer.parseInt(String.valueOf(digits.charAt(0))));
        Set<String> set = new TreeSet<>();
        for(Character ch : mapping.toCharArray()){
            for(String str  : helper(digits.substring(1), map)){
                set.add(ch + str);
            }
        }
        return set;
    }
}
