import java.util.ArrayList;
import java.util.List;

public class TwiiterNoPair {
    public static void main(String [] args){
        List<String> words = new ArrayList<>();
        words.add("add");
        words.add("boook");
        words.add("break");
        minimalOperations(words);
    }
    public static List<Integer> minimalOperations(List<String> words) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for(String word : words){
            int i=1;
            int count = 0;
            char [] arr = word.toCharArray();
            while (i<word.length()){
                if(arr[i]==arr[i-1]){
                    count++;
                    i=i+2;
                }
                else{
                    i++;
                }
            }
            list.add(count);
        }
    return list;
    }
}
