class Solution {

    int f(int grid[][],int dp[][],int i,int j)
    {
        if(i>=grid.length || i<0) return (int)1e9;
        if(j>=grid[0].length || j<0) return (int)1e9;

        if(i == grid.length-1 && j == grid[0].length-1)
            return grid[i][j];

        if(dp[i][j]!=-1)return dp[i][j];

        // System.out.println("move forward towards"+i+"|"+j);
        // for(int k=0;k<grid.length;k++)
        // {
        //     for(int l=0;l<grid[0].length;l++)
        //     System.out.print(dp[k][l]+" ");

        //     System.out.println();
        // }

        int f=grid[i][j]+f(grid,dp,i,j+1);
        
        // System.out.println("move downward towards"+(i+1)+"|"+j);
        // for(int k=0;k<grid.length;k++)
        // {
        //     for(int l=0;l<grid[0].length;l++)
        //     System.out.print(dp[k][l]+" ");

        //     System.out.println();
        // }
        int s=grid[i][j]+f(grid,dp,i+1,j);

        // System.out.println("move backwards"+(i+1)+"|"+j);
        // for(int k=0;k<grid.length;k++)
        // {
        //     for(int l=0;l<grid[0].length;l++)
        //     System.out.print(dp[k][l]+" ");

        //     System.out.println();
        // }
         
        return dp[i][j]=Math.min(f,s);
    }

    public int minPathSum(int[][] grid) {

        int dp[][]=new int[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++)Arrays.fill(dp[i],-1);

        return f(grid,dp,0,0);
        
    }
}