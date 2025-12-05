package com.example.redisdemo.controller;

import com.example.redisdemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/redis")
public class RedisController {

    @Autowired
    private RedisService redisService;

    /**
     * 设置缓存
     */
    @PostMapping("/set")
    public ResponseEntity<String> set(@RequestParam String key, @RequestParam String value) {
        redisService.set(key, value);
        return ResponseEntity.ok("Set successfully");
    }

    /**
     * 设置缓存并指定过期时间
     */
    @PostMapping("/set-with-expire")
    public ResponseEntity<String> setWithExpire(@RequestParam String key, @RequestParam String value, 
                                                @RequestParam long expireTime, @RequestParam TimeUnit timeUnit) {
        redisService.set(key, value, expireTime, timeUnit);
        return ResponseEntity.ok("Set with expire successfully");
    }

    /**
     * 获取缓存
     */
    @GetMapping("/get")
    public ResponseEntity<Object> get(@RequestParam String key) {
        Object value = redisService.get(key);
        return ResponseEntity.ok(value);
    }

    /**
     * 删除缓存
     */
    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String key) {
        Boolean result = redisService.delete(key);
        return result ? ResponseEntity.ok("Delete successfully") : ResponseEntity.ok("Key not found");
    }

    /**
     * 递增
     */
    @PostMapping("/increment")
    public ResponseEntity<Long> increment(@RequestParam String key) {
        Long result = redisService.increment(key);
        return ResponseEntity.ok(result);
    }

    /**
     * 递减
     */
    @PostMapping("/decrement")
    public ResponseEntity<Long> decrement(@RequestParam String key) {
        Long result = redisService.decrement(key);
        return ResponseEntity.ok(result);
    }

    /**
     * 设置过期时间
     */
    @PostMapping("/expire")
    public ResponseEntity<String> expire(@RequestParam String key, @RequestParam long expireTime, 
                                         @RequestParam TimeUnit timeUnit) {
        Boolean result = redisService.expire(key, expireTime, timeUnit);
        return result ? ResponseEntity.ok("Set expire successfully") : ResponseEntity.ok("Key not found");
    }

    /**
     * 获取过期时间
     */
    @GetMapping("/get-expire")
    public ResponseEntity<Long> getExpire(@RequestParam String key, @RequestParam TimeUnit timeUnit) {
        Long result = redisService.getExpire(key, timeUnit);
        return ResponseEntity.ok(result);
    }

    /**
     * 判断键是否存在
     */
    @GetMapping("/has-key")
    public ResponseEntity<Boolean> hasKey(@RequestParam String key) {
        Boolean result = redisService.hasKey(key);
        return ResponseEntity.ok(result);
    }
}