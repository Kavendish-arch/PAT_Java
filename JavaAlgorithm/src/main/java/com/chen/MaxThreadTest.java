
public class MaxThreadTest {

    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory");
        System.out.println(maxMemory / 1024 / 1024 / 1024);
        // System.out.println();
        int threadStackSize = 1024 * 1024; // 假设每个线程栈大小为1MB
        int maxThreadCount = (int) (maxMemory / threadStackSize);
        System.out.println("理论最大线程数: " + maxThreadCount);
    }
}
