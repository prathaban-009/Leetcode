class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        List<List<Integer>> fans = new ArrayList<>();

        int n=grid.length;
        int m=grid[0].length;




        int ans[][]=new int[n][m];
        int total=m*n;

        k%=total;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int idx=i*m+j;

                int newidx=(idx+k)%total;
                int newi=newidx/m;
                int newj=newidx%m;

                ans[newi][newj]=grid[i][j];
            }
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(j==0)
                fans.add(new ArrayList<>());

                fans.get(i).add(ans[i][j]);
            }
        }

        return fans;


        
    }
}