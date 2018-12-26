import java.util.*;

public class Bloomberg4 {
    public static class Flight{
        public String src;
        public String dest;
        public int dur;
        public Flight(String src, String dest, int duration){
            this.src = src;
            this.dest = dest;
            this.dur = duration;
        }
    }
    public static void main(String [] args){
        List<String> input = new ArrayList<>();
        Scanner stdin = new Scanner(System.in);
        while(stdin.hasNextLine())
        {
            input.add((stdin.nextLine()));
        }
        stdin.close();
        int size = Integer.parseInt(input.get(0));
        List<String> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            list.add(input.get(1+i));
        }
        output(list, input.get(input.size()-1));

    }
    public static void output(List<String> input, String last){
        Map<Integer, List<Flight>> map = new HashMap<>();
        for(String str : input){
            String [] args = str.split(" ");
            String src = args[0];
            String dest = args[1];
            Integer dur = Integer.parseInt(args[2]);
            Flight flight = new Flight(src, dest, dur);
            int flights = Integer.parseInt(args[3]);
            for(int i = 0;i<flights;i++){
                int time = Integer.parseInt(args[4+i]);
                if(!map.containsKey(time)){
                    map.put(time, new ArrayList<>());
                }
                map.get(time).add(flight);
            }
        }
        String arr []  = last.split(" ");
        int arrival = Integer.parseInt(arr[2]);
        int max = Integer.MIN_VALUE;
        int distance = 0;
        for(int time : map.keySet()){
            if(time>=arrival){
                distance = helper(map, arr[0], arr[1], 0, arrival);
                max = Math.max(max, distance);
            }
        }
        if(max==-1){
            System.out.println("IMPOSSIBLE");
        }
        else{
            System.out.println(max);
        }
    }
    public static int helper(Map<Integer, List<Flight>> map, String src, String dest, int distance, int arrival){
        if(!map.containsKey(arrival)){
            int max = Integer.MIN_VALUE;
            for(int time : map.keySet()){
                if(time>=arrival){
                    distance = helper(map, src, dest, 0, arrival);
                    max = Math.max(max, distance);
                }
            }
            return max;
        }
        else{
            for(Flight flight : map.get(arrival)){
                if(flight.dest==dest){
                    return distance;
                }
                else if(flight.src==src){
                    return helper(map, flight.src, dest, distance + flight.dur, arrival + flight.dur);
                }
            }
            return -1;
        }



    }
}
