package interrupt;

public class Test11 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println();
            System.out.println("sleep...");
            try {
                Thread.sleep(5000); // wait, join
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        t1.start();

        // Thread.sleep(1000);
        System.out.println("打断前 打断标记:" + t1.isInterrupted());
        System.out.println("interrupt");
        t1.interrupt();
        System.out.println("打断标记:" + t1.isInterrupted());
    }
}
