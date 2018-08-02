package Leetcode2;

import java.util.LinkedList;

public class OneFiveEight {

}
///
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    LinkedList<Character> buff = new LinkedList<Character>();
    int total;
    public int read(char[] buf, int n) {
        total = 0;
        char[] c=new char[4];
        while(true) {
        		int in=read4(c);
        		for(int i=0; i<in; i++) buff.add(c[i]);
        		
        		//关键：确认buff和n哪个先到期限；
        		in=Math.min(n-total, buff.size());
        		if(in==0) break; 
        		for(int i=0; i<in; i++) buf[total++]=buff.poll();
        		
        }

        return total;
    }
}
