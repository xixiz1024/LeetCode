// ----------------------
// the area is the product of the max difference of heights and widths
// ----------------------

class Solution {
    public int maxArea(int h, int w, int[] hCuts, int[] vCuts) {
        Arrays.sort(hCuts);
        Arrays.sort(vCuts);
        int max_h=hCuts[0], max_v=vCuts[0];
        for( int i=1;i<hCuts.length;i++)
            max_h=Math.max(max_h, (hCuts[i]-hCuts[i-1]));
        for( int j=1;j<vCuts.length;j++)
            max_v=Math.max(max_v, (vCuts[j]-vCuts[j-1]));
        max_h=Math.max(max_h, (h-hCuts[hCuts.length-1]));
        max_v=Math.max(max_v, (w-vCuts[vCuts.length-1]));
        return (int)((long)max_h*max_v % 1000000007);
    }
}


// 1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts

// Given a rectangular cake with height h and width w, and two arrays of integers 
// horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the 
// top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] 
// is the distance from the left of the rectangular cake to the jth vertical cut.

// Return the maximum area of a piece of cake after you cut at each horizontal 
// and vertical position provided in the arrays horizontalCuts and verticalCuts. 
// Since the answer can be a huge number, return this modulo 10^9 + 7.