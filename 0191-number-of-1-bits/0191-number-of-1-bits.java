public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask=1;
        int count=0;
        while(n!=0){
            if((mask & n)==1){
                count++;
            }
            n>>>=1;
        }
        return count;
    }
}