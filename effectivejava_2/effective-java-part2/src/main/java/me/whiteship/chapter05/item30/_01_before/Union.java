package me.whiteship.chapter05.item30._01_before;

import java.util.HashSet;
import java.util.Set;

// 제네릭 union 메서드와 테스트 프로그램 (177쪽)
public class Union {

    // 코드 30-2 제네릭 메서드 (177쪽)
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    // 코드 30-3 제네릭 메서드를 활용하는 간단한 프로그램 (177쪽)
    public static void main(String[] args) {
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<String> stooges = Set.of("래리", "모에", "컬리");
//        Set<Integer> stooges = Set.of(1, 2, 3);
        Set<String> all = union(guys, stooges);

        // 합친 다음 꺼내서 쓸때, 타입 변환시 오류 발생할 수 있음 -> 컴파일 타임에 체크하려면 제네릭 사용
        for (String o : all) {
            System.out.println(o);
        }
    }
}
