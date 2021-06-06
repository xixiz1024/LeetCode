// 128 . Longest Consecutive Sequence

// O(n)
// using Set


class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int num: nums)
            hs.add(num);
        
        int maxLen=0;
        for(int num: nums){
            // if set contains the smaller consecutive num
            // will operate until find the smallest
            if(!hs.contains(num-1)){
                int curNum=num;
                int count=1;
                while(hs.contains(curNum+1)){
                    curNum++;
                    count++;
                }
                maxLen=Math.max(maxLen, count);
            }  
        }
        return maxLen;
    }
}