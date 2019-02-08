import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleTelephonic1 {
    public int min = Integer.MAX_VALUE;
    public static class Exchange{
    public int price;
    public String start;
    public String end;
    public Exchange(String start, String end, int price){
        this.start = start;
        this.end = end;
        this.price = price;
    }
    }
    public static void main(String [] args){
    List<Exchange> list = new ArrayList<>();
    list.add(new Exchange("INR", "DOLL", 70));
    list.add(new Exchange("INR", "EURO", 95));
    list.add(new Exchange("DOLL", "EURO", 25));
    GoogleTelephonic1 googleTelephonic1 = new GoogleTelephonic1();
    System.out.println(googleTelephonic1.findMinRate(list, "INR", "EURO"));
    }
    public int findMinRate(List<Exchange> exchanges, String startCurr, String endCurr){
    Map<String, List<Exchange>> map = new HashMap<>();
    for (Exchange exchange : exchanges){
        if(!map.containsKey(exchange.start)){
            map.put(exchange.start, new ArrayList<>());
        }
        map.get(exchange.start).add(exchange);
    }
    helper(map, startCurr, endCurr, 0, false);
    return min == Integer.MAX_VALUE ? -1 : min;
    }
    public void helper(Map<String, List<Exchange>> map, String start, String end, int current, boolean found){
        if(start==end){
            min = Math.min(current, min);
            found = true;
        }
        if (found) {return;}
        if(!map.containsKey(start)){
            return;
        }
        if(current>min)return;

        for(Exchange exchange : map.get(start)){
               helper(map, exchange.end, end, current + exchange.price, found);
        }
    }

}
