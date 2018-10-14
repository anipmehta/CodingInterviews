import java.util.HashSet;
import java.util.Set;

public class ShareCommonSubstring {
    public boolean shareCommonSubstring(String str1, String str2){
        Set<Character> set = new HashSet<>();
        for(char ch: str1.toCharArray()){
            set.add(ch);
        }
        for (char ch : str2.toCharArray()){
            if (set.contains(ch)){
                return true;
            }
        }
        return false;
    }
}
