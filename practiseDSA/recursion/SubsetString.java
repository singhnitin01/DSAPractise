package recursion;

public class SubsetString {
    public static void main(String[] args) {
        subSet("abc", "", 0);
    }

    public static void subSet(String str, String curr, int index){
        if(index == str.length()){
            System.out.print(curr+ " ");
            return;
        }
        subSet(str, curr, index+1); // excluding the new character
        subSet(str, curr + str.charAt(index), index+1); // including the new character;
    }
}

