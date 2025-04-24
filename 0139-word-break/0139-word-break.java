class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        HashSet<String>hs = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[n+1];
        return wordBreak(s,hs,0,dp);
    }
    public boolean wordBreak(String str, HashSet<String>hs,int j,Boolean[] dp)
    {
        if(j >= str.length()){
            return true;
        }
        if(dp[j] != null)
        {
            return dp[j];
        }
        for(int i=j;i<str.length();i++)
        {
            if(hs.contains(str.substring(j,i+1)))
            {
                if(wordBreak(str,hs,i+1,dp)){
                    dp[j]=true;
                    return dp[j];
                }
            }
        }

        return dp[j] = false;
    }
}