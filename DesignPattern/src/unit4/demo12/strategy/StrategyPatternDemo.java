package unit4.demo12.strategy;

/**
* @projectName DesignPattern
* @package unit4.demo12
* @className unit4.demo12.Main

* @author chenyingtao
* @date 2025/4/9 15:30
* @version 1.0
* @description @todo 
*/

// 1. 定义策略接口
interface PaymentStrategy {
    void pay(int amount);
}

// 2. 实现具体策略类
class AlipayStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("支付宝支付：" + amount + "元");
    }
}

class WechatPayStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("微信支付：" + amount + "元");
    }
}

class BankCardStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("银行卡支付：" + amount + "元");
    }
}

// 3. 定义上下文类
class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        // 定义初始策略
        this.strategy = strategy;
    }

    public void executePayment(int amount) {
        strategy.pay(amount);
    }

    // 可选：动态切换策略的方法
    public void setStrategy(PaymentStrategy strategy) {
        System.out.println("切换支付策略为：" + strategy.getClass().getSimpleName());
        this.strategy = strategy;
    }
}

// 4. 使用示例
public class StrategyPatternDemo {
    public static void main(String[] args) {
        // 创建支付策略
        PaymentStrategy alipay = new AlipayStrategy();
        PaymentStrategy wechat = new WechatPayStrategy();
        PaymentStrategy bankCard = new BankCardStrategy();

        // 使用不同策略支付
        PaymentContext context = new PaymentContext(alipay);
        context.executePayment(100);  // 支付宝支付：100元

        context.setStrategy(wechat);
        context.executePayment(200);  // 微信支付：200元

        context.setStrategy(bankCard);
        context.executePayment(300);  // 银行卡支付：300元
    }
}
