class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

         Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(b[1], a[1]); // right descending
        });

        int max = -1;
        int cnt = 0;
        for(int num[] : intervals){

            if(num[1] > max){
                cnt++;
                max = num[1];
            }
        }
        return cnt;



        
    }
}