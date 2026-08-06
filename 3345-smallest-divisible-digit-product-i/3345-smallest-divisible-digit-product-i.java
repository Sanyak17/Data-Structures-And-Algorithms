class Solution {
    public int smallestNumber(int n, int t) 
    {
        int i=n;
        while (true)
        {
            int temp=i;
            int p=1;
            while(temp>0)
            {
                int l=temp%10;
                p=l*p;
                temp=temp/10;
            }
            if(p%t==0)
            {
                return i;
            }
            i++;
        }
    }
}