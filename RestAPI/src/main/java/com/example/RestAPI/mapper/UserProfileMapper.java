package com.example.RestAPI.mapper;

import com.example.RestAPI.model.UserProfile;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// 인터페이스를 mapper로 인식
@Mapper
public interface UserProfileMapper {

    //전달받은 id로 데이터베이스 테이블에서 조회후 객체를 리턴
    //이거랑 매핑할 sql문을 어노테이션으로 지정
    //id 표시할 때 $ 가 아니라 # 임
    @Select("SELECT * FROM UserProfile WHERE id=#{id}")
    // 파라미터로 전달된 id가 sql문에 가고 sql문이 실행
    // 리턴을 해당 디비에 있는 값들을 리턴하고 UserProfile에 반환
    UserProfile getUserProfile(@Param("id") String id);


    @Select("SELECT * FROM UserProfile")
    List<UserProfile> getUserProfileList();


    // sql문에 의해 적용 혹은 영향받은 레코드의 갯수를 반환
    // 보통 insert 1개 , update도 1 , delete 도 1 -> 제대로 동작할때
    // 0이면 제대로 동작 x
    @Insert("INSERT INTO UserProfile VALUES(#{id}, #{name}, #{phone}, #{address})")
    int insertUserProfile(@Param("id") String id, @Param("name") String name, @Param("phone") String phone, @Param("address") String address);

    @Update("UPDATE UserProfile SET name=#{name}, phone=#{phone}, address=#{address} WHERE id=#{id}")
    int updateUserProfile(@Param("id") String id, @RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("address") String address);


    @Delete("DELETE FROM UserProfile WHERE id = #{id}")
    int deleteUserProfile(@Param("id") String id);

}
