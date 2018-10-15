class Solution {
    public int reverse(int x) {
        boolean negative = false;
        if(x < 0){
            negative = true;
            x = -x;
        }
        long sum = 0;
        int left;
        while(x != 0){
            sum *= 10;
            left = x % 10;
            sum += left;
            x /= 10;
        }

        if(negative) sum = -sum;

        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) sum = 0;
        return (int)sum;
    }
}