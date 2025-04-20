

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Callable;

public class CallableTest implements Callable<String> {
    private String string;

    public CallableTest(String string) {
        this.string = string;
    }

    //        @Override
//    public String call() throws Exception {
//        任务阻塞5秒，异常向上抛出
//        return this.string;
//    }
//    异常也可以try catch解决
    @Override
    public String call() {
        //任务阻塞5秒  异常向上抛出
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.string;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new CallableTest("my callable is ok!");
        FutureTask<String> task = new FutureTask<String>(callable);
        long beginTime = System.currentTimeMillis();
        //创建线程
        new Thread(task).start();
        //调用get()方法阻塞主线程
        String str = task.get();
        long endTime = System.currentTimeMillis();
        System.out.println("hello :" + str);
        System.out.println("time :" + (endTime - beginTime) / 1000);
    }

}


