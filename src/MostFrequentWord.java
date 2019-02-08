import java.util.HashMap;
import java.util.Map;

public class MostFrequentWord {
    public static void main(String [] args){
        String[] words = { "john", "johnny", "jackie",
                "johnny", "john", "jackie",
                "jamie", "jamie", "john",
                "johnny", "jamie", "johnny",
                "john" };
        System.out.println(findFrequentWord(words));
    }

    public static String findFrequentWord(String [] words){
        Map<String, Integer> map = new HashMap<>();
        for( String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        int max = Integer.MIN_VALUE;
        String frequentWord = "";
        for (String word : map.keySet()){
            if(map.get(word)>max){
                max = map.get(word);
                frequentWord = word;
            }
        }
        return frequentWord;
    }
}
