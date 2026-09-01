public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // shift result left to make room for next bit
            result |= (n & 1);     // add the last bit of n to result
            n >>= 1;               // shift n right to process next bit
        }
        
        return result;
    }
}