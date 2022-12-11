class Solution {
    public int majorityElement(int[] nums) {
        Integer one=null;
        Integer two=null;
        int oneCount=0;
        int twoCount=0;
        for(int i=0; i<nums.length; i++){
            
            if(one==null){
                one=nums[i];
                oneCount=1;
            }
            else if(one==nums[i]){
                oneCount++;
            }
            else if(two==null){
                two=nums[i];
                twoCount=1;
            }
            else if(two==nums[i]){
                twoCount++;
            }
            else{
                
                if(oneCount==0){
                        one=nums[i];
                        oneCount=1;
                    }
                    else if(twoCount==0){
                        two=nums[i];
                        twoCount=1;
                    }
                    else{
                        oneCount--;
                        twoCount--;
                    }
            }
                
                
            
        }
        
        if(oneCount > twoCount){
            return one;
        }
        else{
            return two;
        }
            
    }
}