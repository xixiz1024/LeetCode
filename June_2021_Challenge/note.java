

int[][] pairs = new int[n][2];
        for(int i=0;i<n;i++)
            pairs[i]= new int[]{efficiency[i], speed[i]};

// lamda array[][]
Arrays.sort(pairs,(a,b) -> b[0]-a[0]);

// lamda Queue
PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

// 10^9 + 7
int modulo = (int) Math.pow(10, 9) + 7;



List<Pair<Integer, Integer>> candidates = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            candidates.add(new Pair(efficiency[i], speed[i]));
        }
// lamda list 
Collections.sort(candidates, Comparator.comparing(o -> -o.getKey()));