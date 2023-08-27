package me.whiteship.chapter05.item28.safevarags;

import java.util.List;

/**
 * 제네릭 가변인자 : 근본적으로 타입 안전하지 않다. (가변인자가 배열이기 때문)
 * 가변인자(배열)의 내부 데이터가 오염될 가능성이 있다.
 * @SafeVarargs : 가변 인자에 대한 해당 오염에 대한 경고를 없앨 수 있다.
 */
public class SafeVaragsExample {

//    @SafeVarargs // Not actually safe!
    static void notSafe(List<String>... stringLists) { // List<String>[] stringLists
        Object[] array = stringLists; // List<String>... => List[], 그리고 배열은 공변이니까.
        List<Integer> tmpList = List.of(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

    @SafeVarargs
    static <T> void safe(T... values) {
        // 그저 출력만 하는 로직이라면 안전. 이를 리턴한다거나 등의 행위를 하지 않아야한다.
        // 그렇게 해야 위 어노테이션을 붙인다.
        for (T value: values) {
            System.out.println(value);
        }
    }

    public static void main(String[] args) {
        SafeVaragsExample.safe("a", "b", "c");
        SafeVaragsExample.notSafe(List.of("a", "b", "c"));
    }

}
