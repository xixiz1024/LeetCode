// 505. The Maze II

//dfs:
// for each direction, move until hit the wall
// when stopped, measure if current weight is greater than path from 'start' + count
// if so: replace with current value
// recursion call: 'start' updated to the new point was moved from above steps


class Solution {
    int[][] distance;
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        distance= new int[maze.length][maze[0].length];
        for(int[] d:distance)
            Arrays.fill(d,Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;
        dfs(maze, start);
        return distance[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:distance[destination[0]][destination[1]];
    }
    
    public void dfs(int[][] maze, int[] start ){
        int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        
        for(int[] dir:direction){
            int x= start[0]+dir[0],
                y= start[1]+dir[1];
            int count=0;
            while(x>=0 && y>=0 && y<maze[0].length && x<maze.length && maze[x][y]==0 ){
                x+=dir[0];
                y+=dir[1];
                count++;
            }
            if(distance[start[0]][start[1]]+count<distance[x-dir[0]][y-dir[1]]){
                distance[x-dir[0]][y-dir[1]]=distance[start[0]][start[1]]+count;
            dfs(maze, new int[]{x-dir[0],y-dir[1]});
            }
        }
    }
}