class Solution {
    private void rev(char s[],int i,int j) {
        while(i<j) {
            char c=s[i];
            s[i]=s[j];
            s[j]=c;
            i++;
            j--;
        }
    }
    public String reverseStr(String s, int k) {
        char st[]=s.toCharArray();
        int l=0;
        int r=k-1;
        while(r<s.length()) {
            rev(st,l,r);
            l+=2*k;
            r+=2*k;
        }
        if(l<s.length()) {
            rev(st,l,Math.min(l+k,s.length()-1));
        }
        return new String(st);
    }
}