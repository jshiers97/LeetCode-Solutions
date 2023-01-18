class Solution {
    public int[] countBits(int n) {
        List<Integer> curr=new ArrayList<>();
        curr.add(0);
        int[] output=new int[n+1];
        output[0]=0;
        for(int i=1; i<=n; i++){
            int res=add(curr);
            output[i]=res;
        }
        return output; 
    }
    public int add(List<Integer> curr){
        int count=0;
        int carry=1;
        for(int i=curr.size()-1; i>=0; i--){
            if(curr.get(i)==0){
                if(carry==1){
                    curr.set(i, 1);
                    carry=0;
                }
                
                break;
            }
            else{
                if(carry==1){
                    curr.set(i, 0);
                }
                else{
                    carry=0;
                }
            }
        }
        if(carry==1){
            curr.add(0, 1);
        }
        for(int x: curr){
            if(x==1){
                count++;
            }
        }
        return count;
    }
}