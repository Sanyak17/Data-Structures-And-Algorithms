class Solution {
    int n;
    public int sumOfSquares(int[] nums) {
         n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            if(isSpec(i+1))
            sum+=nums[i]*nums[i];
        }
        return sum;
    }
    public boolean isSpec(int i)
    {
        if(n%i==0)
        return true;
        else
        return false;
    }
}