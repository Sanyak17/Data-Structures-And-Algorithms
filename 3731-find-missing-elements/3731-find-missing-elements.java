class Solution {
    public List<Integer> findMissingElements(int[] nums) {
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++)
    {
        if(nums[i]>max) max=nums[i];
        if(nums[i]<min) min=nums[i];        
    }
    Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
    ArrayList<Integer> ans=new ArrayList<>();
    for(int i=min;i<=max;i++)
    {
      if(!set.contains(i))
          ans.add(i);
    }
        return ans;
    }
}