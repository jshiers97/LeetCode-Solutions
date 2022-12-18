class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int total=0;
        int aWidth=ax2-ax1;
        int aLen=ay2-ay1;
        total+= (aLen * aWidth);
        
        int bWidth=bx2-bx1;
        int bLen=by2-by1;
        total+= (bLen * bWidth);
        
        int cx1=Math.max(ax1, bx1);
        int cx2=Math.min(ax2, bx2);
        
        int cy1=Math.max(ay1, by1);
        int cy2=Math.min(ay2, by2);
        
        if(cx2-cx1 > 0 && cy2-cy1 > 0){
            total-= ( (cx2-cx1) * (cy2-cy1));
            
        }
        return total;
        
        
    }
}