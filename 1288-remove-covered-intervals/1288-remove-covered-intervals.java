class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        
        Arrays.sort(intervals,
            (a,b) -> {
                if(a[0] != b[0]){
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(b[1], a[1]);
            }
        );

        int maxLen = -1;
        int cnt = 0;

        for(int nums[] : intervals){

            if(nums[1] > maxLen){
                cnt++;
                maxLen = nums[1];
            }
        }
        return cnt;
    }
}