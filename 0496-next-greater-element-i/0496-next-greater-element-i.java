import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int[] next = new int[n];   // next greater element for each index of nums2
        Stack<Integer> s = new Stack<>();

        // Compute next greater for nums2
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }
            next[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums2[i]);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    ans[i] = next[j];   // map correctly
                    break;
                }
            }
        }

        return ans;
    }
}
