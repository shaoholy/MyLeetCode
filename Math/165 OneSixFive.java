package Leetcode2;

public class OneSixFive {

}
//
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] onev=version1.split("\\.");
        String[] twov=version2.split("\\.");
        for(int i=0; i<Math.min(onev.length, twov.length); i++){
            if(Integer.parseInt(onev[i])!=Integer.parseInt(twov[i])){
                // System.out.println(onev[i]);
                return Integer.parseInt(onev[i])>Integer.parseInt(twov[i])? 1:-1;
            }
        }
        if(onev.length==twov.length) return 0;
        else if(onev.length>twov.length){
            for(int i=twov.length; i<onev.length; i++){
                if(Integer.parseInt(onev[i])!=0) return 1;
            }
            return 0;
        }else{
            for(int i=onev.length; i<twov.length; i++){
                if(Integer.parseInt(twov[i])!=0) return -1;
            }
            return 0;
        }
    }
}
//zhongdian: compareTo only use Integer! not int! 
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] onev=version1.split("\\.");
        String[] twov=version2.split("\\.");
        for(int i=0; i<Math.max(onev.length, twov.length); i++){
            Integer v1= i>=onev.length? 0: Integer.parseInt(onev[i]);
            Integer v2= i>=twov.length? 0: Integer.parseInt(twov[i]);
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0; 
    }

}