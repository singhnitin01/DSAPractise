package problemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DistributeBananas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            //String []input = br.readLine().trim().split(" ");

            System.out.println(canDistribute(n));
        }
    }

    public static boolean canDistribute(int n){
        if(n<=2)
            return false;

        int squareRoot = (int)Math.sqrt(n);

        for(int i =2; i<=squareRoot; i++){
            if(n%i == 0)
                return true;
        }
        return false;
    }
}
