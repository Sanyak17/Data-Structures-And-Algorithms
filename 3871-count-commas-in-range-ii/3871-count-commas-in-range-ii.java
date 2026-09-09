class Solution {
    public long countCommas(long n) 
    {
        long count=0;
        if(n>=1000)
        {
                count+=Math.min(n,999999)-999;
        }
        if(n>=1000000)
        {
                count+=(Math.min(n,999999999)-999999)*2;
        }
        if(n>=1000000000)
        {
                count+=(Math.min(n,999999999999L)-999999999)*3;
        }
        if(n>=1000000000000L)
        {
                count +=(Math.min(n,999999999999999L)-999999999999L)*4;
        }
        if(n>=1000000000000000L)
            count+=(n-999999999999999L)*5;
        return count;
        
    }
}