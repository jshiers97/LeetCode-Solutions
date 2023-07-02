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
    Queue<Character> q=new LinkedList<>(); 
 
    public int read(char[] buf, int n) {
        int output=0;
        
        if(n==0){
            return 0; 
        }
        char[] intBuff = new char[4];
        
        while (q.size() < n) {
            int readCount = read4(intBuff);
            for (int i = 0; i < readCount; i++) {
                q.offer(intBuff[i]);
            }
            if (readCount < 4) break;
        }
        for(int i=0; i<n ; i++){
            if(q.size() ==0){
                break;
            }
            //output++;
            buf[output++]=q.poll(); 
        }
        return output; 
        
       
    }
        
        
}