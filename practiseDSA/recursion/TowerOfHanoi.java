package recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {
        towerOfHanoi(4, 'A', 'B', 'C');
    }
    // A is source, B is auxiliary, and C is destination
    public static void towerOfHanoi(int n, char A, char B, char C){
        if(n == 1){
            System.out.println("move 1 from "+ A +" to "+C);
            return;
        }
        towerOfHanoi(n-1, A, C, B);
        System.out.println("move "+n+" from "+ A +" to "+C);
        towerOfHanoi(n-1, B, A, C);
    }
}

/*
Recurrence relation: T(n) = 2T(n-1) + c
Hence Time Complexity: O(2 ^n);
*/
