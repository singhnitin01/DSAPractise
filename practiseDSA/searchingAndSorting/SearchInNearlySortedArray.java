package searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInNearlySortedArray {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            String input[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int key = Integer.parseInt(input[1]);


            input = br.readLine().trim().split(" ");
            int []arr = new int[n];

            for(int i=0; i< n; i++)
                arr[i] = Integer.parseInt(input[i]);

            int index = searchInNearlySortedArray(arr, n, key);
            System.out.println(index);
        }
    }

    public static int searchInNearlySortedArray(int[] arr, int n, int key){
        int low = 0, high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == key)
                return mid;
            if(mid -1 >= 0 && arr[mid-1] == key)
                return mid -1;
            if(mid+1 < n && arr[mid+1] == key)
                return mid+1;

            if(key > arr[mid]) // since if key is greater than mid element then it would've be on right as we already checked +1 and -1 indexes
                low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
// e.g. {10 3 40 20 50 80 70}, key = 80
// e.g. {10 3 40 20 50 80 70}, key = 3
// e.g. {10 3 40 20 50 80 70}, key = 90