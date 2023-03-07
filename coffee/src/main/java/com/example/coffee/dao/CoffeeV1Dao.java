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


    // 전체리스트 조회 - 함수 오버로딩
    List<Map<String, String>> doCoffeeList(String strStart_date,String strEnd_date,String strName,String strKind);

    // insert !
    // 위에랑 같은 xml써도 상관없는듯 보아하니 xml에 있는 id로 메서드 구분하지 파일 구분은 아닌듯하다
    int doInsert(String name, String kind, String price);

    // Row 1 가져오기
    Map<String, String> doListOne(String strCoffee_id);

    // 수정하기 post
    int doUpdate(String strCoffeeId, String strName, String strKind, String strPrice);

    // 1 row 삭제
    int doDelete(String strCoffeeId);
}
