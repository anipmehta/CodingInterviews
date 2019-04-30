import java.util.*;

/*
"12" -> AD, AE, AF, BD, BE, BF
 */
public class FacebookLetterCombination {
    public static void main(String [] args){
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        FacebookLetterCombination facebookLetterCombination = new FacebookLetterCombination();
        for(String str : facebookLetterCombination.allCombinations("234", map)){
            System.out.print(str + " ");
        }
    }
    public Set<String> allCombinations(String number, Map<Character, String> map){
        return helper(number, map);
    }

    private Set<String> helper(String number, Map<Character, String> map) {
        Set<String> set = new TreeSet<>();
        if(number.length() == 0){
            set.add("");
        }
        else{
            char ch = number.charAt(0);
            Set<String> tempSet = helper(number.substring(1), map);
            for(char letter : map.get(ch).toCharArray()){
                for(String temp : tempSet){
                    set.add(letter + temp);
                }
            }
        }
        return set;
    }
}
