class Solution {
    public int maximumRemovals(String s, String p, int[] removable) {
        StringBuilder temp=new StringBuilder(s); 
        int left=0; 
        int max=0;
        int right=removable.length-1;
        while(left <= right){
            int mid=(left+right)/2;
            if(check(s, p, removable, mid)){
                max=Math.max(max, mid+1);
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        return max;
    }
    public boolean check(String s, String p, int[] removable, int mid){
        StringBuilder temp=new StringBuilder(s);
        for(int i=0; i<=mid; i++){
            temp.setCharAt(removable[i], '?');
            
        }
        System.out.println("mid   " + mid + "  " + temp.toString() );
        int found=0;
        int index=0;
        int j=0; 
        
        for(int i=0; i<p.length(); i++){
            char c=p.charAt(i);
            while(j<temp.length()){
                
                char d=temp.charAt(j);
                if(c==d){
                    found++;
                    if(found==p.length()){
                        return true;
                    }
                    j++;
                    break;
                }
                j++;
            }
            if(j==temp.length()){
                return false;
            }
        }
        return false;
    }
}