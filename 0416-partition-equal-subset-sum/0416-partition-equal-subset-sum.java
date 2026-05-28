class Solution {
    int sum=0;
    int dp[][];
    boolean func(int i,int csum,int target,int nums[])
    {
         if (csum == target)
            return true;

         
        if (i == nums.length || csum > target)
            return false;

        if(dp[i][csum]==1)return true;
        if(dp[i][csum]==-1)return false;

        csum+=nums[i];
        boolean take=func(i+1,csum,target,nums);
        csum-=nums[i];
        boolean notTake=func(i+1,csum,target,nums);

        dp[i][csum]=take||notTake?1:-1;

        return take || notTake;

    }
    public boolean canPartition(int[] nums) {

        if(nums.length==1)return false;

        for(int num:nums)sum+=num;

         dp=new int[nums.length][sum];

        if(sum%2!=0)return false;

        return func(0,0,sum/2,nums);
        
    }
}