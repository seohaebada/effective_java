package me.whiteship.chapter05.item26.terms;

import java.util.ArrayList;
import java.util.List;

public class GenericBasic {

    public static void main(String[] args) {
//        // Generic 사용하기 전
        // 제네릭 나오기 전의 코드도 지원하기 위해 로 타입도 여전히 제공한다.
        // 제네릭 코드도 컴파일하면 결국 아래의 로 타입 코드로 된다. (타입 형변환 코드를 자바가 넣어준다)
//        // 로 타입
//        List numbers = new ArrayList();
//        numbers.add(10);
//        numbers.add("whiteship");
//
//        for (Object number: numbers) {
////         서버 오류 발생
////         형변환
//            System.out.println((Integer)number);
//        }

        // Generic 등장 이후
//        List<Integer> nuberms = new ArrayList<>();
//        nuberms.add(10);
//        nuberms.add("whiteship"); // 컴파일 오류 발생
//
//        for (Integer number: nuberms) {
//            System.out.println(number);
//        }
    }
}
