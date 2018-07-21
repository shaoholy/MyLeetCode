package Leetcode2;

public class ThreeFourOne {

}
//ArrayDeque as stack
public class NestedIterator implements Iterator<Integer> {
    private ArrayDeque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack=new ArrayDeque<NestedInteger>();
        for(int i=0; i<nestedList.size(); i++)
            stack.add(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return stack.poll().getInteger();
        
    }

    @Override
    public boolean hasNext() {
        while(stack.size()!=0){
            if(stack.peek().isInteger())
                return true;
            NestedInteger curlist=stack.poll();
            for(int i=curlist.getList().size()-1; i>=0; i--)
                stack.addFirst(curlist.getList().get(i));
        }
        return false;
    }
}
