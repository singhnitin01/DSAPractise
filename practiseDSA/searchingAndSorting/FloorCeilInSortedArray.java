package searchingAndSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloorCeilInSortedArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- >0){
            String []input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int key = Integer.parseInt(input[1]);

            input = br.readLine().trim().split(" ");
            int []arr = new int[n];

            for(int i =0; i<n; i++)
                arr[i] = Integer.parseInt(input[i]);

            System.out.println("Floor: "+floor(arr, n, key));
            System.out.println("Ceil: "+ceil(arr, n, key));

        }
    }

    public static int floor(int arr[], int n, int key){
        int low = 0, high = n-1, result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == key)
                return mid;
            if(arr[mid] < key){
                result = arr[mid];
                low = mid+1;
            }
            else high = mid-1;
        }
        return result;
    }

    public static int ceil(int arr[], int n, int key){
        int low = 0, high = n-1, result = -1;
        while(low <= high){
            int mid = low + (high-low)/2;

            if(arr[mid] == key)
                return mid;
            if(arr[mid] > key){
                result = arr[mid];
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return result;
    }
}
