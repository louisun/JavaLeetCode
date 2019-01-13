import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> ans = new ArrayList<>();
      if(nums == null || nums.length < 3) return ans;

      Arrays.sort(nums);
      for(int i = 0; i < nums.length; i++){
        if(nums[i] > 0) break;
        if(i > 0 && nums[i] == nums[i-1]) continue;

        int begin = i+1;
        int end = nums.length-1;

        while(begin < end){
          int sum = nums[i] + nums[begin] + nums[end];
          if(sum == 0){
            List<Integer> l = new ArrayList<>(); 
            l.add(nums[i]);
            l.add(nums[begin]);
            l.add(nums[end]);
            ans.add(l);
            begin++;
            end--;
            while(begin < end && nums[begin] == nums[begin-1]){
              begin++;
            }
            while(begin < end && nums[end] == nums[end+1]){
              end--;
            }
          }
          else if(sum >0){
            end--;
          }
          else{
            begin++;
          }
        
        }

      }

      return ans;
    }
    public static void main(String args[]){
      Solution solution = new Solution();
      int a[] = {-1,0,1,2,-1,-4};
      List<List<Integer>> list = solution.threeSum(a);
      System.out.println(list);
    }

}
