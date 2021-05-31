package problemSolving;

public class MaxLengthSubArray {

    public static void main(String[] args) {
        System.out.println(getMaxLen(new int[]{70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86}));
    }

    public static int getMaxLen(int[] nums) {
        int max = 0;

        for(int i=0; i<nums.length; i++){
            double prod = 1;
            int count = 0;
            for(int j =i; j < nums.length; j++){
                prod *= nums[j];
                if(prod == 0){
                    prod = 1;
                    count = 0;
                }
                else if(prod > 0){
                    count ++;
                    if(max < count)
                        max = count;
                }
                else
                    count++;
            }
        }

        return max;
    }
//[70,-18,75,-72,-69,-84,64,-65,0,-82,62,54,-63,-85,53,-60,-59,29,32,59,-54,-29,-45,0,-10,22,42,-37,-16,0,-7,-76,-34,37,-10,2,-59,-24,85,45,-81,56,86]
}
