class Solution {
    public int rob(int[] nums) 
    {
        int n=nums.length;
        Integer[] dp=new Integer[n];
        return solveMem(n-1,nums,dp);
    }
    public int solveMem(int idx,int[] nums,Integer[]dp)
    {
        if (idx < 0) return 0;
        if(idx==0)
        {
            return nums[0];
        }
        if(dp[idx]!=null)
        return dp[idx];
        int npick=solveMem(idx-1,nums,dp);
        int pick=nums[idx]+solveMem(idx-2,nums,dp);
        return dp[idx]=Math.max(npick,pick);
    }
}