class Solution {
    public int totalNumbers(int[] digits) {
        int count = 0;

        for (int num = 100; num <= 998; num += 2) {
            int x = num;

            int a = x % 10;
            x /= 10;
            int b = x % 10;
            x /= 10;
            int c = x % 10;

            int[] freq = new int[10];

            for (int d : digits) {
                freq[d]++;
            }

            if (freq[a] > 0) {
                freq[a]--;

                if (freq[b] > 0) {
                    freq[b]--;

                    if (freq[c] > 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}