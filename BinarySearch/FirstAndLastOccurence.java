class Solution {

    public int firstOccurence(int[] nums,int target){
        int lo=0,hi=nums.length-1;
        int ans=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target){
                ans=mid;
                hi=mid-1;
            }else if(nums[mid]>target){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public int lastOccurence(int[] nums,int target){
        int lo=0,hi=nums.length-1;
        int ans=-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(nums[mid]==target){
                ans=mid;
                lo=mid+1;
            }else if(nums[mid]>target){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int lo=0,hi=n-1;
       
        int[] ans = new int[2];
        ans[0]=firstOccurence(nums,target);
        ans[1]=lastOccurence(nums,target);

        return ans;

    }
}