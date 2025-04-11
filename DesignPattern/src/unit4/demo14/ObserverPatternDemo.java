package unit4.demo14;

/**
* @projectName DesignPattern
* @package unit4.demo14
* @className unit4.demo14.ObserverPatternDemo

* @author chenyingtao
* @date 2025/4/9 15:41
* @version 1.0
* @description @todo 
*/

import java.util.ArrayList;
import java.util.List;

// 1. 定义观察者接口
interface Observer {
    void update(float temperature);
}

// 2. 定义主题接口
interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

// 3. 实现具体主题（气象站）
class WeatherStation implements Subject {

    // 观察者列表
    private final List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// 4. 实现具体观察者
class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("手机显示：当前温度 " + temperature + "℃");
    }
}

class TVDisplay implements Observer {
    @Override
    public void update(float temperature) {
        System.out.println("电视显示：现在气温 " + temperature + "摄氏度");
    }
}

// 5. 客户端使用
public class ObserverPatternDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();

        Observer phone = new PhoneDisplay();
        Observer tv = new TVDisplay();

        // 注册观察者
        station.registerObserver(phone);
        station.registerObserver(tv);

        // 模拟温度变化
        station.setTemperature(25.5f);
        System.out.println("\n---------- 温度变化 ----------");
        station.setTemperature(28.0f);

        // 移除一个观察者
        station.removeObserver(tv);
        System.out.println("\n---------- 移除电视显示后 ----------");
        station.setTemperature(30.0f);
    }
}

