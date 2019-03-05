import java.util.*;

public class MinMeetingRooms {
    public static void main(String [] args){
        MinMeetingRooms minMeetingRooms = new MinMeetingRooms();
        List<TimeInterval> list = new ArrayList<>();
        list.add(new TimeInterval(2,4));
        list.add(new TimeInterval(2, 3));
        list.add(new TimeInterval(3,4));
        System.out.println(minMeetingRooms.minRooms(list));
    }
    public int minRooms(List<TimeInterval> timeIntervalList){
        Collections.sort(timeIntervalList, new Comparator<TimeInterval>() {
            @Override
            public int compare(TimeInterval o1, TimeInterval o2) {
                return o1.start-o2.start;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int rooms = 1;
        int max = rooms;
        for(TimeInterval timeInterval : timeIntervalList){
            if(!pq.isEmpty() && timeInterval.start<pq.peek()){
                rooms++;
                max = Math.max(rooms, max);
            }
            else{
                pq.offer(timeInterval.end);
                rooms--;
            }
        }
        return rooms;
    }
}
class TimeInterval{
    int start;
    int end;
    public TimeInterval(int start, int end){
        this.start = start;
        this.end = end;
    }
}
