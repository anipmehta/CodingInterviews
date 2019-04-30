import java.util.ArrayList;
import java.util.List;
/*
     "((()))"
     "((())) || (((())"
*/
public class GenerateAllValidParen {
    public static void main(String [] args){
        for(String str : generateAll(3)){
         System.out.println(str);
        }
    }
    public static List<String> generateAll(int n){
        List<String> allStrings  = new ArrayList<>();
        helper(n, allStrings, "", 0);
        return allStrings;
    }

    private static void helper(int n, List<String> allStrings, String s, int counter){
        if(s.length()== 2*n && counter==0){
            allStrings.add(s);
        }
        if(counter<0 || s.length()>2*n){
            return;
        }
        helper(n, allStrings, s+"(", counter+1);
        helper(n, allStrings, s+")", counter-1);
    }
}
