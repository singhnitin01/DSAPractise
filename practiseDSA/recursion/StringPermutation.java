package recursion;

import java.util.*;

public class StringPermutation {

    static List<String> list;

    public static void main(String[] args) {
        System.out.println(find_permutation("abc"));
    }


    public static List<String> find_permutation(String S) {
        list = new ArrayList<>();
        permute(S, 0);
        return list;
    }

    public static void permute(String s, int k){

        if(k == s.length()-1){
            list.add(s);
            return;
        }
        String s1;

        for(int i=k; i< s.length(); i++){
            char ch[] = s.toCharArray();
            swap(ch, i, k);
            s1 = new String(ch);
            permute(s1, k+1);

        }
    }

    public static void swap( char ch[],int i, int j){
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
