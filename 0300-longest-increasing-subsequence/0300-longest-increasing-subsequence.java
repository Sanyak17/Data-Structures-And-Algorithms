class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Integer[][] dp=new Integer[n][n+1];
        //return solveTab(nums);
        return Lis(nums);
    }
    public int solveRec(int curr,int prev,int[] nums)
    {
        if(curr==nums.length)
        return 0;
        int ntake=solveRec(curr+1,prev,nums);
        int take=0;
        if(prev==-1||nums[curr]>nums[prev])
        take=1+solveRec(curr+1,curr,nums);
        return Math.max(ntake,take);

    }
    public int solveMem(int curr,int prev,int[] nums,Integer[][] dp)
    {
        int n=nums.length;
        if(curr==nums.length)
        return 0;
        if(dp[curr][prev+1]!=null)
        return dp[curr][prev+1];
        int ntake=solveMem(curr+1,prev,nums,dp);
        int take=0;
        if(prev==-1||nums[curr]>nums[prev])
        take=1+solveMem(curr+1,curr,nums,dp);
        return dp[curr][prev+1]=Math.max(ntake,take);
    }
    public int solveTab(int[] nums)
    {
        int n=nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int curr=n-1;curr>=0;curr--)
        {
            for(int prev=curr-1;prev>=-1;prev--)
            {
               int ntake= dp[curr+1][prev+1];
               int take=0;
               if(prev==-1||nums[curr]>nums[prev])
               take=1+dp[curr+1][curr+1];
               dp[curr][prev+1]=Math.max(take,ntake);
            }
        }
        return dp[0][0];
    }
    public int Lis(int[] nums)
    {
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(nums[0]);
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>temp.get(temp.size()-1))
            temp.add(nums[i]);
            else
            temp.set(lowerBound(temp,nums[i]),nums[i]);
        }
        return temp.size();
    }
    public int lowerBound(ArrayList<Integer> list,int target)
    {
        int low=0;
        int high=list.size()-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if(list.get(mid)==target)
            return mid;
            else if(list.get(mid)>target)
            high=mid-1;
            else low=mid+1;
        }
        return low;
    }
    
}
