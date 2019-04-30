import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumWindowSubString {
    public static void main(String [] args){
        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        System.out.println(minimumWindowSubString.minWindow("adobebanc", "abc"));

    }
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        for(Character ch : t.toCharArray()){
            set.add(ch);
        }
        int uniqueCount = 0;
        int min = Integer.MAX_VALUE;
        String window = "";
        int [] win = new int[26];
        while (end<s.length()){
            while (uniqueCount!=set.size() && end<s.length()){
                if(set.contains(s.charAt(end)) && win[s.charAt(end) - 'a']==0){
                    uniqueCount++;
                }
                win[s.charAt(end)-'a']++;
                end++;
            }
            int size = end-start;
            if(size<min){
                window = t.substring(start, end-1);
                min = size;
            }
            while (uniqueCount==set.size()){
                if(set.contains(s.charAt(start))){
                    win[s.charAt(start)-'a']--;
                    if(win[s.charAt(start)-'a']==0)
                    uniqueCount--;
                    if(uniqueCount!=set.size()){
                        break;
                    }
                }
                start++;
            }
        }
        return window;
    }

}
