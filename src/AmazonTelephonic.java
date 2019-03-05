import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonTelephonic{
    public static void main(String [] args){
        AmazonTelephonic amazonTelephonic = new AmazonTelephonic();
        String [] words = {"This", "is", "a", "book", ".", "Also", "this", "is", "a", "book"};
        String [] sequence = {"this", "is", "a", "book"};
        System.out.println(amazonTelephonic.findOccurence(words, sequence));
    }
    Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> findOccurence(String [] words, String[] sequence){
        preprocessFile(words);
        if(!map.containsKey(sequence[0])){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        for(int index : map.get(sequence[0])){
            if(check(map, sequence, index, 1)){
                list.add(index);
            }
        }
        return list;
    }

    private void preprocessFile(String[] words) {
        for(int i=0;i<words.length;i++){
            if(!map.containsKey(words[i].toLowerCase())){
                map.put(words[i].toLowerCase(), new ArrayList<>());
            }
            map.get(words[i].toLowerCase()).add(i);
        }
    }

    public boolean check(Map<String, List<Integer>> map, String[] sequence, int previous, int index){
        if(index>=sequence.length){
            return true;
        }
        if(!map.containsKey(sequence[index])){
            return false;
        }
        if(!map.get(sequence[index]).contains(previous+1)){
            return false;
        }
        for(int i : map.get(sequence[index])){
            if(check(map, sequence, i, index+1)){
                return true;
            }
        }
        return false;
    }
}
