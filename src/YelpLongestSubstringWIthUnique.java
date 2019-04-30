import java.util.HashMap;
import java.util.Map;

public class YelpLongestSubstringWIthUnique {
    public static void main(String [] args){
        YelpLongestSubstringWIthUnique yelpLongestSubstringWIthUnique = new YelpLongestSubstringWIthUnique();
        System.out.println(yelpLongestSubstringWIthUnique.findLongest("californicationesy"));
    }
    public int findLongest(String s){
        Map<Character, Integer> window = new HashMap<>();
        int start = 0;
        int end = 0;
        int max = 0;
        while (end<s.length()){
            char ch = s.charAt(end);
            if(!window.containsKey(ch)){
                window.put(ch, end);
            }
            else{
                if(window.get(ch)<start){
                    window.put(ch, end);
                    end++;
                    continue;
                }
                max = Math.max(max, end-start);
                start = window.get(ch)+1;
                window.put(ch, end);
            }
            end++;
        }
        return Math.max(max, end-start);
    }
}
