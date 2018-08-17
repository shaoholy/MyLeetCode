package Leetcode2;

public class TwoEightFour {

}
//1, use general Iterator but one place ahead, use one field Integer as cache
class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iter; 
    private Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        iter = iterator; 
        next = null; 
        if(iter.hasNext()){
            next = iter.next(); 
        }
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next; 
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer res = next; 
	    if(iter.hasNext()){
            next = iter.next();
        }else{
            next = null; 
        }
        return res; 
	}

	@Override
	public boolean hasNext() {
	    return next != null;
	}
}