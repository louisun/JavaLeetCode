class Solution {
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);
        int i=0, j=str.length()-1;
        boolean flag = true;
        while(i<=j){
            if(str.charAt(i) !=str.charAt(j)){
                flag = false; 
                break;
            }
            i++;
            j--;
        }
        return flag;
    }
}