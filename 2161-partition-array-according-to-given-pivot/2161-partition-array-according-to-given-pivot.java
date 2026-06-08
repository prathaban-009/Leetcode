class Solution {
    private void reverse(int arr[],int start,int end)
    {
        while(start<=end)
        {
            int temp=arr[start];
            arr[start++]=arr[end];
            arr[end--]=temp;
        }
    }
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int ans[]=new int[n];

        int s=0;
        int e=n-1;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<pivot)
            {
                ans[s++]=nums[i];

            }else if(nums[i]>pivot)
            {
                ans[e--]=nums[i];
            }
        }
        // e++;

        while(s<=e)
        ans[s++]=pivot;

        reverse(ans,e+1,n-1);

        return ans;
        
    }
}