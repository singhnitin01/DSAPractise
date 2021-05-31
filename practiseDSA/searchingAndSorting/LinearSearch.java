package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LinearSearch {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            String[] inp = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inp[0]);
            int k = Integer.parseInt(inp[1]);

            inp = br.readLine().trim().split(" ");
            int arr[] = new int[n];

            for(int i=0; i < n; i++){
                arr[i] = Integer.parseInt(inp[i]);
            }
            int ans = search(arr, n, k);
            System.out.println(ans);

        }
    }

    public static int search(int arr[], int n, int k) {

        for(int i=0; i< n; i++){
            if(arr[i] == k)
                return i+1;
        }
        return -1;
    }
}
