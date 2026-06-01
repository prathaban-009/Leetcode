class Solution {
    public int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int tcost=0;
        int l=0;

        for(int i=cost.length-1;i>=0;i--)
        {
            l++;
            if(l%3!=0)tcost+=cost[i];
        }
        return tcost;
        
    }
}