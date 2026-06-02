class Solution {
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd) {

        int n=ls.length;
        int m=ws.length;

        int minL=3000;
        int minW=3000;
        int res=3000;

        for(int i=0;i<n;i++)
        {
            minL=Math.min(minL,ls[i]+ld[i]);
        }

        for(int i=0;i<m;i++ )
        {
            minW=Math.min(minW,ws[i]+wd[i]);
            res=Math.min(res,Math.max(minL,ws[i])+wd[i]);
        }

        for(int i=0;i<n;i++)
        {
            res=Math.min(res,Math.max(minW,ls[i]) +ld[i]);
        }

        return res;
        
    }
}
