class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res=new ArrayList<>(); 
        
        int left=0; 
        int right=k-1; 
        while(right < arr.length){
            //if diff between abs(right-x ) < abs(left-x) then increase
            if(right + 1< arr.length && Math.abs(arr[right+1] - x) < Math.abs(arr[left] -x) ){
                right++;
                left++; 
            }
            else if(right + 1 < arr.length && arr[right+1]==arr[left]){
                right++; 
                left++; 
            }
            else{
                for(int i=left; i<=right; i++){
                    res.add(arr[i]);
                }
                return res;
            }
        }
        return res; 
    }
}