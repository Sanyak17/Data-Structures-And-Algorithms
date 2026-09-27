class Solution {
    public int maxEqualAdjacentPairs(int[] nums) 
    {
        int already=0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i < nums.length; i++) 
        {
            int a = nums[i - 1];
            int b = nums[i];
            if (nums[i] == nums[i - 1]) 
            {
                already++;
            } 
            else 
            {
               int x = Math.min(a, b);
                int y = Math.max(a, b);

                String key = x + "#" + y;

                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
        int bestGain = 0;
        for (int value : map.values()) {
            bestGain = Math.max(bestGain, value);
        }
        return already + bestGain;   
    }
}