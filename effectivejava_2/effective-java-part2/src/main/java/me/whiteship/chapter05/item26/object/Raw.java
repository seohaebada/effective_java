package me.whiteship.chapter05.item26.object;

import java.util.ArrayList;
import java.util.List;

// 코드 26-4 런타임에 실패한다. - unsafeAdd 메서드가 로 타입(List)을 사용 (156-157쪽)
public class Raw {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, Integer.valueOf(42));
        String s = strings.get(0); // 컴파일러가 자동으로 형변환 코드를 넣어준다.

        List<Object> test = new ArrayList<>();
        unsafeAdd2(test);
//        unsafeAdd3(strings); // 컴파일 오류 발생
    }

    // List<String> != List<object>
    private static void unsafeAdd(List list, Object o) {
        // 서버 오류 발생
        list.add(o);
    }

    private static void unsafeAdd2(List list) {

    }

    private static void unsafeAdd3(List<Object> list) {

    }
}

