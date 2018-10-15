class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String s = ""; 
        int min_len = 2147483647;
        char pre = '\0';
        for(int i = 0; i < strs.length; i++){
          int len = strs[i].length();
          if(min_len > len) min_len = len;
        }
        boolean flag = true;
        for(int i = 0; i < min_len; i++){
          pre = strs[0].charAt(i);
          for(int j = 0; j < strs.length; j++){
            if(strs[j].charAt(i) != pre){
              flag = false;
              break;
            }
          }

          if(flag) s+=pre;
          else break;
        }
        return s;
    }

    public static void main(String args[]){
      Solution solution = new Solution();
      String strs[] = {"flower", "flow", "flight"};
      System.out.println(solution.longestCommonPrefix(strs));

    }
}
