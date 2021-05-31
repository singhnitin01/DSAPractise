package recursion;

public class RopeCutting {

    public static void main(String[] args) {
        System.out.println(ropeCutting(23, 12, 9, 11)); // rope length = 23, cut to be made are 12, 9, and 11
        System.out.println(ropeCutting(9, 2, 2, 2));
        System.out.println(ropeCutting(5, 2, 5, 1));
    }

    public static int ropeCutting(int n, int a, int b, int c){

        int A = 0, B=0, C=0;

        if(n == 0)
            return 0;
        if(n < 0)
            return -1;

        // below code can ne reduced

        /*A = ropeCutting(n-a, a, b, c);
        if(A != -1)
            A += 1;

        B = ropeCutting(n-b, a, b, c);
        if(B != -1)
            B += 1;

        C = ropeCutting(n-c, a, b, c);
        if(C != -1)
            C += 1;

        return Math.max(Math.max(A,B), C);*/

        int result = Math.max(Math.max(ropeCutting(n-a, a, b, c), ropeCutting(n-b, a, b, c)), ropeCutting(n-c, a, b, c));
        return result == -1 ? -1 : result+1;
    }

    // time complexity is Big O(3 ^ n) and it can be improved through dynamic programming
}

// Above problem uses Induction property for recursion i.e. We need to take care of nth input function and rest will be taken care by recursion
