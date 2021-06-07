// 746. Min Cost Climbing Stairs

// mininum steps to current stair
// previous steps could from either i-1 th or i-2 th




class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp1=0, dp2=0;
        for(int i=2;i<cost.length+1;i++){
            int temp=dp1;
            dp1=Math.min(cost[i-1]+dp1, cost[i-2]+dp2);
            dp2=temp;
        }
        return dp1;
    }
}