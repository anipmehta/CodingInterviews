import java.util.*;

public class AmazonSubStringsWithK {
    public static void main(String [] args){
        AmazonSubStringsWithK amazonSubStringsWithK = new AmazonSubStringsWithK();
        System.out.println(amazonSubStringsWithK.subStringsKDist("awaglknagawunagwkwagl", 4));
    }
    public List<String> subStringsKDist(String inputString, int num){
        Set<Character> set = new LinkedHashSet<>();
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        Set<String> result = new LinkedHashSet<>();
        int start = 0;
        int end = start;
        while (end<inputString.length() - 1){
            while(end<num && end<inputString.length()){
                set.add(inputString.charAt(end));
                char lastChar = inputString.charAt(end);
                characterIntegerMap.put(lastChar, characterIntegerMap.getOrDefault(lastChar, 0) + 1);
                end++;
            }
            if(set.size()==num){
                result.add(inputString.substring(start, end));
            }
            char firstChar = inputString.charAt(start);
            if(characterIntegerMap.get(firstChar)==1){
                set.remove(inputString.charAt(start));
                characterIntegerMap.remove(firstChar);
            }
            else{
                characterIntegerMap.put(firstChar, characterIntegerMap.get(firstChar) - 1);
            }
            start++;
            end++;
            char newEnd = inputString.charAt(end);
            set.add(newEnd);
            characterIntegerMap.put(newEnd, characterIntegerMap.getOrDefault(newEnd,0) + 1);
        }
        if(set.size()==num){
            result.add(inputString.substring(start, end));
        }
        List<String> out = new ArrayList<>();
        for(String str : result){
            out.add(str);
        }
        return out;
}
}
