import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwitterOA3Q1 {

        /*
         * Complete the 'decode' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts following parameters:
         *  1. STRING_ARRAY codes
         *  2. STRING encoded
         */
        public static void main(String [] args){
            TwitterOA3Q1 twitterOA3Q1 = new TwitterOA3Q1();
        }

        public static String decode(List<String> codes, String encoded) {
            // Write your code here
            Map<String, String> map = new HashMap<>();
            for(String code : codes){
                String [] arr = code.split("\t");
                map.put(arr[1], arr[0]);
            }
            StringBuilder stringBuilder = new StringBuilder("");
            huffDecode(map, encoded, stringBuilder);
            return stringBuilder.toString();
        }

    private static void huffDecode(Map<String, String> map, String encoded, StringBuilder stringBuilder) {
        int start = 0;
        while(start<encoded.length() && !map.containsKey(encoded.substring(0, start))){
            start++;
        }
        String match = encoded.substring(0,start);
        stringBuilder.append(match.equals("[newline]") ? "\n" : map.get(match));
        if(start>=encoded.length()){
            return;
        }
        huffDecode(map, encoded.substring(start), stringBuilder);
    }
}
