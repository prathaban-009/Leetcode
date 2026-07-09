class Solution {
    class DSU{
        int rank[];
        int parent[];

        DSU(int n)
        {
            rank=new int[n+1];
            parent=new int[n+1];

            for(int i=0;i<n+1;i++)
            {
                parent[i]=i;
            }
        }

        int find(int node)
        {
            if(parent[node]==node)
            return node;
            return parent[node]=find(parent[node]);
        }

        void union(int u,int v)
        {
            int rootU=find(u);
            int rootV=find(v);

            if(rootU==rootV)
            return;

            if(rank[rootU]>rank[rootV])
            {
                parent[rootV]=rootU;
            }else if(rank[rootU]<rank[rootV])
            {
                parent[rootU]=rootV;
            }else{
                parent[rootV]=rootU;
                rank[rootU]++;
            }
        }

        boolean isConnected(int u, int v) {

            return find(u) == find(v);
        }
    }
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        int qn=queries.length;
        boolean[] ans = new boolean[qn];
        DSU dsu = new DSU(n);

        for (int i = 1; i < n; i++) {

            if (nums[i] - nums[i - 1] <= maxDiff) {
                dsu.union(i, i - 1);
            }

        }

        int k=0;
        for(int query[]:queries)
        {
            ans[k++]=dsu.isConnected(query[0],query[1]);
        }

        return ans;
        
    }
}