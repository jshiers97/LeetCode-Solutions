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
                
                
                if(one==nums[i]){
                    //System.out.println("here");
                    oneCount++;
                    //System.out.println(oneCount);
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
        }
        //System.out.println(oneCount);
        if(oneCount > twoCount){
            return one;
        }
        else{
            return two;
        }
            
    }
}