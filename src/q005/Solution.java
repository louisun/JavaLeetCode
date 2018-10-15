class Solution {
    public String longestPalindrome(String s) {
        // dp[i][j] 表示 i 到 j 是否是回文串
        // 状态转移： dp[i][j] = s.charAt(i)==s.charAt(j)?dp[i+1][j-1]:0
        int[][] dp = new int[1001][1001];
        
        int len = s.length();
        int sub_i = 0, sub_j = 0;

        // 先把长度为 1 和 子串都初始化
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
            if(i!=len-1){
                // 长度为 2 的所有子串初始化
                if(s.charAt(i) == s.charAt(i+1)){
                    sub_i = i;
                    sub_j = i+1;
                    dp[i][i+1] = 1;
                }
            }
        }
        // 枚举各长度的子串
        for(int L = 3; L <= len; L++){
            for(int i = 0; i + L - 1 < len; i++){
                int j = i + L - 1;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j] == 1){
                        sub_i = i;
                        sub_j = j;
                    }
                }
            }
        }

        return s.substring(sub_i,sub_j+1);
    }
}
