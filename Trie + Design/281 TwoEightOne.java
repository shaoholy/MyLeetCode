package Leetcode2;

import java.util.Iterator;
import java.util.List;

public class TwoEightOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//1, temp to toggle V1.ite and V2.ite
    private Iterator<Integer> i1, i2, temp;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        i1 = v2.iterator();
        i2 = v1.iterator();
    }

    public int next() {
        if(i2.hasNext()) {
        		temp = i2; 
        		i2 = i1;
        		i1 = temp;
        }
        return i1.next();
    }

    public boolean hasNext() {
        return i1.hasNext() || i2.hasNext();
    }
    
    //2, cur_ to toggle
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.iterator1 = v1.iterator();
        this.iterator2 = v2.iterator();
        this.cur_iterator = (this.iterator1.hasNext() ? this.iterator1 : this.iterator2);
    }

    public int next() {
        int ret = cur_iterator.next();
        if (cur_iterator == iterator1) {
            if (iterator2.hasNext()) {
                cur_iterator = iterator2;
            }
        } else{
            if (iterator1.hasNext()) {
                cur_iterator = iterator1;
            }
        }
        return ret;
    }

    public boolean hasNext() {
        return cur_iterator.hasNext();
    }
}
