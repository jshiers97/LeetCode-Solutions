class Solution {
    int[] res;
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //int[] res=
        this.res=new int[spells.length];
        Arrays.sort(potions);
        int maxPotion=potions[potions.length-1];
       
        for(int i=0; i<spells.length; i++){
            long minPotion = (long) Math.ceil((1.0 * success) / spells[i]);
            if(minPotion > maxPotion){
                res[i]=0;
                continue;
            }
            find(potions, (int)minPotion, i, spells[i]);
        }
       
        return res; 
        
    }
    public void find(int[] potions, int target, int i, int spell){
        int leftMost=potions.length-1;
        boolean found=false;
        int left=0; 
        int right=potions.length; 
       
       
        while(left <= right){
            int mid=(left+right)/2;
            if(potions[mid]>=target){
                leftMost=mid;
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        //int index=a
        res[i]=potions.length-leftMost;
    }
}