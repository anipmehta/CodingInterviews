import java.util.*;

public class TwilioAnalysis {
    public static List<String> computeParameterValue(List<List<String>> sources) {
        // Write your code here
    Map<String, String> linkedHashMap = new LinkedHashMap<>();
    for(List<String> source : sources){
        for(String item : source){
            linkedHashMap.put(item.split(":")[0], item.split(":")[1]);
        }
    }
    List<String> output = new ArrayList<>();
    for(String key : linkedHashMap.keySet()){
        output.add(linkedHashMap.get(key));
    }
    return output;
    }
}
