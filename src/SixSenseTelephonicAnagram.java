import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SixSenseTelephonicAnagram {
    static Set<String> allPermutations = new HashSet<>();
    public static void main(String [] args){
        System.out.println(isAnagram("hlloe", "hello"));
    }
    public static boolean isAnagram(String anagram, String string){
        allPermutations = helper(string);
        for(String permute : allPermutations){
            System.out.println(permute);
        }
        System.out.println(allPermutations.size());
        return allPermutations.contains(anagram);
    }
    public static Set<String> helper(String string){
        if(string.length() == 1){
            Set<String> set = new HashSet<String>();
            set.add(string);
            return set;
        }
        Set<String> set = new HashSet<String>();
        for(int i=0;i<string.length();i++){
            for(String str : helper(string.substring(0,i) + string.substring(i+1))){
                set.add(string.charAt(i) + str);
            }
        }
        return set;
    }
}
