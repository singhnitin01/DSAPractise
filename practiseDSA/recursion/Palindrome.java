package recursion;

public class Palindrome {

    public static void main(String[] args) {
        String data = "abcbaa";
        System.out.println(checkPalindrome(data, 0, data.length()-1));
        int i =1, j =2;
        fun(i++, j--);
    }

    public static void fun(int i, int j ){
        System.out.println(i+"----"+j);
    }
    public static boolean checkPalindrome(String data, int i, int j){
        if(i >= j)
            return true;
        // below commented line can be cut short with the help of short circuit functionality of && operator
        /*if(data.charAt(i) != data.charAt(j))
            return false;
        return checkPalindrome(data, i+1, j-1);*/

        return data.charAt(i) == data.charAt(j) && checkPalindrome(data, i+1, j-1);
    }
}

// time complexity is Big O(n)
// auxiliary space is Big O(n)
