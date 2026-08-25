class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> a=new HashSet<Integer>();
        for(int i:nums)
        a.add(i);
        int n=k;
        boolean found=true;
        while(found)
        {
            if(!a.contains(n))
            {
                found=false;
            }
            else
            n+=k;
        }
        return n;
    }
}