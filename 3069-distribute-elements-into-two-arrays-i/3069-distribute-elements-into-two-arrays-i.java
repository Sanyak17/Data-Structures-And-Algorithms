class Solution {
    public int[] resultArray(int[] nums)
    {
        ArrayList<Integer> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();
        int n=nums.length;
        list1.add(nums[0]);
        list2.add(nums[1]);
        for(int i=2;i<n;i++)
        {
            int x=nums[i];
            if(list1.get(list1.size()-1)>list2.get(list2.size()-1))
            list1.add(x);
            else
            list2.add(x);
        }
        int[] res=new int[n];
        int k=0;
        for(int i=0;i<list1.size();i++)
        {
            res[k++]=list1.get(i);
        }
        for(int i=0;i<list2.size();i++)
        {
            res[k++]=list2.get(i);
        }
        return res;
    }
}