class Solution
{
    public int findTargetSumWays(int[] nums, int target) 
    {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if ((sum - target) < 0 || (sum - target) % 2 != 0)
        return 0;
        int tar=(sum-target)/2;
        return countpar(tar,nums);//no need of index as tabulation
    }
    
    public static int countpar(int tar,int[] nums)
    {
        int [][] dp=new int[nums.length][tar+1];
        if(nums[0]==0)
        dp[0][0]=2;
        else
        dp[0][0]=1;
        if (nums[0] != 0 && nums[0] <= tar)
            dp[0][nums[0]] = 1;
        for(int i=1;i<nums.length;i++)
        {
            for(int s=0;s<=tar;s++)
            {
                int nottake=dp[i-1][s];
                int take=0;
                if(nums[i]<=s)
                take=dp[i-1][s-nums[i]];
                dp[i][s]=take+nottake;
            }
        }
        return dp[nums.length-1][tar];
    }
}