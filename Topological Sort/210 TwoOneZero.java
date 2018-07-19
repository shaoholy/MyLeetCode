package Leetcode2;

public class TwoOneZero {

}
//Topo Sort. similar to 207
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //int[] res=new int[numCourses];
        int[] prenum=new int[numCourses];
        List<Integer> res=new ArrayList<Integer>();
        int[][] matrix=new int[numCourses][numCourses];
        
        for(int i=0; i<prerequisites.length; i++){
            int thisco=prerequisites[i][0];
            int thepre=prerequisites[i][1];
            prenum[thisco]++;
            matrix[thepre][thisco]=1;
        }
        
        LinkedList<Integer> theq=new LinkedList<Integer>();
        for(int i=0; i<numCourses; i++){
            if(prenum[i]==0) theq.offer(i);
        }
        
        while(!theq.isEmpty()){
            int cur=theq.poll();
            res.add(cur);
            for(int i=0; i<numCourses; i++){
                if(matrix[cur][i]==1){
                    matrix[cur][i]=0;
                    if(--prenum[i]==0) theq.offer(i);
                }
            }
        }
        int[] finalres=new int[res.size()];
        for(int i=0; i<res.size(); i++) finalres[i]=res.get(i);
        return res.size()==numCourses? finalres: new int[0];
    }
}