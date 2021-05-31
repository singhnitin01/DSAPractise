package multiThreading;

import java.util.HashMap;

class PhotoFrame{
    int id;
    String name;
    double price;

    public PhotoFrame(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }
}

class MaintainPhotoFrame{

    HashMap<String, PhotoFrame> availableFrames = new HashMap<>();


    public boolean isAvailable(String type){
        synchronized (availableFrames){
            if(!availableFrames.isEmpty() && availableFrames.containsKey(type)){
               System.out.println("Availability: Stock of "+ type+" available");
                return true;
            }
            System.out.println("Availability: Out of stock");
            return false;
        }
    }

    public void buyStock(String type){
        synchronized (availableFrames){
            if(!availableFrames.isEmpty() && availableFrames.containsKey(type)){
                System.out.println("Buying item "+ type);
                availableFrames.remove(type);
            }
            else{
                System.out.println("Item not available!");
            }
        }
    }


    public void updateToBuyer(String type){
        synchronized (availableFrames){
            while(availableFrames.isEmpty() && !availableFrames.containsKey(type)){
                System.out.println("Item "+type+" out of stock! Will be notified once available");
                try {
                    availableFrames.wait();
                } catch (InterruptedException e) {
                    System.out.println("Wait interrupted!");
                }
            }
            System.out.println("Item "+type+" available for buyer to buy. Notification sent to Buyer!");
            //buyStock(type);
        }
    }

    public void updateToUI(String type){
        synchronized (availableFrames){
            while(availableFrames.isEmpty() && !availableFrames.containsKey(type)){
                System.out.println("Screen: Item "+type+" out of stock! Select Notify Me option to be notified!");
                try {
                    availableFrames.wait();
                } catch (InterruptedException e) {
                    System.out.println("Wait interrupted!");
                }
            }
            System.out.println("Screen: Item "+ type+" available");
        }
    }

    public void updateStock(String type, PhotoFrame frame){
        synchronized (availableFrames){
            availableFrames.put(type, frame);
            availableFrames.notifyAll();
            System.out.println("Seller has added stock of item "+type+" and notified!");
        }
    }
}

public class BuyerSellerThreads {

    public static void main(String[] args) {
        MaintainPhotoFrame maintainPhotoFrame = new MaintainPhotoFrame();

        PhotoFrame frame = new PhotoFrame(1, "Wooden", 12.2);
        String type = frame.getName();


        Thread UIThread = new Thread(new Runnable() {
            @Override
            public void run() {
                maintainPhotoFrame.updateToUI(type);
            }
        }, "UIThread");
        Thread BuyerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                if(maintainPhotoFrame.isAvailable(type)){
                    maintainPhotoFrame.buyStock(type);
                }
                else maintainPhotoFrame.updateToBuyer(type);
            }
        }, "BuyerThread");
        Thread SellerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                maintainPhotoFrame.updateStock(type, frame);
            }
        }, "SellerThread");

        UIThread.start();
        BuyerThread.start();
        SellerThread.start();
    }


}
