class Solution {
    public int majorityElement(int[] nums) 
    {
        //here we cannot use freq arr as elements range is very large 
        int candidate =-1;
        int count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(count==0)
            {
                candidate=nums[i];
                count=1;
            }
            else 
            {
                if(nums[i]==candidate)
                    count++;
                else
                    count--;
            }
        }
        count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==candidate)
            count++;
        }
        if(count>(nums.length/2))
        return candidate;
        return -1;
        
    }
}