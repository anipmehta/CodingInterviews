import java.util.*;

public class YelpLowerPermutations {
    static int count = 0;
    public static void main(String [] args){
        YelpLowerPermutations yelpLowerPermutations = new YelpLowerPermutations();
        yelpLowerPermutations.lowerPermute("0abc");
    }
    public void lowerPermute(String input){
        for(String str : helper(input)){
            System.out.println(str);
        }
        System.out.println(count);
    }
    public Set<String> helper(String input){
        count++;
        Set<String> set = new TreeSet<>();
        if(input.length() == 0){
            set.add("");
            return set;
        }
        for(String str : helper(input.substring(1))){
            char ch = input.charAt(0);
            char newChar = Character.isLowerCase(ch) ? Character.toUpperCase(ch) : ch;
            set.add(ch + str);
            if(newChar!=ch){
                set.add(newChar + str);
            }
        }
        return set;

    }

}
