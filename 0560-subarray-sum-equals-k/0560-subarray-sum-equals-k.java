class Solution 
{
    HashMap<Integer,Integer> map;
    public int subarraySum(int[] nums, int k) 
    {
        map=new HashMap<>();
        int count=0;
        map.put(0,1);
        int currsum=0;
        for(int i=0;i<nums.length;i++)
        {
            currsum=currsum+nums[i];
            count+=map.getOrDefault(currsum-k,0);
            map.put(currsum,map.getOrDefault(currsum,0)+1);
        }
        return count;
    }
}