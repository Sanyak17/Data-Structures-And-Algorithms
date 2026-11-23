class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] arr=new int[nums1.length+nums2.length];
        int k=0;
        for(int i=0;i<nums1.length;i++)
        {
            arr[k++]=nums1[i];
        }
        for(int j=0;j<nums2.length;j++)
        {
            arr[k++]=nums2[j];
        }
        Arrays.sort(arr);
        if(arr.length%2==0)
        {
            return (arr[arr.length/2]+arr[(arr.length/2)-1])/2.0;
        }
        return (double)arr[arr.length/2];
    }
}