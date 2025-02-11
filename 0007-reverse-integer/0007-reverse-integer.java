class Solution {
    public int reverse(int x) {
        int reverseNumber = 0;
        while(x != 0){
          int div = x%10;
           if(reverseNumber >Integer.MAX_VALUE/10 || reverseNumber <Integer.MIN_VALUE/10){
            return 0;
           }
          reverseNumber = (reverseNumber *10) + div;
          x/=10;
        }
        return reverseNumber;
    }
}