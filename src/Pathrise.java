import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pathrise{
    public static void main(String [] args){

    }

    public static boolean isMember(List<String> words, String query) {
        for(String str : words){
            if(str.length()!=query.length()){
                continue;
            }
            if(isMatch(str, query,0)){
                return true;
            }
        }
        return false;
    }
    public static boolean isMatch(String str, String query, int index){
       if(index==query.length()){
           return true;
       }
       if(str.charAt(index)!=query.charAt(index) && query.charAt(index)!='.'){
           return false;
       }
       return isMatch(str, query, index+1);
    }
}
