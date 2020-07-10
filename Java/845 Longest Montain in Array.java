class Solution {
    public int longestMountain(int[] A) {
        if(A.length<3) {
            return 0;
        }
        int curr=-1;
        int itr=1;
        while(itr+1<A.length) {
            if(A[itr]>A[itr+1]&&A[itr]>A[itr-1]) {
                int j=itr-1;
                int k=itr+1;
                int temp=3;
                while(j-1>=0){
                    if(A[j-1]<A[j]) {
                        temp+=1;
                        j-=1;
                    }
                    else{break;}
                }
                while(k+1<A.length) {
                    if(A[k+1]<A[k]) {
                        temp+=1;
                        k+=1;
                    }
                    else {
                        break;
                    }
                }
                curr=(curr<temp)?temp:curr;
            }
            itr+=1;
        }
        return (curr!=-1)?curr:0;
    }
}