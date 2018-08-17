package Leetcode2;

import java.util.Iterator;
import java.util.List;

public class TwoFiveOne {

}
//1, 2 iter, 1 for List of curlist, 1 for list; 
public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> iter1;
    Iterator<Integer> iter2;
 
    public Vector2D(List<List<Integer>> vec2d) {
    		iter1 = vec2d.iterator();
    		iter2 = vec2d.get(0).iterator();
    }
 
    @Override
    public Integer next() {
        Integer res = iter2.next();
        if(!iter2.hasNext() && iter1.hasNext()) {
        		iter2 = iter1.next().iterator();
        }
    }
 
    @Override
    public boolean hasNext() {
    		return iter2.hasNext();
    }
}
//2, one iterator as
public class Vector2D implements Iterator<Integer> {
    Integer nextlist = null; 
    Iterator<Integer> iter = null;
 
    public Vector2D(List<List<Integer>> vec2d) {
    		if(vec2d.size() > 0) {
    			iter = vec2d.get(0).iterator(); 
    			nextlist = 1;
    		}
    }
 
    @Override
    public Integer next() {
    		if(iter.hasNext()) {
    			return iter.next();
    		}else if(!iter.hasNext() && nextlist < vec2d.size()) {
	        		iter = vec2d.get(nextlist).iterator();
	        		do {
	        			nextlist++;
	        		}while(nextlist < vec2d.size() && vec2d.get(nextlist).size() != 0);
        		return iter.next();
        }else {
        		return null; 
        }
    }
 
    @Override
    public boolean hasNext() {
    		return nextlist != null && (iter.hasNext() || nextlist < vec2d.size());
    }
}
    
    //3, use List<Iterator<Integer>> store all the iterators in order
    public class Vector2D {
        List<Iterator<Integer>> its;
        int curr = 0;
        public Vector2D(List<List<Integer>> vec2d) {
            this.its = new ArrayList<Iterator<Integer>>();
            for(List<Integer> l : vec2d){
                // 只将非空的迭代器加入数组
                if(l.size() > 0){
                   this.its.add(l.iterator()); 
                }
            }
        }
        public int next() {
            Integer res = its.get(curr).next();
            // 如果该迭代器用完了，换到下一个
            if(!its.get(curr).hasNext()){
                curr++;
            }
            return res;
        }
        public boolean hasNext() {
            return curr < its.size() && its.get(curr).hasNext();
        }
    }
}
 
/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */