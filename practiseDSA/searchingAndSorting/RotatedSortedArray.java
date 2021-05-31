package searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RotatedSortedArray {

    public static void main(String []arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());

            String inp[]= br.readLine().trim().split(" ");

            int arr[] = new int[n];
            for(int i=0; i<n; i++)
                arr[i] = Integer.parseInt(inp[i]);

            int rotation = findRotationInSortedArray(arr, n);
            System.out.println(rotation);

        }
    }

    public static int findRotationInSortedArray(int arr[], int n){
        int low = 0, high = n-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            int left = (n + mid -1)% n;
            int right = (mid +1) %n;
            if(arr[mid] < arr[left] && arr[mid] < arr[right])
                return mid;
            // since mid is not the smallest element hence we need to decide where to move
            if(arr[mid] > arr[high])  // mid element is greater than high then it's sure smallest will be right side
                low = mid+1;
            else high = mid-1; // else on right side
        }
        return 0;

        // below is other refined solution which plays on instinct
        /*while(low < high){
            int mid = low + (high -low)/2;

            if(mid < high && arr[mid] > arr[mid+1]) // check if mid is greater than next element if it exists
                return mid+1; // then the smallest element will be mid+1
            if(arr[mid] > arr[high]) // since mid element is not the greatest then we move next if there exists greater element
                low = mid+1;
            else high = mid;  // since element is smaller than the last element then mid can be smallest hence we keep high as mid
        }*/
    }
}
// ex: 5 6 7 8 1 2 3
// ex: 9 10 1 2 3 4 5 6
// ex: 1 2 3 4 5 6
