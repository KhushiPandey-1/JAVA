package Array;

public class Allocation_Books_2_solution {
    public static int allocation(int[] arr,int n,int m){
        int sum = 0;
        int ans = -1;
        if(m > n){
            return -1;
        }
        for(int i =0;i <n;i++){
            sum += arr[i];
        }
        int st = 0, end = sum;
        while(st <= end){
            int mid = st + (end-st)/2;
            if(isValid(arr,n,m,mid)){
                ans = mid;
                end = mid -1;
            }else{
                st = mid + 1;
            }
        }
        return ans;
    }
    public static boolean isValid(int [] arr,int n,int m,int mid){
      int student = 1,sum = 0;
      for(int i = 0;i <n;i++){
          if(arr[i] > mid){
              return false;
          }
          if(sum + arr[i] <= mid){
              sum += arr[i];
          }else{
               student++;
               sum = arr[i];
          }
          
      }
      return student <= m;
    }
    public static void main(String[] args) {
       int [] arr = {2,1,3,4};
       int result = allocation(arr,arr.length,2);
        System.out.println("Minimum possible maximum number of pages: " + result);
    }
    
}
