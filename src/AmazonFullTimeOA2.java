import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonFullTimeOA2 {
    ArrayList<Integer> IDsOfSongs(int rideDuration,
                                  ArrayList<Integer> songDurations)
    {
        // WRITE YOUR CODE HERE
        List<Song> list = new ArrayList<>();
        // creating a list of song class that would store id and duration
        for(int i=0;i<songDurations.size();i++){
            list.add(new Song(songDurations.get(i), i));
        }
        // sorting list on the basis of duration of songs using comparator
        Collections.sort(list, new Comparator<Song>(){
            public int compare(Song a, Song b){
                return a.duration-b.duration;
            }
        });
        // finding pair whose sum equals target using 2 ppointers
        int start = 0;
        int end = list.size()-1;
        int target = rideDuration - 30;
        ArrayList<Integer> result = new ArrayList<>();
        while(start<end){
            int sum = list.get(start).duration + list.get(end).duration;
            if(sum<target){
                start++;
            }
            else if(sum==target){
                result.add(list.get(start).id);
                result.add(list.get(end).id);
                return result;
            }
            else{
                end--;
            }
        }
        return new ArrayList<>();
    }
    // METHOD SIGNATURE ENDS
}

class Song{
    int duration;
    int id;
    Song(int duration, int id){
        this.duration = duration;
        this.id = id;
    }
}
