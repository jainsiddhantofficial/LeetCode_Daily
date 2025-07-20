class Solution {
    int max = -1;
    HashMap<String,Boolean> dp=new HashMap<>();
    public int maxWeight(int n, int[][] edges, int k, int t) {
        ArrayList<int[]>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i]=new ArrayList<>();

        for(int[] e: edges)
            graph[e[0]].add(new int[]{e[1],e[2]});

        for(int i=0;i<n;i++){
            find(graph,k,t,0,i);
        }

        return max;
    }

    void find(ArrayList<int[]>[] graph,int k,int t,int sum,int x){
        if(k<=0)
        {
            if(sum<t)
                max=Math.max(max,sum);
            return ;
        }

        if(sum>=t)
            return;
        String key=Integer.toString(k)+"#"+Integer.toString(sum)+"#"+Integer.toString(x);
        if(dp.containsKey(key))
            return;
        for(int[] node: graph[x]){
            find(graph,k-1,t,sum+node[1],node[0]);
        }

        dp.put(key,true);
    }
}