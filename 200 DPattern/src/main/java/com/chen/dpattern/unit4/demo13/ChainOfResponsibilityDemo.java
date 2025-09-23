package com.chen.dpattern.unit4.demo13;

/**
* @projectName DesignPattern
* @package unit4.demo13
* @className unit4.ChainOfResponsibilityDemo

* @author chenyingtao
* @date 2025/4/9 15:34
* @version 1.0
* @description @todo
 *
*/
// 1. 定义抽象处理者
abstract class Handler {
    protected Handler nextHandler;
    protected String roleName;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(int days);
}

// 2. 实现具体处理者
class GroupLeader extends Handler {
    public GroupLeader() {
        this.roleName = "组长";
    }

    @Override
    public void handleRequest(int days) {
        if (days <= 3) {
            System.out.println(roleName + "审批通过" + days + "天请假");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(days);
        }
    }
}

class Manager extends Handler {
    public Manager() {
        this.roleName = "部门经理";
    }

    @Override
    public void handleRequest(int days) {
        if (days <= 7) {
            System.out.println(roleName + "审批通过" + days + "天请假");
        } else if (nextHandler != null) {
            nextHandler.handleRequest(days);
        }
    }
}

class Director extends Handler {
    public Director() {
        this.roleName = "总监";
    }

    @Override
    public void handleRequest(int days) {
        if (days <= 15) {
            System.out.println(roleName + "审批通过" + days + "天请假");
        } else {
            System.out.println(days + "天请假超过审批权限，无法处理！");
        }
    }
}

// 3. 客户端使用
public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // 创建处理者对象
        // 流程1
        Handler groupLeader = new GroupLeader();
        // 流程2
        Handler manager = new Manager();
        // 流程3
        Handler director = new Director();

        // 构建责任链
        groupLeader.setNextHandler(manager);

        manager.setNextHandler(director);

        // 测试不同请假天数
        System.out.println("=== 请假2天 ===");
        groupLeader.handleRequest(2);

        System.out.println("\n=== 请假5天 ===");
        groupLeader.handleRequest(5);

        System.out.println("\n=== 请假10天 ===");
        groupLeader.handleRequest(10);

        System.out.println("\n=== 请假20天 ===");
        groupLeader.handleRequest(20);
    }
}

