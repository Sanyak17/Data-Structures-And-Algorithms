class Solution {
    public int maxLength(int[] nums) {
        int max = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            long product = 1;
            long lcm = 1;
            int gcd = 0;
            for (int j = i; j < n; j++) {
                product *= nums[j];
                gcd = findGcd(gcd, nums[j]);
                lcm = (lcm * nums[j]) / findGcd(lcm, nums[j]);
                if (product == lcm * gcd) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }
    private int findGcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return (int) a;
    }
}