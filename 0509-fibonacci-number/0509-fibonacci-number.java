class Solution 
{
    public int fib(int n) 
    {
       // return fibrec(n);
       Integer[] dp=new Integer[n+1];
       //return fibmem(n,dp);
       return fibtab(n);
    }
    public int fibrec(int n) //rec
    {
        if(n==0)
        return 0;
        if(n==1)
        return 1;
        return fibrec(n-1)+fibrec(n-2);
    }
    public int fibmem(int n,Integer[] dp)
    {
        if(n==0)
        return 0;
        if(n==1)
        return 1;
        if(dp[n]!=null)
        return dp[n];
        return dp[n]=fibmem(n-1,dp)+fibmem(n-2,dp);
    }
    public int fibtab(int n)
    {
        if (n <= 1) return n;
        Integer[] dp=new Integer[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-2]+dp[i-1];
        }
        return dp[n];
    }
}