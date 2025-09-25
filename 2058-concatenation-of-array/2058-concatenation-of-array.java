class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int j=2*n;

int[] arr=new int[j];
for(int i=0;i<n;i++){
arr[i]=nums[i];
arr[i+n]=nums[i];
}return arr;
    }
}