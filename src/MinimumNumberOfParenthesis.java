import java.util.*;
import java.util.LinkedList;

public class MinimumNumberOfParenthesis {
    public static void main(String [] args){
        MinimumNumberOfParenthesis minimumNumberOfParenthesis = new MinimumNumberOfParenthesis();
        String s = "(((()))))))";
        System.out.println(minimumNumberOfParenthesis.findMinimum(s));
        for(String str : minimumNumberOfParenthesis.generateAll(s)){
            System.out.println(str);
        }
    }
    public int findMinimum(String s){
        int left = 0;
        int right = 0;
        for(char ch : s.toCharArray()){
            if(ch=='('){
                left++;
            }
            else{
                if(left==0){
                    right++;
                }
                else{
                    left--;
                }
            }
        }
        return left + right;
    }
    public List<String> generateAll(String s){
        if(s==null){
            return new ArrayList<>();
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(s);
        List<String> result = new ArrayList<>();
        boolean found = false;
        while (!queue.isEmpty()){
            String first = queue.poll();
            if(isValid(first)){
                result.add(first);
                found = true;
            }
            if(found)continue;
            for(int i=0; i<s.length();i++){
                String temp = s.substring(0, i) + s.substring(i+1);
                if(s.charAt(i)!='(' && s.charAt(i)!=')')continue;
                if(!visited.contains(temp)){
                    queue.add(temp);
                    visited.add(temp);
                }
            }

        }
    return result;
    }
    public boolean isValid(String s){
        int counter = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                counter++;
            }
            else{
                if(counter<=0){
                    return false;
                }
                counter--;
            }
        }
        return counter == 0;
    }
}
