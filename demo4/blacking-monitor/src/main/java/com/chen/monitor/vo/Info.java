package com.chen.monitor.vo;

import lombok.Data;

@Data
public class Info {
    private long free;
    private long total;
    private long max;
    private long time;
}
