class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int n1=nums1.length;
        int n2=nums2.length;

        for(int i=0;i<n1;i++)
        {
            pq.offer(new int[]{nums1[i]+nums2[0],0} );
        }

        while(k>0 && !pq.isEmpty())
        {
            int pair[]=pq.poll();
            int sum=pair[0];
            int index=pair[1];

            List<Integer> cPair=new ArrayList<>();
            int cValue=sum-nums2[index];
            cPair.add(sum-nums2[index]);
            cPair.add(nums2[index]);
            ans.add(cPair);

            if(index+1<n2)
            {
                pq.offer(new int[]{cValue+nums2[index+1],index+1});
            }

            k--;
        }

        return ans;
    }
}