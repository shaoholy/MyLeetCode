package Leetcode;

public class ThreeNineOne {

}
//use HashSet to store occupy and check dupli, not good so far
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles==null || rectangles.length==0) return true;
        int lowleftx=rectangles[0][0], lowlefty=rectangles[0][1];
        int highrightx = rectangles[0][2], highrighty=rectangles[0][3];
        HashSet<String> token=new HashSet<String>();
        
        for(int i=0; i<rectangles.length; i++){
            //keep the outer contour of the large rectangle
            if(rectangles[i][0]<lowleftx) lowleftx=rectangles[i][0];
            if(rectangles[i][1]<lowlefty) lowlefty=rectangles[i][1];
            if(rectangles[i][2]>highrightx) highrightx=rectangles[i][2];
            if(rectangles[i][3]>highrighty) highrighty=rectangles[i][3];
            //add every point of each rectangel into hashset, return false if dupli
            for(int j=rectangles[i][0]; j<rectangles[i][2]; j++){
                for(int k=rectangles[i][1]; k<rectangles[i][3]; k++){
                    String cur=""+j+"+"+k;
                    if(token.contains(cur)) return false;
                    else token.add(cur);
                }
            }
        }
        
        for(int i=lowleftx; i<highrightx; i++){
            for(int j=lowlefty; j<highrighty; j++){
                String cur=""+i+"+"+j; 
                if(!token.contains(cur)) return false;
                
            }
        }
        return true;
        
    }
}

//iterate twice solution, use boolean 

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        if(rectangles==null || rectangles.length==0) return true;
        int lowleftx=rectangles[0][0], lowlefty=rectangles[0][1];
        int highrightx = rectangles[0][2], highrighty=rectangles[0][3];
        
        
        for(int i=0; i<rectangles.length; i++){
            if(rectangles[i][0]<lowleftx) lowleftx=rectangles[i][0];
            if(rectangles[i][1]<lowlefty) lowlefty=rectangles[i][1];
            if(rectangles[i][2]>highrightx) highrightx=rectangles[i][2];
            if(rectangles[i][3]>highrighty) highrighty=rectangles[i][3];
        }
        boolean[][] ocu=new boolean[highrightx-lowleftx][highrighty-lowlefty];
        
        for(int i=0; i<rectangles.length; i++){
            //add every point of each rectangel into boolean, return false if dupli
            for(int j=rectangles[i][0]; j<rectangles[i][2]; j++){
                for(int k=rectangles[i][1]; k<rectangles[i][3]; k++){
                    if(!ocu[j-lowleftx][k-lowlefty]) ocu[j-lowleftx][k-lowlefty]=true;
                    else return false;
                }
            }
        }

        for(boolean[] row: ocu){
            for(boolean bo: row){
                if(!bo) return false;
                
            }
        }
        return true;
        
    }
}

//most voted solution: 2 invariates. 1, input every four corners, if exist, remove. At last only 4 left,at the largest; 2, sub area sum up. 
public boolean isRectangleCover(int[][] rectangles) {

    if (rectangles.length == 0 || rectangles[0].length == 0) return false;

    int x1 = Integer.MAX_VALUE;
    int x2 = Integer.MIN_VALUE;
    int y1 = Integer.MAX_VALUE;
    int y2 = Integer.MIN_VALUE;
    
    HashSet<String> set = new HashSet<String>();
    int area = 0;
    
    for (int[] rect : rectangles) {
        x1 = Math.min(rect[0], x1);
        y1 = Math.min(rect[1], y1);
        x2 = Math.max(rect[2], x2);
        y2 = Math.max(rect[3], y2);
        
        area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
        
        String s1 = rect[0] + " " + rect[1];
        String s2 = rect[0] + " " + rect[3];
        String s3 = rect[2] + " " + rect[3];
        String s4 = rect[2] + " " + rect[1];
        
        if (!set.add(s1)) set.remove(s1);
        if (!set.add(s2)) set.remove(s2);
        if (!set.add(s3)) set.remove(s3);
        if (!set.add(s4)) set.remove(s4);
    }
    
    if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) || set.size() != 4) return false;
    
    return area == (x2-x1) * (y2-y1);
}