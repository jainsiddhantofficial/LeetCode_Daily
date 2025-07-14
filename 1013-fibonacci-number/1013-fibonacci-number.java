class Solution {
    public int fib(int n) {
        if( n == 0 ) return 0;
        if( n == 1 ) return 1;
        
        int first = 0;
        int second = 1;
        int sum = 0;
        int i = 2;
        while ( i <= n ){
            sum = first + second;
            first = second;
            second = sum;
            i++;
        }
        return sum;
    }
}