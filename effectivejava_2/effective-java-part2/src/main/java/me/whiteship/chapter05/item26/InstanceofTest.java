package me.whiteship.chapter05.item26;

import java.util.HashSet;
import java.util.Set;

public class InstanceofTest {
    public static void main(String[] args) {
        // 런타임에는 제네릭 타입 정보가 지워지므로 instanceof 연산자는
        // 비한정적 와일드카드 타입(<?>) 이외의 매개변수화 타입에는 적용할 수 없다.

        Set<String> strings = new HashSet<>();
        Set<Object> objects = new HashSet<>();
        Set<?> test = new HashSet<>();

        // 아래 전부 true
        if (strings instanceof Set) { // 로 타입
            System.out.println("strings true");
        }

        if (objects instanceof Set) { // 로 타입
            System.out.println("objects true");
        }

        if (test instanceof Set) { // 로 타입
            System.out.println("test true");
        }

        if (test instanceof Set<?>) {
            System.out.println("test true");
        }

        // 불가능
//        if (strings instanceof Set<Object>) {
//            System.out.println("strings true");
//        }

//        if (objects instanceof Set<String>) {
//            System.out.println("strings true");
//        }
    }
}
