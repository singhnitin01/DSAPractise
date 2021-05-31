package binarySearch;

public class NthRoot {

    public static void main(String[] args) {
        System.out.println(nthRoot(2,5));
        System.out.println(nthRoot(3,27));

    }


    public static double nthRoot(int n, int m)
    {
        double epsilon = 0.00000000001;
        double low=0, high=m;

        double guess = Double.MIN_VALUE;

        while(low < high){
            double mid = (low + high) /2;
            guess = Math.pow(mid, n);
            double diff = m - guess ;
            if(Math.abs(diff) >=0 && Math.abs(diff) <= epsilon)
                return mid;
            else if(diff > 0)
                low = mid;
            else high = mid;
        }
        return -1;
    }
}
