class Solution {
    public boolean hasGroupsSizeX(final int[] deck) {
        final int[] count = new int[10000];

        for(int c : deck)
            count[c]++;

        int g = -1;

        for(int i = 0; i < 10000; ++i)
            if(count[i] > 0) {
                if(g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public int gcd(final int x, final int y) {
        return x == 0 ? y : gcd(y % x, x);
    }
}