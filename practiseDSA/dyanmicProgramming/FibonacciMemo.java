package dyanmicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FibonacciMemo {

    public static Map<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(br.readLine().trim());
        while(tests-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            map = new HashMap<>();
            System.out.println(fibMemo(n));
        }
    }

    public static int fibMemo(int n){
        if(n <= 2)
            return 1;
        if(map.containsKey(n))
            return map.get(n);
        map.put(n, (fibMemo(n-1)+ fibMemo(n-2)));
        return map.get(n);
    }
}
