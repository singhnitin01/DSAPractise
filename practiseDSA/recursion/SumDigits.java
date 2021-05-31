package recursion;

public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(10));
        System.out.println(sumOfDigitsTail(9987,0));
    }

    public static int sumOfDigits(int n){
        if(n==0)
            return 0;
        return n % 10 + sumOfDigits(n/10);
    }

    public static int sumOfDigitsTail(int n, int sum){
        if(n==0)
            return sum;
        return sumOfDigitsTail(n/10, sum + n%10);
    }
}

// time and space complexity(auxiliary) : O(digits)