class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),result);
        return result;
    }
    void backtrack(int[] arr,int target,int index, List<Integer> curr,List<List<Integer>>result)
    {
        if(index>=arr.length||target<0)
        return;
        if(target==0)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[index]);
        backtrack(arr,target-arr[index],index,curr,result);
        curr.remove(curr.size()-1);
        backtrack(arr,target,index+1,curr,result);
    }
}