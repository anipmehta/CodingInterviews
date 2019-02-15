import java.util.*;

/*
Exercise Goals:

    - The goal of this exercise is to show us how you apply software engineering
    principles to create a maintainable software solution.

    How to approach this:

            - Don't worry about persistence. It would make sense here, but for this
            exercise only use in-memory data structures.
            - Don't worry about tricks or "gotchyas", as there aren't any.
            - Just focus on writing clean maintainable code.



Specification:

    Create a class LeaderBoard whose interface includes the following methods:

    Method Name: add_score

        - Add a new score to the player's average. If a player doesn't exist in the
        LeaderBoard, they will be automatically added.

        Args:

                player_id (Integer): The player's ID.
                score (Integer): The score to record for the player

        Returns:

                Double: The new average score for the given player

    Method Name: top

        - Get the top player_ids on the leaderboard ordered by their average scores
        from highest to lowest

        Args:

                num_players (Integer): The maximum number of player_ids to return

        Returns:

                List<Integer>: a list of player_ids

    Method Name: reset

        - Removes any scoring information for a player, effectively
        resetting them to 0

        Args:

                player_id (Integer): The player's ID.

Example Usage:


    // Create a new LeaderBoard Instance
    LeaderBoard leader_board = new LeaderBoard();

    // Add scores for players to the LeaderBoard
    leader_board.add_score(1, 50); // 50.0
    leader_board.add_score(2, 80); // 80.0
    leader_board.add_score(2, 70); // 75.0
    leader_board.add_score(2, 60); // 70.0
    leader_board.add_score(3, 90); // 90.0
    leader_board.add_score(3, 85); // 87.5

    // Get top positions for the leaderboard
    leader_board.top(3); // [3, 2, 1]
    leader_board.top(2); // [3, 2]
    leader_board.top(1); // [3]

    // Reset a player 3's scores
    leader_board.reset(3); // void

    // Player 3 is now at the bottom of the leaderboard
    leader_board.top(3); // [2, 1, 3]

Expected values

    - Player IDs will always be positive integers small enough to be
    stored as a signed 32-bit integer Scores are integers ranging from 0-100


We have provided stubbed out code and tests for you below. Please note that these tests are not exhaustive and do not cover all corner cases. We recommend extending the given tests to ensure your code is correct.
*/



// Your code goes here. Feel free to make helper classes if needed

class LeaderBoard {
    private List<Player> players;
    private PriorityQueue<Player> maxHeap;
    private HashMap<Integer, Player> playerHashMap;
    public LeaderBoard(){
        playerHashMap = new HashMap<>();
        players = new ArrayList<>();
        maxHeap = new PriorityQueue<>(100, new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                if (o1.getAverage() == o2.getAverage())
                return 0;
                return o2.getAverage() > o1.getAverage() ? 1 : -1;
            }
        });
    }

    // O(logN) in worst case because of heapify operation as you are updating scores
    public Double add_score(Integer player_id, Integer score) {
        Player player;
        if(!playerHashMap.containsKey(player_id)){
            player = new Player(player_id);
            playerHashMap.put(player_id, player);
            maxHeap.offer(player);
        }
        player = playerHashMap.get(player_id);
        player.addScore(score);
        maxHeap.remove(player);
        maxHeap.offer(player);
        return player.getAverage();
    }

    // O(KlogN) k=number of top scorers, N = Number of players
    // since you are just using k elements from heap and each poll operation takes O(logN)
    // If we used TreeMap or used sorting it would have O(NlogN) so to improve top operation complexity I preferred to
    // use Max Heap
    public List<Integer> top(Integer max) {
        List<Player> topK = new ArrayList<>();
        while (max!=0){
            Player top = maxHeap.poll();
            topK.add(top);
            max--;
        }
        List<Integer> topKPlayersId = new ArrayList<>();
        for(Player player : topK){
            topKPlayersId.add(player.getPlayerId());
            maxHeap.offer(player);
        }
        return topKPlayersId;
    }
    // O(logN) in worst case because of heapify operation as I am resetting players score
    public void reset(Integer player_id) {
        Player player = playerHashMap.get(player_id);
        player.addScore(0);
        player.setGames(0);
        player.setAverage(0.0);
        maxHeap.remove(player);
        maxHeap.offer(player);

    }

}
class Player{
    private int playerId;
    private int games;
    private int score;
    private double average;

    public Player(int playerId){
        this.playerId = playerId;
        score = 0;
        games = 0;
        average = 0.0;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public int getGames() {
        return games;
    }

    public void setGames(int games) {
        this.games = games;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }
    public double addScore(int score){
        double newAverage = (getAverage() * getGames() + score ) / (getGames() + 1);
        this.setGames(this.getGames()+1);
        this.setScore(getScore() + score);
        this.setAverage(newAverage);
        return getAverage();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}


// Test code here
class Solution {
    public static void main(String[] args) {
        LeaderBoard leaderBoard = new LeaderBoard();
        leaderBoard.add_score(1, 50);
        System.out.println(leaderBoard.add_score(2, 80) == 80);
        System.out.println(leaderBoard.add_score(2, 70) == 75);
        System.out.println(leaderBoard.add_score(2, 60) == 70);
        System.out.println(leaderBoard.add_score(3, 90) == 90);
        System.out.println(leaderBoard.add_score(3, 85) == 87.5);


        System.out.println(leaderBoard.top(3).equals(Arrays.asList(3, 2, 1)));
        System.out.println(leaderBoard.top(2).equals(Arrays.asList(3, 2)));

        leaderBoard.reset(3);

        System.out.println(leaderBoard.top(3).equals(Arrays.asList(2, 1, 3)));
    }
}
