class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans= new ArrayList<>();
        int sum=0;
        trav(1,ans,new ArrayList<>(),sum,k,n);
        return ans;
    }
    public void trav(int i,List<List<Integer>> ans,ArrayList<Integer>temp,int sum,int k,int n){
        if(i>9){
        if(temp.size()==k){
            if(sum==n)ans.add(new ArrayList<>(temp));
            return;
        }
        return;
        }
        temp.add(i);
        trav(i+1,ans,temp,sum+i,k,n);
        temp.remove(temp.size()-1);
        trav(i+1,ans,temp,sum,k,n);
    }
}