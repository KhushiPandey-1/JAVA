package Array;

public class Allot_Books {

  public static int Allot(int[] arr, int k) {
        int min = Max(arr); // Minimum should be the maximum element in the array
//        20
        int max = sumOf(arr); // Maximum sum of all elements in the array
//        35
        int res = 0;
        
        // Binary search for the minimum feasible maximum pages
        while (min <= max) {  //20 <= 35  || 
            int mid = (min + max) / 2;   //20+35/2 = 27.5  || 
            if (feasible(arr, k, mid)) { 
                res = mid;
                max = mid - 1;
            } else {
                min = mid + 1;  // 
            }
        }
        return res;
    }

    // Helper function to check if a given maximum number of pages per student is feasible
    public static boolean feasible(int[] arr, int k, int res) {  // k=2, res = 27
        int stu = 1, sum = 0;  
        for (int i = 0; i < arr.length; i++) {  //a[0] = 10 // a[1] = 5
//            System.out.println("1st "+i+" : "+arr[i] +" res :" + res);
            if (sum + arr[i] > res) { // 0+10 > 27  ||
//                System.out.println("2nd "+i+" : "+arr[i] + " res :" + res);
//                System.out.println(sum);
                stu++;  // s = 1 -> 2 
                sum = arr[i]; // sum = 10
                if (stu > k) {  // 2 > 2
                    return false;
                }
            } else {
                sum += arr[i];
            }
        }
        return true;
    }

    // Helper function to calculate the maximum value in the array
    public static int Max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // Helper function to calculate the sum of all elements in the array
    public static int sumOf(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int [] arr = {10,5,20};
         int result = Allot(arr, 2);
        System.out.println("Minimum possible maximum number of pages: " + result);
    }
    
}
