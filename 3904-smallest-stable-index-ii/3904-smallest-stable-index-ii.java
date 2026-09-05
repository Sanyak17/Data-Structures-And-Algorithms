class Solution {
    public int firstStableIndex(int[] nums, int k) 
    {
        int n=nums.length;
        int[] prefmax=new int[n];
        int[] suffmin=new int[n];
        prefmax[0]=nums[0];
        for(int i=1;i<n;i++)
            {
                prefmax[i]=Math.max(prefmax[i-1],nums[i]);
            }
        suffmin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--)
            {
                suffmin[i]=Math.min(suffmin[i+1],nums[i]);
            }
        for(int i=0;i<n;i++)
            {
                int stab=prefmax[i]-suffmin[i];
                if(stab<=k)
                    return i;
            }
        return -1;
        
    }
}