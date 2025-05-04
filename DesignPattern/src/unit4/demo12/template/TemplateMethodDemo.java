package unit4.demo12.template;

import java.util.Scanner;

/**
 * @author chenyingtao
 * @version 1.0
 * @projectName DesignPattern
 * @package unit4.demo12
 * @className unit4.demo12.template.TemplateMethodDemo
 * @date 2025/4/9 15:50
 * @description @todo
 */
// 抽象模板类
abstract class BeverageTemplate {
    // 模板方法（final防止子类覆盖）
    public final void prepareBeverage() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    // 通用步骤实现
    private void boilWater() {
        System.out.println("烧开水");
    }

    private void pourInCup() {
        System.out.println("倒入杯中");
    }

    // 抽象方法（由子类实现）
    protected abstract void brew();

    protected abstract void addCondiments();

    // 钩子方法（可选覆盖）
    protected boolean customerWantsCondiments() {
        return true;
    }
}

// 具体子类实现
class Coffee extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("冲泡咖啡粉");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入糖和牛奶");
    }
}

class Tea extends BeverageTemplate {
    @Override
    protected void brew() {
        System.out.println("浸泡茶叶");
    }

    @Override
    protected void addCondiments() {
        System.out.println("加入柠檬");
    }

    // 覆盖钩子方法
    @Override
    protected boolean customerWantsCondiments() {
        System.out.print("需要加柠檬吗？(y/n): ");
        // 此处模拟用户输入（实际应用可替换为真实输入逻辑）
        Scanner scanner = new Scanner(System.in);
        System.out.println("用户输入：" + scanner.nextLine());
        String input = scanner.nextLine();
        return "y".equalsIgnoreCase(input);
    }
}

// 客户端使用
public class TemplateMethodDemo {
    public static void main(String[] args) {

        System.out.println("=== 制作咖啡 ===");
        BeverageTemplate coffee = new Coffee();
        coffee.prepareBeverage();
        System.out.println();
        System.out.println("=== 制作茶 ===");
        BeverageTemplate tea = new Tea();
        tea.prepareBeverage();
    }
}
