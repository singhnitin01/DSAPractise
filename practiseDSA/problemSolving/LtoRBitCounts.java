package problemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class LtoRBitCounts {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());

        while(tests-- > 0){
            Long l = Long.parseLong(br.readLine().trim());
            //String []input = br.readLine().trim().split(" ");
            Long r = Long.parseLong(br.readLine().trim());

            System.out.println(countPrimesInBit(l,r));


        }
    }

    public static long countPrimesInBit(Long l, Long r){
        System.out.println(Long.bitCount(l));
        System.out.println(Long.bitCount(r));
        return 0;
    }
}
