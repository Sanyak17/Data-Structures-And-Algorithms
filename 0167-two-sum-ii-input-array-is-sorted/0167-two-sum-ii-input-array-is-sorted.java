class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] sum =new int[2];
        int lp=0;
        int rp=numbers.length-1;
        while(lp!=rp){
        if(numbers[lp]+numbers[rp]==target)
        {
            sum[0]=lp+1;
            sum[1]=rp+1;
            return sum;
           
        }
        else if(numbers[lp]+numbers[rp]>target)
        rp--;
        else lp++;
        }
        return new int[]{-1,-1};
    }
}