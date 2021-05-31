package multiThreading;


class MyThread extends Thread{
    Display d;
    String name;

    MyThread(Display d, String name){
        this.d = d;
        this.name = name;
    }

    @Override
    public void run() {
        /*for(int i=0; i<10; i++){
            System.out.println("in thread and i is "+i);
            ;;;;;;;;;;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ;;;;;;;;

        }*/
        d.wish(name);
    }
}



class Display{
    public void wish(String name)  {


        synchronized (this){
            for (int i=0; i<5; i++){
                System.out.println("Good Morning: ");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        }


    }
}

public class ThreadExecution {

    public static void main(String[] args) throws InterruptedException {
        /*MyThread t = new MyThread();
        t.start();
        t.getName();
        t.setName("thread123");
        t.join(4000);
        for(int i=0; i< 10; i++){
            System.out.println("In main and i is "+ i);
        }
        t.isAlive();*/
        Display d = new Display();

        MyThread t1 = new MyThread(d, "Dhoni");
        MyThread t2 = new MyThread(d, "Yuvraj");
        t1.start();
        t2.start();
    }
}
