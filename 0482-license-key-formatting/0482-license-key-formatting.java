class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String temp= s.replaceAll("-", "").toUpperCase();        
        StringBuilder result= new StringBuilder();
        int count = 0;
        for (int i=temp.length()-1;i>=0;i--){
            if (count==k) {
                result.append("-");
                count=0;
            }
            result.append(temp.charAt(i));
            count++;
        }
        return result.reverse().toString();
    }
}