class Solution {
    public int reverseDegree(String s) 
    {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            int chara=26-(s.charAt(i)-'a');
            ans+=chara*(i+1);
        }
        return ans;
        
    }
}