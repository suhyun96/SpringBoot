package com.example.coffee.dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

// 마이바티스 쓰기위해선 mapper 어노테이션이 필요!
@Mapper
public interface CoffeeV1Dao {
    // 전체 리스트 조회
    // 인터페이스네 dao에서 매퍼를 쓰는 경우 인터페이스라고 하네
    // 리스트로 반환하는 doCoffeeList가 있다 .. doCoffeeList이 부분을 매퍼로 구현해야함!
    List<Map<String, String>> doCoffeeList();


}
