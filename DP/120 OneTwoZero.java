package Leetcode2;

public class OneTwoZero {

}
//1, top to bottom
public int minimumTotal(List<List<Integer>> triangle) {
      if(triangle==null || triangle.size()==0) return 0;
      if(triangle.size()==1) return triangle.get(0).get(0);
      int res=Integer.MAX_VALUE; 
      List<Integer> cur=new ArrayList<Integer>();
      cur.add(triangle.get(0).get(0));
      for(int i=1; i<triangle.size(); i++){
          List<Integer> nextcur=new ArrayList<Integer>();
          for(int j=0; j<=i; j++){
              int t=triangle.get(i).get(j);
              if(j==0 || j==i){
                  if(j==0) t+=cur.get(0);
                  else t+=cur.get(j-1);
                  nextcur.add(t);
              }else{
                  int small=Math.min(cur.get(j), cur.get(j-1));
                  t+=small;
                  nextcur.add(t);
              }
              //System.out.println(t+" i "+i+" j "+j);
              if(i==triangle.size()-1) res=Math.min(res, t);
          }
          cur=nextcur;
      }
      return res;
  }

//2, bottom to top
public int minimumTotal(List<List<Integer>> triangle) {
    if(triangle==null || triangle.size()==0) return 0;
    if(triangle.size()==1) return triangle.get(0).get(0);
    int[] cache=new int[triangle.size()];
    int i=0;
    for(int x: triangle.get(triangle.size()-1)) cache[i++]=x;
    int depth=triangle.size()-1;
    for(int j=depth-1; j>=0; j--){
        for(int k=0; k<triangle.get(j).size();k++){
            int curnum=triangle.get(j).get(k);
            cache[k]=curnum+Math.min(cache[k], cache[k+1]);
        }
    }
    return cache[0];
}