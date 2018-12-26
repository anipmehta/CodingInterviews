import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

public class AffirmAuthPart1 {
    static String[] handle_input_list(String[] lst) throws ParseException {
        Map<String, Integer> map = new HashMap<>();
        List<String> results = new ArrayList<>();
        for(String str : lst){
            str = str.replace("{","");
            str = str.replace("}", "");
            String [] args  = str.split(",");
            String instruction = args[0].split(":")[1];
            String card_number = args[1].split(":")[1];
            if(instruction=="card"){

                String amount = args[2].split(":")[1];
                map.put(card_number, Integer.parseInt(amount));
            }
            else if(instruction=="auth"){
                if(checkAuth(card_number, args, map)){
                  results.add(createString(args,true));
                }
                else{
                    results.add(createString(args, false));
                }

            }
        }
        String [] output = new String[results.size()];
        int i = 0;
        for(String result : results){
            output[i++]=result;
        }

        return output;

    }

    private static String createString(String [] args, boolean approve) {
        StringBuilder str = new StringBuilder("");
        str.append("{");
        for(String arg : args){
            str.append(arg);
            str.append(", ");
        }
        str.append("\"approved\": ");
        if(approve){
            str.append("true");
        }
        else{
            str.append("false");
        }
        str.append("}");
        return str.toString();
    }

    private static boolean checkAuth(String card_number, String[] args, Map<String, Integer> map) {
        if(!map.containsKey(card_number)){
            return false;
        }
        int auth_amount = Integer.parseInt(args[2].split(":")[1]);
        if(auth_amount>map.get(card_number)){
            return false;
        }
        String country = args[5].split(":")[1];
        String industry = args[4].split(":")[1];
        if(country!="USA" || industry=="speculative" || industry=="precious metals"){
            return false;
        }
        return true;
    }

}
