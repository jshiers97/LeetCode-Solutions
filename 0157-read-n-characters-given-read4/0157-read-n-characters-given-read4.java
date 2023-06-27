/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int read=0;
        char[] temp=new char[n*4];
        int index=0;
        int prev=4;
        while(prev == 4 && read < n){
            prev=read4(temp);
            if(prev+read > n){
                
                int i=0;
                while(index < n){
                    buf[index++]=temp[i++];
                }
                return n;
            }
            read+=prev;
            
            for(int i=0; i<prev; i++){
                buf[index++]=temp[i];
            }
        }
        
        return read;
        
        
        
    }
}