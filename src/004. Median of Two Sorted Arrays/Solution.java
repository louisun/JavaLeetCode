package q004;

class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        double array[] = new double[len1 + len2];
        int i = 0, j = 0, k = 0; // 三个数组的下标
        // k 表示合并数组下标
        while(i <= len1-1 && j <= len2-1){
            if(nums1[i] > nums2[j]){
                array[k++] = nums2[j++];
            }
            else{
                array[k++] = nums1[i++];
            }
        }
        while(i <= len1-1){
            array[k++] = nums1[i++];
        }
        while(j <= len2-1){
            array[k++] = nums2[j++];
        }
        if((len1 + len2) % 2 == 1){
            int index = (len1 + len2 - 1) /2 ;
            return array[index];
        }
        else{
            int index1 = (len1 + len2) / 2;
            int index2 = index1 - 1;
            return (array[index1] + array[index2]) / 2;
        }
    }
}