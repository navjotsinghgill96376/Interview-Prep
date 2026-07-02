//NOTE Dont Forget Decision has to be made on which side to go based on the sorted half of the array
// based on that we can decide which side to go and then we can apply binary search on that side


class Solution {
    public int search(int[] nums, int target) {
        int lo = 0,hi = nums.length-1;

        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[lo]<=nums[mid]){
                if(nums[lo]<=target && target<nums[mid]){
                    hi=mid-1;
                }else{
                    lo=mid+1;
                }
            }else{
                if(nums[mid]<target && target<=nums[hi]){
                    lo=mid+1;
                }else{
                    hi=mid-1;
                }
            }
        }

        return -1;
    }
}