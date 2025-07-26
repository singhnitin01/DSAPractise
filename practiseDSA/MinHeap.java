public class MinHeap {

    private int capacity = 15;
    static int size = -1;

    private int[] items = new int[capacity];

    public void swap(int index1, int index2){
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public int peek(){
        if(size == 0)
            throw new IllegalStateException("Emmpty Heap!");
        return items[0];
    }

    public int deleteMin(){
        if(size < 0)
            throw new IllegalStateException("Emmpty Heap!");
        int min = items[0];
        items[0] = items[size--];
        heapifyDown(0);
        return min;
    }

    public void heapifyDown(int index){
        if(index >= size )
            return;
        int left = 2 * index +1;
        int right = 2* index + 2;
        Integer minimum = index;
        if( checkChildExists(left)){
            if(items[minimum] >= items[left])
                minimum = left;
            if(checkChildExists(right)){
                if(items[minimum] > items[right])
                    minimum = right;
            }
            if(minimum == index )
                return;
            swap(index, minimum);
            heapifyDown(minimum);
        }
    }

    public void buildMinHeap(){
        for(int i = size/2;  i >= 0; i--){
            heapifyDown(i);
        }
    }

    public void insert(int val){
        if(size >= capacity -1)
            throw new IllegalStateException("Emmpty Heap!");
        items[++size] = val;
        heapifyUp(size);
    }

    public void heapifyUp(int index){
        int parent = getParent(index);
        if(parent < 0)
            return;
        if(items[index] < items[parent]){
            swap(index, parent);
            heapifyUp(parent);
        }

    }

    public void heapSort(){
        if(size < 0)
            return;
        int last = size;
        while(size >= 0){
            int min = deleteMin();
            items[size+1] = min;
        }
        System.out.println("\nAfter In Place Heap Sort:");
        for(int i = last; i >= 0; i--)
            System.out.print(items[i]+" ");
    }

    public int getParent(int index){
        if(index == 0)
            return -1;
        return (index - 1)/2;
    }

    public boolean checkChildExists(int index){
        if(index <= size)
            return true;
        return false;
    }

    public void bfsHeap(){
        System.out.print("\nHeap: ");
        for( int i = 0; i<= size ; i++)
            System.out.print(items[i]+" ");
    }



    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        //minHeap.items = new int[]{11, 17, 13, 18, 21, 19, 17, 43, 23, 26, 29, 31, 0, 0, 0};
        minHeap.items = new int[]{18, 17, 19, 17, 21, 13, 11, 43, 23, 26, 29, 31, 0, 0, 0};
        size = 11;
        /*System.out.println("Peek of heap is: "+ minHeap.peek());
        minHeap.bfsHeap();*/

        minHeap.bfsHeap();
        minHeap.buildMinHeap();
        minHeap.bfsHeap();

        minHeap.insert(9);
        minHeap.bfsHeap();
        /*for(int i=0; i<=11; i++){
            System.out.print("\nDeleting of min heap is: "+ minHeap.deleteMin());
            minHeap.bfsHeap();
        }*/

        minHeap.heapSort();

    }
}