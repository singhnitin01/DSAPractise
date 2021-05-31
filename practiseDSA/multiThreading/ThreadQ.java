package multiThreading;

public class ThreadQ {

    int arr[] = {1,2,3,4};
    static int counter;

    public void print(){
        synchronized (this){
            for(int i=0; i<arr.length; i++){
                counter++;
                this.notify();
            }
        }
    }

    public static void main(String[] args) {

        ThreadQ obj = new ThreadQ();

        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                while(counter < obj.arr.length){
                    if(counter % 2 == 0) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else obj.print();
                }
            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                while(counter < obj.arr.length){
                    if(counter % 2 == 1) {
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else obj.print();
                }
            }
        });

        t1.start();
        t2.start();
    }
}
