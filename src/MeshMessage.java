import java.util.*;

//  Map<String, String[]> network = new HashMap<String, String[]>() {{
//          put("Min",     new String[] { "William", "Jayden", "Omar" });
//          put("William", new String[] { "Min", "Noam" });
//          put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
//          put("Ren",     new String[] { "Jayden", "Omar" });
//          put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
//          put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
//          put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
//          put("Noam",    new String[] { "Nathan", "Jayden", "William" });
//          put("Omar",    new String[] { "Ren", "Min", "Scott" });
//          ...
//          }};


public class MeshMessage{
    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

        // find the shortest route in the network between the two users
        if(!graph.containsKey(startNode) || !graph.containsKey(endNode)){
            throw new IllegalArgumentException("Start/End node not in graph");
        }
        Queue<String> queue = new ArrayDeque<>();
        Map<String, String> path = new HashMap<>();
        path.put(startNode, null);
        queue.add(startNode);
        while(!queue.isEmpty()){
            String current = queue.remove();
            for(String neighbour : graph.get(current)){
                if(neighbour.equals(endNode)){
                    return retracePath(path, startNode, endNode);
                }
                if(!path.containsKey(neighbour)){
                    queue.add(neighbour);
                    path.put(neighbour, current);
                }
            }
        }
        return null;
    }

    private static String[] retracePath(Map<String,String> path, String startNode, String endNode) {
        String current = endNode;
        ArrayList<String> output = new ArrayList<>();
        while (current!=null){
            output.add(current);
            current = path.get(current);
        }
        Collections.reverse(output);
        return (String[]) output.toArray();
    }
}
