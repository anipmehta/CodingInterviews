import java.util.HashMap;
import java.util.Map;

public class Visa {
    public static String dnaComplement(String s){
        Map<Character, Character> map = new HashMap<>();
        map.put('C','G');
        map.put('A', 'T');
        map.put('G', 'C');
        map.put('T', 'A');
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i=s.length()-1;i>=0;i--){
            stringBuilder.append(map.get(s.charAt(i)));
        }
        return stringBuilder.toString();
    }
}
