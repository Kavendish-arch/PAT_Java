package unit2.demo1.AdapterDemo;

/**
* @projectName DesignPattern
* @package unit2.demo1.AdapterDemo
* @className unit2.demo1.AdapterDemo.AdapterDemo

* @author chenyingtao
* @date 2025/4/10 14:20
* @version 1.0
* @description @todo 
*/
// 目标接口（用户需要的USB充电接口）
interface USB {
    void charge();
}

// 被适配者（现有的Type-C充电器）
class TypeCCharger {
    public void typeCCharge() {
        System.out.println("Type-C充电器正在充电...");
    }
}

class DCAdapter implements USB {

    private TypeCCharger typeCCharger;

    public DCAdapter(TypeCCharger typeCCharger) {
        this.typeCCharger = typeCCharger;
    }

    @Override
    public void charge() {
        System.out.println("正在使用USB接口充电...");
        typeCCharger.typeCCharge(); // 调用被适配者的方法
        System.out.println("USB接口充电结束...");
    }
}
// 适配器（将Type-C转换为USB接口）
class TypeCToUSBAdapter implements USB {
    private TypeCCharger typeCCharger;

    public TypeCToUSBAdapter(TypeCCharger typeCCharger) {
        this.typeCCharger = typeCCharger;
    }

    @Override
    public void charge() {
        System.out.println("正在使用TypeC接口充电...");
        typeCCharger.typeCCharge(); // 调用被适配者的方法
        System.out.println("TypeC接口充电结束...");
    }
}

// 客户端使用示例
public class AdapterDemo {
    public static void main(String[] args) {
        // 现有设备
        TypeCCharger typeC = new TypeCCharger();

        // 通过适配器使用USB接口充电
        USB usbAdapter = new TypeCToUSBAdapter(typeC);
        usbAdapter.charge(); // 输出：Type-C充电器正在充电...

        //
        DCAdapter dcAdapter = new DCAdapter(typeC);
        dcAdapter.charge();
    }
}
