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
// class Solution {

//     public int earliestFinishTime(int[] landStart,
//                                   int[] landDuration,
//                                   int[] waterStart,
//                                   int[] waterDuration) {

//         int landCount = landStart.length;
//         int waterCount = waterStart.length;

//         // Earliest time any land ride can finish
//         int earliestLandFinish = Integer.MAX_VALUE;

//         for (int i = 0; i < landCount; i++) {
//             int finishTime = landStart[i] + landDuration[i];
//             earliestLandFinish = Math.min(earliestLandFinish, finishTime);
//         }

//         // Earliest time any water ride can finish
//         int earliestWaterFinish = Integer.MAX_VALUE;

//         // Final answer
//         int answer = Integer.MAX_VALUE;

//         /*
//          * Case 1:
//          * Complete a land ride first,
//          * then take a water ride.
//          */
//         for (int i = 0; i < waterCount; i++) {

//             int waterRideAvailableAt = waterStart[i];

//             int startWaterRide =
//                     Math.max(earliestLandFinish, waterRideAvailableAt);

//             int finishWaterRide =
//                     startWaterRide + waterDuration[i];

//             answer = Math.min(answer, finishWaterRide);

//             earliestWaterFinish = Math.min(
//                     earliestWaterFinish,
//                     waterStart[i] + waterDuration[i]
//             );
//         }

//         /*
//          * Case 2:
//          * Complete a water ride first,
//          * then take a land ride.
//          */
//         for (int i = 0; i < landCount; i++) {

//             int landRideAvailableAt = landStart[i];

//             int startLandRide =
//                     Math.max(earliestWaterFinish, landRideAvailableAt);

//             int finishLandRide =
//                     startLandRide + landDuration[i];

//             answer = Math.min(answer, finishLandRide);
//         }

//         return answer;
//     }
// }