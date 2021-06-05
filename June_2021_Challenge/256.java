// 256. Paint House

// dp: iter from the end, update each previous step with min cost from next step

// memory: recursion each step, record cost in a map

class Solution {
    int[][] costs;
    HashMap<String, Integer> hm;
    public int minCost(int[][] costs) {
        //dp
        // for(int i=costs.length-2;i>=0;i--){
        //     costs[i][0] += Math.min(costs[i+1][1],costs[i+1][2]);
        //     costs[i][1]+= Math.min(costs[i+1][0],costs[i+1][2]);
        //     costs[i][2]+= Math.min(costs[i+1][0],costs[i+1][1]);
        // }
        // return Math.min(costs[0][0], 
        //                 Math.min(costs[0][1], costs[0][2]));
        this.costs=costs;
        hm=new HashMap<>();
        
        return Math.min(findMinCost(0,0), Math.min(findMinCost(0,1), findMinCost(0,2)));
    }
    public int findMinCost(int n, int color){
        if(hm.containsKey(getKey(n,color)))
            return hm.get(getKey(n,color));
        int curCost=costs[n][color];
        if(n==costs.length-1){}
        
        else if(color==0){
            curCost+= Math.min(findMinCost(n+1,1), findMinCost(n+1,2));
        }
        else if(color==1){
            curCost+= Math.min(findMinCost(n+1,0), findMinCost(n+1, 2));
        }
        else if(color==2){
            curCost+= Math.min(findMinCost(n+1, 0), findMinCost(n+1,1));
        }
        hm.put(getKey(n,color), curCost);
        return curCost;
    }
    private String getKey(int n, int color){
        return n+" "+color;
    }
}

