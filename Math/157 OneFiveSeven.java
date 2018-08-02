package Leetcode2;

public class OneFiveSeven {

}
//
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     * The API: int read4(char *buf) reads 4 characters at a time from a file.The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
     */
    public int read(char[] buf, int n) {
    		char[] chararray=new char[4];
        int posi=0;
        while(posi<n) {
        		int num= read4(chararray);
        		if(num==0) break;
        		for(int i=0; i<num && posi<n; i++) {
        			buf[posi]=chararray[i];
        			posi++;
        		}
        }
        return posi;
    }
}
