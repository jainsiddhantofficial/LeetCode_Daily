class Solution {
    public int[] singleNumber(int[] nums) {
        
        //unique total
        int xor =0;
        for(int i=0;i<nums.length;i++)
        {
            xor = xor ^ nums[i];
        }

        int rightmost = (xor & (xor - 1)) ^ xor;

        System.out.println(rightmost);

        int ones = 0;
        int zeros = 0;
        for(int i=0;i< nums.length;i++){

            if((nums[i] & rightmost) != 0) ones ^= nums[i];
            else zeros ^= nums[i];
        }

        int arr[] = {ones , zeros};

        return arr;
    }
}