class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        boolean des=true;
        long m=mass;
        int n=asteroids.length;
        for(int i=0;i<n;i++)
        {
            if(m>=asteroids[i])
            {
                m+=asteroids[i];
                continue;
            }
            else
            {
                des=false;
                break;
            }
            
        }
        return des;

    }
}