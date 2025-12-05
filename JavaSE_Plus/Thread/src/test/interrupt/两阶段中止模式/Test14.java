
import java.util.concurrent.locks.LockSupport;

public class Test14 {

    public static void main(String[] args) {
        test3();
    }

    public static void test3() {
        Thread t1 = new Thread(() -> {
            System.out.println();
            System.out.println("park");
            LockSupport.park();
            System.out.println("unpark");
            // System.out.println("打断状态" + Thread.currentThread().isInterrupted());
            System.out.println("打断状态" + Thread.interrupted());

            LockSupport.park();
            System.out.println("unpark");

        });
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t1.interrupt();

    }
}
