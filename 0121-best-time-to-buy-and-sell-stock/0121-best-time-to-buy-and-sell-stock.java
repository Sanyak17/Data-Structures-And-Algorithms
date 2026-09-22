class Solution {
    public int maxProfit(int[] prices) 
    {
        int n=prices.length;
        int[] mini=new int[n];
        mini[0]=prices[0];
        int maxi=0;
        for(int i=1;i<n;i++)
        {
            mini[i]=Math.min(prices[i],mini[i-1]);
            maxi=Math.max(prices[i]-mini[i],maxi);
        }
        return maxi;
        
    }
}