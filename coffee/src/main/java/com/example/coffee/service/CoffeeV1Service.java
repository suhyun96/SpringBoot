package com.example.coffee.service;

import com.example.coffee.dao.CoffeeV1Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CoffeeV1Service {

    @Autowired
    CoffeeV1Dao coffeeV1Dao;

    // 전체 리스트 조회
    public List<Map<String, String>> doCoffeeList() {
        // dao에서 가지고 와야 쓰지! 즉 맵퍼
        List<Map<String,String>> list = coffeeV1Dao.doCoffeeList();

        return list;
    }
}
