package Questions.DP;


public class LongestCommonSubstring {

    // Function to find the length of the Longest Common Substring (LCS)
    static int lcsTabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create a 2D array to store LCS lengths
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0; // Initialize a variable to store the maximum LCS length

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // If the characters at the current indices are the same, extend the LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + dp[i - 1][j - 1];
                    dp[i][j] = val;
                    ans = Math.max(ans, val); // Update the maximum LCS length
                } else {
                    dp[i][j] = 0; // Reset LCS length if characters don't match
                }
            }
        }

        return ans; // Return the length of the Longest Common Substring (LCS)
    }
    // Time Complexity: O(N*M)

    // Reason: There are two nested loops

    // Space Complexity: O(N*M)

    // Reason: We are using an external array of size ‘N*M)’. Stack Space is
    // eliminated.

    // Function to find the length of the Longest Common Substring (LCS)
    static int lcsOptimized(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // Create arrays to store LCS lengths
        int prev[] = new int[m + 1];

        int ans = 0; // Initialize a variable to store the maximum LCS length

        for (int i = 1; i <= n; i++) {
            int cur[] = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                // If the characters at the current indices are the same, extend the LCS
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    int val = 1 + prev[j - 1];
                    cur[j] = val;
                    ans = Math.max(ans, val); // Update the maximum LCS length
                } else {
                    cur[j] = 0; // Reset LCS length if characters don't match
                }
            }
            // Update the 'prev' array to the values of 'cur' for the next iteration
            prev = cur;
        }

        return ans; // Return the length of the Longest Common Substring (LCS)
    }

    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";
        System.out.println(lcsTabulation(s1, s2));
        System.out.println(lcsOptimized(s1, s2));
    }

}
