import java.util.concurrent.FutureTask;

public class MyThread {

    public static void Thread1(){
        new Thread(){
            @Override
            public void run() {
                System.out.println("继承 Thread");
            }
        }.start();

        //函数式接口，有且只有一个方法

        new Thread( () ->{
            System.out.println("实现Runnable");

        }).start();

        FutureTask<String> futureTask = new FutureTask<>(()->{
            System.out.println("实现Callable");
            return "实现callable接口";
        });
        new Thread(futureTask).start();
    }

    public static void main(String[] args) {
        Thread1();
    }
}
