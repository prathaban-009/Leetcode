class Solution {
    public int largestAltitude(int[] gain) {
        
        int max=0;
        int csum=0; 
        for(int i=0;i<gain.length;i++)
        {
            csum+=gain[i];
            max=Math.max(max,csum);
        }
        return max;
    }
}