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
//    static Set<List<String>> possiblePaths;
    public static String[] getPath(Map<String, String[]> graph, String startNode, String endNode) {

        // find the shortest route in the network between the two users
        if(!graph.containsKey(startNode) || !graph.containsKey(endNode)){
            throw new IllegalArgumentException("Start/End node not in graph");
        }
//        Queue<String> queue = new ArrayDeque<>();
//        Map<String, String> path = new HashMap<>();
//        path.put(startNode, null);
//        queue.add(startNode);
//        while(!queue.isEmpty()){
//            String current = queue.remove();
//            for(String neighbour : graph.get(current)){
//                if(neighbour.equals(endNode)){
//                    return retracePath(path, startNode, endNode);
//                }
//                if(!path.containsKey(neighbour)){
//                    queue.add(neighbour);
//                    path.put(neighbour, current);
//                }
//            }
//        }
//        return null;
        Set<List<String>> possiblePaths = new HashSet<>();
        dfs(graph, startNode, endNode, new ArrayList<>(), new HashSet<>(), possiblePaths);
        if(possiblePaths.size()==0){
            return null;
        }
        List<List<String>> list = new ArrayList<>(possiblePaths);
        Collections.sort(list, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.size() - o2.size();
            }
        });
        return list.get(0).toArray(new String[list.get(0).size()]);
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

    public static void dfs(Map<String, String[]> graph, String startNode, String endNode, List<String> currentPath, Set<String> visited, Set<List<String>> possiblePaths){
        if(startNode.equals(endNode)){
            currentPath.add(endNode);
            possiblePaths.add(new ArrayList<>(currentPath));
        }
        currentPath.add(startNode);
        visited.add(startNode);
        for (String neighbour : graph.get(startNode)){
            if(!visited.contains(neighbour)){
                visited.add(neighbour);
                dfs(graph, neighbour, endNode, currentPath, visited, possiblePaths);
            }
        }
        currentPath.remove(startNode);
        visited.remove(startNode);
    }
    private static Map<String, String[]> getNetwork() {
        return new HashMap<String, String[]>() { {
            put("a", new String[] {"b", "c", "d"});
            put("b", new String[] {"a", "d"});
            put("c", new String[] {"a", "e"});
            put("d", new String[] {"a", "b"});
            put("e", new String[] {"c"});
            put("f", new String[] {"g"});
            put("g", new String[] {"f"});
        }};
    }
    public static void main(String[] args) {
        final String[] actual = getPath(getNetwork(), "a", "c");
        System.out.println(actual.length);
    }
}

