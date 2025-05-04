package com.chen.monitor.controller;

import com.chen.monitor.service.MonitorService;
import com.chen.monitor.vo.Info;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

@RestController
@Slf4j
public class MonitorController {
    public static ArrayBlockingQueue<Info> QUEUE = new ArrayBlockingQueue(30);

    @Autowired
    private MonitorService monitorService;

    /**
     * 获取信息列表
     * <p>
     * 本方法通过GET请求访问"/info"端点，将队列中的所有信息转移到一个列表中，并返回该列表
     * 主要目的是为了提供一个接口，用于获取队列中的所有信息，以便进行进一步处理或展示
     *
     * @return List<Info> 包含所有信息的列表
     */
    @GetMapping("/info")
    public List<Info> info() {
        // 创建一个空的ArrayList，用于存储从队列中移出的信息
        ArrayList<Info> infos = new ArrayList<>();
        // 将队列中的所有元素转移到infos列表中，这个操作清空了队列，同时准备了传输的数据
        QUEUE.drainTo(infos);
        // 返回包含所有信息的列表
        return infos;
    }


    @GetMapping("/start")
    public void start() {
        log.info("启动监控线程...");
        monitorService.start();
    }

    @GetMapping("/stop")
    public void stop() {
        log.info("停止监控线程...");
        monitorService.stop();
    }
}