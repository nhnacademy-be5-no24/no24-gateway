package com.nhnacademy.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RequestMapping("/redis")
@RestController
public class RedisController {
    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/{key}")
    public ResponseEntity<Object> getRedisKey(@PathVariable String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String value = valueOperations.get(key);
        return ResponseEntity.status(HttpStatus.OK).body(value);
    }
}
