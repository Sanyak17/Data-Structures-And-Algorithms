class Solution {
    public int minOperations(String s) {

        int n = s.length();
        int ans = Integer.MAX_VALUE;

        for (int k = 0; k < n; k++) {
            int operations = k;
            for (int i = 0; i < n / 2; i++) {

                int left = (k + i) % n;
                int right = (k + n - 1 - i) % n;

                char a = s.charAt(left);
                char b = s.charAt(right);

                int aToB = (b - a + 26) % 26;
                int bToA = (a - b + 26) % 26;

                operations += Math.min(aToB, bToA);
            }

            ans = Math.min(ans, operations);
        }

        return ans;
    }
}
// class Solution
//     {
//          HashMap<String, Integer> dp = new HashMap<>();
//     public int minOperations(String s) 
//     {
//         return rec(s,0,0);
//     }
//     public int rec(String s, int i,int rotations)
//     {
//         if(ispalin(s))
//             return 0;
//         if (rotations == s.length())
//             return Integer.MAX_VALUE / 2;
//         String key = s + "#" + i+"#" +rotations;
//         if (dp.containsKey(key))
//             return dp.get(key);
//         String newstr=s.substring(1)+s.charAt(0);
//         int rotate=1+rec(newstr,i,rotations+1);
//         char ch =s.charAt(i);
//         char nwch;
//         if(ch=='z')
//             nwch='a';
//         else
//             nwch=(char)(ch+1);
//         String news=s.substring(0,i)+nwch+s.substring(i+1);
//         int incre=1+rec(news,i,rotations);
//         int ans= Math.min(rotate,incre);
//         dp.put(key, ans);
//         return ans;
//     }
//     public static boolean ispalin(String s)
//     {
        
//         int i=0;
//         int j=s.length()-1;
//         while(i<j)
//             {
//                 if(s.charAt(i)!=s.charAt(j))
//                     return false;
//                 else
//                 {
//                     i++;
//                     j--;
//                 }
                
//             }
//         return true;
//     }
// }