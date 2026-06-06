class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int n=nums.length;
        int ans[]=new int[n];
        int rev[]=new int[n];
        int sum1=0;
        int prev=0;
        for(int i=n-1;i>=0;i--)
        {
           rev[i]=prev;
           prev+=nums[i];
        }
        // System.out.println(Arrays.toString(rev));
        prev=0;
        for(int i=0;i<n;i++)
        {
            sum1=prev;
            ans[i]=Math.abs(sum1-rev[i]);
            prev+=nums[i];
        }

        return ans;
    }
}