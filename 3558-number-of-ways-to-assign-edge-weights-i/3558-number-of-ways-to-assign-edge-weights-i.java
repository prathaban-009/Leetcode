import java.util.*;

class Solution {

    private static final int mod = 1_000_000_007;
    List<List<Integer>> graph;

    public int assignEdgeWeights(int[][] edges) {
        int maxNode = 0;
        for (int[] edge : edges) {
            maxNode = Math.max(maxNode, edge[0]);
            maxNode = Math.max(maxNode, edge[1]);
        }

        graph = new ArrayList<>();

         
        for (int i = 0; i <= maxNode; i++) {
            graph.add(new ArrayList<>());
        }
         
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
       
        long depth = dfs(1, -1);
        return (int) pow(2, depth - 1);
    }



    private long dfs(int node, int prev) {
        long maxDepth = 0;
        for (int child : graph.get(node)) {
            if (child != prev) {
                maxDepth = Math.max(
                        maxDepth,
                        dfs(child, node) + 1
                );
            }
        }

        return maxDepth;
    }
    private long pow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }

        return result;
    }
}