package demo2.genericity.method;

import java.util.ArrayList;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName PAT
 * @package demo2.genericity.method
 * @className demo2.genericity.method.GenericDemo4
 * @date 2024/11/13 20:04
 * @description
 * 通配符和上下限
 *
 * 泛型不支持基本数据类型
 *
 */

class Car{
    public String name;
}
class XiaoMi extends Car{

}
class HuaWei extends Car{

}

public class GenericDemo5 {
    public static void main(String[] args)
    {
        // 目标： 理解通配符和上下限
        ArrayList<XiaoMi> xmList = new ArrayList<>();
        xmList.add(new XiaoMi());
        xmList.add(new XiaoMi());
        xmList.add(new XiaoMi());

        go(xmList);
    }

    public static void go(ArrayList<? extends Car> cars){

        cars.stream().forEach(System.out::println);
    }
}
