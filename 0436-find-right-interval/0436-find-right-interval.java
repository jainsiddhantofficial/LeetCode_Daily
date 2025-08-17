class Pair{
    private int start;
    private int index;
    public Pair(int start, int index){
        this.start=start;
        this.index=index;
    }
    public int getStart(){ return this.start; }
    public int getIndex(){ return this.index; }
}

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        //if(intervals.length==1) return new int[]{-1};
        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            pairs.add(new Pair(intervals[i][0], i));
        }
        Collections.sort(pairs, (a,b) -> a.getStart() - b.getStart());
        int[] ans = new int[intervals.length];
        for(int i=0;i<ans.length;i++){
            ans[i] = binarySearch(pairs, intervals[i][1], i);
        }
    return ans;
    }
    public int binarySearch(List<Pair> pairs, int target, int curIndex){
        int start=0;
        int end = pairs.size()-1;
        int ans=-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(pairs.get(mid).getStart() >= target){
                ans = pairs.get(mid).getIndex();
                end = mid-1;
            }
            else start = mid+1;
        }
    return ans;
    }
}
