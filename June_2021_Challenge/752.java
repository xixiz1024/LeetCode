// 752. Open the Lock



// each step for 4 digits number, each digit may have 2 possible movements, +1 or -1
// each 4 digits number may have at most 8 different moves, that take the original 4 digit 1 step
// then the 2nd move may have 8*8=64 possibilities, so on and so forth, 3nd move => 8*8*8=512 ... 
// under condition these protentials are not in set 'deadends'.

class Solution {
    public int openLock(String[] deadends, String target) {
        
        HashSet<String> deadset = new  HashSet<String>();
        for(int i=0;i<deadends.length;i++)
            deadset.add(deadends[i]);
        
        if(deadset.contains("0000") || deadset.contains(target)) return -1;
        
        HashSet<String> visited = new HashSet<>();
        visited.add("0000");
        
        Queue<String> moves = new LinkedList<>();
        moves.add("0000");
        moves.add(null);
        
        int step=0;
        while(moves.size()!=0){
            String cur = moves.poll();
            if(cur==null){
                step++;
                moves.add(null);
            }
            
            else if ( cur.equals(target))
                return step;
            
            else if (!deadset.contains(cur)){
                for(int i=0;i<4;i++){
                    int d = (int)(cur.charAt(i)-'0');
                    for(int j=-1;j<=1;j+=2){
                        int makeMove = (d+j+10)%10;
                        String nextMove = cur.substring(0,i)+(""+makeMove)+cur.substring(i+1);
                        if( !visited.contains(nextMove)){
                            visited.add(nextMove);
                            moves.add(nextMove);
                        }
                    }
                }
                
                
                
            }
        }
        
        return -1;
    }
}

