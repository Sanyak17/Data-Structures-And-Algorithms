class Solution {
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        Set<Integer> a=new HashSet();
        List<Integer> list=new ArrayList<>();
        for(int i:nums)
            a.add(i);
        for(int i=lower;i<=upper;i++)
            {
                if(! a.contains(i))
                    list.add(i);
            }
        if(list.isEmpty())
            return ans;
        int s=list.get(0);
        int p=list.get(0);
        for(int i=1;i<list.size();i++)
            {
                int c=list.get(i);
                if (c != p + 1) 
                {
                    ans.add(Arrays.asList(s, p));
                    s = c;
                }
                p=c;
            }
        ans.add(Arrays.asList(s, p));
        return ans;
        
        
        
    }
}