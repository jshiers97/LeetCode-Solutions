class Solution {
    public int minimizeMax(int[] nums, int p) {
        if(p==0){
            return 0; 
        }
        Arrays.sort(nums); 
        int min=0;
        int max=(nums[nums.length-1] - nums[0]);
        int minMax=max;
        while( min <= max){
            int mid=(min+max)/2;
            if(check(nums, p, mid)){
                minMax=mid;
                max=mid-1;
                
            }
            else{
                min=mid+1;
            }
        }
        return minMax;
    }
    public boolean check(int[] nums, int p, int mid){
        int first=0;
        int second=1;
        int curr=0; 
        while(second < nums.length){
            if(nums[second]-nums[first] <=mid){
                curr++;
                if(curr==p){
                    return true;
                }
                first+=2;
                second+=2;
            }
            else{
                first++;
                second++; 
            }
        }
        return false;
    }
}