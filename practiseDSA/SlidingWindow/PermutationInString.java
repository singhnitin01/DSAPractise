package SlidingWindow;

// leetcode - 567. Permutation in String

public class PermutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaooo"));
        System.out.println(checkInclusion("a", "ab"));
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if(n2 < n1)
            return false;

        int left = 0, right = 0; // left is the leftmost index of sliding window and right is rightmost index of sliding window
        int []hash1 = new int[26];
        int []hash2 = new int[26];

        for(int i=0; i<n1; i++){
            hash1[s1.charAt(i)-'a']++;
            hash2[s2.charAt(i)-'a']++;
            right++;
        }
        right--;

        while(right < n2){
            int j =0;
            while(j < 26){
                if(hash1[j] != hash2[j])
                    break;
                j++;
            }
            if(j == 26)
                return true;
            right++;
            if(right == n2)
                return false;

            hash2[s2.charAt(left++) - 'a']--;
            hash2[s2.charAt(right) - 'a']++;

        }
        return false;
    }
}
