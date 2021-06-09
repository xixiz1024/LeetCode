// 1696. Jump Game VI

// - each time move at most k steps until last element, found the max value

//  decreasing order in pq, by value, and with index
//      - value to hold max by checking steps
//      - index to measure if in range of i-k
// if out of range, no longer needed, remove (since could have larger # but no useful)
// store current max+current value then add in pq with index

class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->b[0]-a[0]);
        pq.add(new int[]{nums[0],0});
        int score=nums[0];
        for(int i=1;i<nums.length;i++){
            while(pq.peek()[1]<i-k)
                pq.remove();
            score = pq.peek()[0]+nums[i];
            pq.add(new int[]{score,i});
        }
        return score;
    }
    
}