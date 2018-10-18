import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
      int dis = 0x7fffffff, ans = 0;
      Arrays.sort(nums);
      int len = nums.length - 2;
      for(int i = 0; i < len; i++){
        int left = i+1, right = nums.length - 1;
        while(left < right){
          int sum = nums[i] + nums[left] + nums[right];
          int d = Math.abs(sum - target);
          if(d == 0) return target;
          if(d < dis){
            dis = d;
            ans = sum;
          }
          if(sum > target) right--;
          else left++;
        }
      }
     return ans; 

    }

    public static void main(String args[]){
      Solution solution = new Solution();
      int a[] = {-1,2,1,-4};
      int  ans = solution.threeSumClosest(a, 1);
      System.out.println(ans);
    }

}
