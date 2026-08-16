class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int mindrone=-1;
        int mindist=Integer.MAX_VALUE;
        int n=drones.length;
        for(int i=0;i<n;i++)
        {
            int dist=Math.abs(drones[i][0]-target[0])+Math.abs(drones[i][1]-target[1]);
            if(dist<=drones[i][2])
            {
                if(mindist>dist)
                {
                    mindist=dist;
                    mindrone=i;
                }
            }

        }
        return mindrone;
    }
}