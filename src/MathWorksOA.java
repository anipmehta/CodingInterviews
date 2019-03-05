import java.util.*;

public class MathWorksOA {
    public static List<Integer> connectedCities(int n, int g, List<Integer> originCities, List<Integer> destinationCities) {
        int[] srcArray = new int[n + 1];
        int[] cityIds = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            srcArray[i] = i;
            cityIds[i] = 1;
        }

        for (int i = g + 1; i <= n; i++)
            for (int j = 2 * i; j <= n; j += i)
                findConnections(j, i, srcArray, cityIds);

        List<Integer> res = new ArrayList<>(originCities.size());
        Iterator<Integer> itSrc = originCities.iterator();
        Iterator<Integer> itDest = destinationCities.iterator();

        for(int i=0;i<originCities.size();i++){
            res.add(getPath(originCities.get(i), srcArray) == getPath(destinationCities.get(i), srcArray) ? 1 : 0);
        }


        return res;
    }

    private static void findConnections(int src, int dest, int[] root, int[] ids) {
        int aRoot = getPath(src, root);
        int bRoot = getPath(dest, root);

        if (aRoot == bRoot)
            return;

        if (ids[aRoot] < ids[bRoot]) {
            root[aRoot] = root[bRoot];
            ids[bRoot] += ids[aRoot];
        } else {
            root[bRoot] = root[aRoot];
            ids[aRoot] += ids[bRoot];
        }
    }

    private static int getPath(int src, int[] root) {
        while (src != root[src])
            src = root[src];
        return src;
    }
}
