import java.util.ArrayList;
import java.util.List;
/*
ABCDABCD
ABCD
0,1,2,3,4
 */
public class FacebookAnagramSubStringSearch {
    public static void  main(String [] args){
        String haystack = "abcdabcdabcd";
        String needle = "abcd";
        FacebookAnagramSubStringSearch facebookAnagramSubStringSearch = new FacebookAnagramSubStringSearch();
        for(int index : facebookAnagramSubStringSearch.findInstance(haystack, needle)){
            System.out.println(index);
        }
    }
    public List<Integer> findInstance(String haystack, String needle){
        int start = 0;
        int end = 0;
        int [] window = new int[26];
        int [] substring = new int[26];
        for(char ch : needle.toCharArray()){
            substring[ch-'a']++;
        }
        List<Integer> out = new ArrayList<>();
        while (end<haystack.length()){
            while(end<needle.length()){
                window[haystack.charAt(end) - 'a']++;
                end++;
            }
            if(isSame(window, substring)){
                out.add(start);
            }
            window[haystack.charAt(start) - 'a']--;
            start++;
            window[haystack.charAt(end) - 'a']++;
            end++;
        }
        if(isSame(window, substring)){
            out.add(start);
        }
        return out;
    }

    private boolean isSame(int[] window, int[] substring) {
        for(int i=0;i<26;i++){
            if(window[i]!=substring[i]){
                return false;
            }
        }
        return true;
    }
}
