1383. Maximum Performance of a Team


class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int modulo = (int) Math.pow(10, 9) + 7;
        
        int[][] pairs = new int[n][2];
        for(int i=0;i<n;i++)
            pairs[i]= new int[]{efficiency[i], speed[i]};
        
        
        // sort the members by their efficiencies
        Arrays.sort(pairs,(a,b) -> b[0]-a[0]);

        // create a heap to keep the top (k-1) speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        long speedSum = 0, perf = 0;
        for (int[] p : pairs) {
            int currEfficiency = p[0];
            int currSpeed = p[1];
            // maintain a heap for the fastest (k-1) speeds
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.remove();
            }
            speedHeap.add(currSpeed);

            // calculate the maximum performance with
            // the current member as the least efficient one in the team
            speedSum += currSpeed;
            perf = Math.max(perf, speedSum * currEfficiency);
        }
        return (int) (perf % modulo);
    }
}