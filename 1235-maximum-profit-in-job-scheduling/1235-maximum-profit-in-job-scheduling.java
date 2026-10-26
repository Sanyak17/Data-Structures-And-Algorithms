/*import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // sort by end time
        return rec(n - 1, jobs);
    }

    public int rec(int i, int[][] jobs) {
        if (i < 0) return 0;

        // Option 1: skip this job
        int notTake = rec(i - 1, jobs);

        // Option 2: take this job
        int take = jobs[i][2];
        int prev = findLastNonConflicting(jobs, i);
        if (prev != -1) {
            take += rec(prev, jobs);
        }

        return Math.max(take, notTake);
    }

    private int findLastNonConflicting(int[][] jobs, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (jobs[j][1] <= jobs[i][0]) {
                return j;
            }
        }
        return -1;
    }
}
*/
import java.util.*;

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, (a, b) -> a[1] - b[1]); // sort by end time

        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            // profit including current job
            int include = jobs[i][2];
            int prev = binarySearch(jobs, i);
            if (prev != -1) {
                include += dp[prev];
            }

            // profit excluding current job
            int exclude = dp[i - 1];

            dp[i] = Math.max(include, exclude);
        }

        return dp[n - 1];
    }

    private int binarySearch(int[][] jobs, int i) {
        int low = 0, high = i - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (jobs[mid][1] <= jobs[i][0]) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
