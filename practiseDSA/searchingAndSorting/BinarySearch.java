package searchingAndSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BinarySearch {

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
            int ans = binarySearch(arr,  k);
            System.out.println(ans);

        }
    }

    public static int binarySearch(int[] nums, int target) {
        int i = 0, j = nums.length -1;

        while(i <= j){
            int mid = (j+i)/2;
            if(nums[mid] == target)
                return mid;
            else if(target > nums[mid])
                i = mid + 1;
            else
                j = mid - 1;
        }
        return -1;
    }
}
