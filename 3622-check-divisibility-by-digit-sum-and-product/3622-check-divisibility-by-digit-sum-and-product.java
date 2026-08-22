class Solution {
    public boolean checkDivisibility(int n) 
    {
        int s=sum(n);
        int p=prod(n);
        int sum=s+p;
        return (n%sum==0);
    }
    public int sum(int n)
    {
        int s=0;
        while(n>0)
        {
            s+=n%10;
            n=n/10;
        }
        return s;
    }
    public int prod(int n)
    {
        int p=1;
        while(n>0)
        {
            p=p*(n%10);
            n=n/10;
        }
        return p;
    }
}