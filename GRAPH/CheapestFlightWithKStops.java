import java.util.*;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class CheapestFlightWithKStops {

    public static int findCheapestPrice(
            int n,
            int[][] flights,
            int src,
            int dst,
            int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build adjacency list
        for (int i = 0; i < flights.length; i++) {

            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];

            adj.get(u).add(new Pair(v, cost));
        }

        // {stops, node, cost}
        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0, src, 0));

        // Minimum cost to reach every node
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[src] = 0;

        while (!q.isEmpty()) {

            Tuple it = q.peek();
            q.remove();

            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            // More than K stops
            if (stops > k) {
                continue;
            }

            // Explore neighbours
            for (Pair iter : adj.get(node)) {

                int adjNode = iter.first;
                int edW = iter.second;

                if (cost + edW < dist[adjNode] && stops <= k) {

                    dist[adjNode] = cost + edW;

                    q.add(
                        new Tuple(
                            stops + 1,
                            adjNode,
                            cost + edW
                        )
                    );
                }
            }
        }

        if (dist[dst] == (int) 1e9) {
            return -1;
        }

        return dist[dst];
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] flights = {
            {0, 1, 100},
            {1, 2, 100},
            {2, 3, 100},
            {0, 3, 500}
        };

        int src = 0;
        int dst = 3;
        int k = 2;

        int answer = findCheapestPrice(
            n,
            flights,
            src,
            dst,
            k
        );

        System.out.println(answer);
    }
}