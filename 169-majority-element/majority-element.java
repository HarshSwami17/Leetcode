class Solution {
        public static int counting(int arr[] , int si , int ei , int nums){
        int count = 0;
        for(int i = si ; i<=ei ;i++ ){
            if(arr[i]==nums){
                count++;
            }
        }
        return count;
    }
    public static int splitter(int arr[] , int si , int ei){
        if(si==ei){
            return arr[si];
        }
        int mid = si + (ei-si)/2;
        int left = splitter(arr, si, mid);
        int right = splitter(arr, mid+1, ei);
        if(left==right){
            return left;
        }
        int leftcount = counting(arr, si, ei, left);
        int rightcount = counting(arr, si, ei, right);
        return leftcount>rightcount ? left:right;
    }
    public int majorityElement(int[] nums) {
        return splitter(nums , 0 , nums.length-1);
        
    }
}