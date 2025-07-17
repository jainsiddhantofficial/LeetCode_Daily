class Solution {
    public int tribonacci(int n) {
       if(n==0){
        return 0;
       }else if(n==1||n==2){
        return 1;
       }
       int zero=0;
       int first=1;
       int second=1;
       for(int i=3;i<=n;i++){
        int tempnext=zero+first+second;
        zero=first;
        first=second;
        second=tempnext;
       }
       return second;
}
}