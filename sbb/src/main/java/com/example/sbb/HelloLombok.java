package com.example.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//final이 붙어있는 변수를 가지고 생성자 만들어야 되도록 변경
//final 붙어 있으니 @setter 노의미
@RequiredArgsConstructor
@Getter
//@Setter
public class HelloLombok {

    private final String hello;
    private final int lombok;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("헬로",4);
//        helloLombok.setHello("헬로");
//        helloLombok.setLombok(5);

        System.out.println(helloLombok.getHello());
        System.out.println(helloLombok.getLombok());
    }
}
