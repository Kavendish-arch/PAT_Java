public class Main {

    /**
     * 洗水壶 1分钟 烧开水 15分钟 洗茶壶 1分钟 洗茶杯 2分钟 拿茶叶 1分钟
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("洗水壶");
            System.out.println("烧开水");
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("洗茶壶");
            System.out.println("洗茶杯");
            System.out.println("拿茶叶");
 
        }, "t2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("泡茶");
    }
}
