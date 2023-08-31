package me.whiteship.chapter05.item32;

import java.util.ArrayList;
import java.util.List;

// 제네릭 varargs 배열 매개변수에 값을 저장하는 것은 안전하지 않다. (191-192쪽)
public class Dangerous {
    // 코드 32-1 제네릭과 varargs를 혼용하면 타입 안전성이 깨진다! (191-192쪽)
    static void dangerous(List<String>... stringLists) {
        // 허용하지않음
        // 근데 가변인자를 사용하면 내부적으로 생성함
//        List<String>[] myList = new ArrayList<String>[];

        List<Integer> intList = List.of(42);
        Object[] objects = stringLists;
        objects[0] = intList; // 힙 오염 발생
        String s = stringLists[0].get(0); // ClassCastException
    }

    public static void main(String[] args) {
        dangerous(List.of("There be dragons!"));
    }
}
