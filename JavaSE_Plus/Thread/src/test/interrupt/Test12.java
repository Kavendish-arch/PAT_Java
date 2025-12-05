package interrupt;

/**
 * 打断正常的线程
 */
public class Test12 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println();
            System.out.println("work ...");

            while (true) {
                boolean isInterrupted = Thread.currentThread().isInterrupted();
                if (isInterrupted) {
                    System.out.println("打断标记:" + isInterrupted);
                    break;
                }
            }

        }, "t1");

        t1.start();

        Thread.sleep(10000);
        System.out.println("打断前 打断标记:" + t1.isInterrupted());
        System.out.println("interrupt");
        t1.interrupt();
        System.out.println("打断标记:" + t1.isInterrupted());
    }
}
