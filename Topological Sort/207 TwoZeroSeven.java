package Leetcode2;

public class TwoZeroSeven {

}
// topo sort: matrix to record and sort
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len=prerequisites.length;
        int[][] matrix=new int[numCourses][numCourses];
        int[] prenum=new int[numCourses];
        
        for(int i=0; i<len; i++){
            int cour=prerequisites[i][0];
            int pre=prerequisites[i][1];
            prenum[cour]++;
            matrix[pre][cour]=1;
        }
        int cnum=0; 
        Queue<Integer> theq=new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(prenum[i]==0){
                theq.add(i);}
        }
        while(!theq.isEmpty()){
            int cur=theq.poll();
            cnum++;
            for(int i=0; i<numCourses; i++){
                if(matrix[cur][i]==1){
                    matrix[cur][i]=0;
                    prenum[i]--;
                    if(prenum[i]==0){
                        theq.add(i);
                    }
                }
            }
        }
        return cnum==numCourses;
    }
}