class Solution {
    public int arrangeCoins(int n) {
        if(n<0)
        return 0;
        if(n==1)
        return 1;
        int k=1;
        while(n>=k)
        {
            n=n-k;
            k++;
        }
        return k-1;
    }
}