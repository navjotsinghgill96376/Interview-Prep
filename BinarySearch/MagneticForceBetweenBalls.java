public class codefile{
     static boolean canPlace(int[] input,int m,int distance){
          int lastPlace = input[0];
          int cnt=1;
          for(int i=1;i<input.length;i++){
               if(input[i]-lastPlace>=distance){
                    cnt++;
                    lastPlace=input[i];
               }
          }
          return cnt>=m;
     }
    static int solve(int[]  input,int m){
        Arrays.sort(input);
        int n = input.length;
        int lo = 1,ans=0;
        int hi = input[n-1]-input[0];

        while(lo<=hi){
          int mid = (lo+hi)/2;

          if(canPlace(input,m,mid)){
               ans = Math.max(ans,mid);
               lo=mid+1;
          }else{
               hi=mid-1;
          }
        }

        return ans;

    }
}