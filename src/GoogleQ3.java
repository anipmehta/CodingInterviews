import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleQ3 {
    public static void main(String [] args){
//      String[] L = {"a.b@example.com","x@example.com","x@exa.mple.com","ab+1@example.com", "y@example.com", "y@example.com", "y@example.com"};
      String[] L = {"a++@google.com","a..@google.com"};
      int res = solution(L);
      System.out.println(res);
    }
    public static int solution(String[] L){
        Map<String, List<String>> map = new HashMap<>();
        for(String email: L){
            String [] splittedEmail = email.split("@");
            String local = splittedEmail[0];
            String domain = splittedEmail[1];
            local = local.replaceAll("\\.","");
            String [] str = local.split("\\+");
            local = local.split("\\+")[0];
            String uniqueKey = local + "@" + domain;
            if(!map.containsKey(uniqueKey)){
                map.put(uniqueKey, new ArrayList<>());
            }
            map.get(uniqueKey).add(email);
        }
        int groupCount=0;
        for(String key: map.keySet()){
            if(map.get(key).size()>=2){
                groupCount++;
            }
        }
        return groupCount;
    }
}
