import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class GoogleQ2 {
    public List<String> topTen(List<Movie> movies){
        PriorityQueue<Movie> heap = new PriorityQueue<>(1, new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.watch - o2.watch;
            }
        });
        for(Movie movie : movies){
            heap.add(movie);
            if(heap.size()>1){
                heap.poll();
            }
        }
        List<String> topTen = new ArrayList<>();
        while(!heap.isEmpty()){
            topTen.add(heap.poll().name);
        }
        return topTen;
    }

    public static void main(String [] args){
        GoogleQ2 googleQ2 = new GoogleQ2();
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("SholaY", 50));
        movies.add(new Movie("3idiots", 100));
        movies.add(new Movie("sholay", 50));
        googleQ2.topTen(movies);
    }

    public static class Movie{
        private String name;
        private int watch;
        public Movie(String name, int watch){
           this.name = name;
           this.watch = watch;
        }
    }
}

