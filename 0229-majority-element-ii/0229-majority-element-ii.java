class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> output=new ArrayList<>(); 
        int count1=0;
        int count2=0;
        Integer first=null;
        Integer second=null;
        for(int x: nums){
            //System.out.println(first + " " + count1) ;
            //System.out.println(second);
            if(first!=null && first==x){
                count1++;
            }
            else if(second!=null && second==x){
                count2++;
            }
            else if(count1==0){
                first=x;
                count1=1;
            }
            else if(count2==0){
                second=x;
                count2=1;
            }
            else{
                count1--;
                count2--;
            }
            
        }
        
        count1=0;
        count2=0; 
        System.out.println(first);
        System.out.println(second);
        for(int x: nums){
            if(x==first){
                count1++;
            }
            if(second!=null && x==second){
                count2++;
            }
        }
        if(count1 > nums.length / 3){
            output.add(first);
        }
        if(second!=null && count2 > nums.length / 3 ){
            output.add(second);
        }
        return output;
    }
}