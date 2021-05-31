package searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PeakInMountain {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            String []input = br.readLine().trim().split(" ");
            int []arr = new int[n];

            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(input[i]);

            System.out.println(findPeakInMountain(arr, n));
        }
    }

    public static int findPeakInMountain(int []arr, int n){
        int low = 0, high = n-1;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(mid ==0){
                if(arr[0] > arr[1])
                    return arr[0];
                return arr[1];
            }
            else if(mid == n-1)
                return arr[n-1];
            else if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1])
                return arr[mid];
            else if(arr[mid] > arr[mid-1])
                low = mid+1;
            else high = mid-1;
        }
        return -1;

        // Or use below method

        /*while(low < high){
            int mid = low + (high-low)/2;

            if(arr[mid] < arr[mid+1])
                low = mid+1; // since mid can never be the peak
            else high = mid; // since the mid can be the peak
        }
        return low;      // since there will always be a peak so when low == high that is the solution i.e. peak element
        */
    }
}
