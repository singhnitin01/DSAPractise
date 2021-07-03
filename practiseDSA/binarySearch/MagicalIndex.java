package binarySearch;

public class MagicalIndex {

    public static void main(String[] args) {
        System.out.println(findMagicalIndex(new int[]{-40, -20, -1, 1, 2, 3, 5, 7 ,9, 12, 13}));

                //{-10, -5, 0, 3, 7}));
    }

    public static int findMagicalIndex(int []arr){
        int l = 0, h = arr.length-1;
        int index = -1;
        while(l <= h){
            int mid = (l+h)/2;

            if(arr[mid] == mid){
                index = mid;
                h = mid-1;
            }

            if (arr[mid] > mid)
                h = mid-1;
            else l = mid+1;
        }
        return index;
    }
}
