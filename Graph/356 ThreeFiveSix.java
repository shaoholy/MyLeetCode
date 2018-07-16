package Leetcode;

public class ThreeFiveSix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isReflected(int[][] points) {
	    if(points.length==0) return true;
		int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    for(int[] point:points) {
	    		max=Math.max(max, point[0]);
	    		min=Math.min(min, point[0]);
	    }
	    double mid=((double)max+(double)min)/2;
	    boolean[] vis=new boolean[points.length];
	    for(int i=0; i<points.length; i++) {
	    		if((double)points[i][0]==mid) continue;
	    		if(!vis[i]) {
	    			boolean found=false;
	    			for(int j=0; j<points.length; j++) {
	    				if(j!=i && !vis[j] && ((double)points[i][0]+(double)points[j][0])/2==mid && points[i][1]==points[j][1]) {
	    					vis[i]=true;
	    					vis[j]=true;
	    					found=true;
	    				}
	    			}
	    		if(!found) return false;
	    		}
	    }
	    for(int i=0; i<points.length; i++) {
	    		if(!vis[i] && (double)points[i][0]!=mid) return false;
	    }
	    return true;
	}
}

//simplified code:
public boolean isReflected(int[][] points) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    HashSet<String> set = new HashSet<>();
    for(int[] p:points){
        max = Math.max(max,p[0]);
        min = Math.min(min,p[0]);
        String str = p[0] + "a" + p[1];
        set.add(str);
    }
    int sum = max+min;
    for(int[] p:points){
        //int[] arr = {sum-p[0],p[1]};
        String str = (sum-p[0]) + "a" + p[1];
        if( !set.contains(str))
            return false;

    }
    return true;
}    
