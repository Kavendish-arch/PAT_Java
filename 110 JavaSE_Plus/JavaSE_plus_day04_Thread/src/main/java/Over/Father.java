package Over;

/**
 * 父类，演示方法重载和重写的示例类
 * 包含多个重载的add方法以及供子类重写的示例
 * 这段Java代码演示了面向对象编程中的方法重载和重写概念：
 *
 * **功能说明：**
 * - `Father`父类包含两个重载的
 * [add]方法：一个返回两数之和，另一个接受三个参数但返回固定字符串
 * - [Son]子类继承`Father`类并重写了[add(int x, int y)] 方法，实现相同的加法逻辑
 * - 展示了Java中方法重载（同一类中同名不同参）和方法重写（子类重新定义父类方法）的基本用法
 * 
 * @author chenyingtao
 */
public class Father {

    /**
     * 将两个整数相加
     * @param x 第一个整数
     * @param y 第二个整数
     * @return 两个整数的和
     */
    public int add (int x, int y){
        return x+y;
    }
    
    /**
     * 接受三个整数参数的add方法重载版本
     * @param x 第一个整数
     * @param y 第二个整数
     * @param z 第三个整数
     * @return 固定返回"重载"字符串
     */
    public String add (int x, int y, int z){

        return "重载";
    }
}


/**
 * 子类，继承自Main类
 * 演示方法重写的概念
 */
class Son extends Father
{
    /**
     * 重写父类的add方法
     * @param x 第一个整数
     * @param y 第二个整数
     * @return 两个整数的和
     */
    @Override
    public int add (int x, int y){
        return x+y;
    }
}