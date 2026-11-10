class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<String> set = new HashSet<>();
        set.add(x + "," + y);
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'N') 
            y++;
            if (path.charAt(i) == 'S') 
            y--;
            if (path.charAt(i) == 'E')
            x++;
            if (path.charAt(i) == 'W') 
            x--;
            if (set.contains(x + "," + y))
            return true;
            set.add(x + "," + y);
        }
        return false;
    }
}