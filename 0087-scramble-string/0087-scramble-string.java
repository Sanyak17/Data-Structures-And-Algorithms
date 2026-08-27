class Solution 
{
    HashMap<String, Boolean> dp = new HashMap<>();
    public boolean isScramble(String s1, String s2) 
    {
        if (s1.equals(s2))
            return true;

        if (s1.length() != s2.length())
            return false;

        String key = s1 + " " + s2;

        if (dp.containsKey(key))
            return dp.get(key);

        int n = s1.length();

        // Check whether both strings contain same characters
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int x : freq) {
            if (x != 0) {
                dp.put(key, false);
                return false;
            }
        }
        for (int k = 1; k < n; k++) {

            boolean noSwap =isScramble(s1.substring(0, k),s2.substring(0, k))&&
                            isScramble(s1.substring(k),s2.substring(k));

            // Case 2: Swap
            boolean swap =
                    isScramble(
                        s1.substring(0, k),
                        s2.substring(n - k)
                    )
                    &&
                    isScramble(
                        s1.substring(k),
                        s2.substring(0, n - k)
                    );

            if (noSwap || swap) {
                dp.put(key, true);
                return true;
            }
        }

        dp.put(key, false);
        return false;
    }
}