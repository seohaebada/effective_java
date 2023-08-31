package me.whiteship.chapter05.item32;

import java.util.ArrayList;
import java.util.List;

// 코드 32-3 제네릭 varargs 매개변수를 안전하게 사용하는 메서드 (195쪽)
public class FlattenWithVarargs {

    @SafeVarargs // java7부터 등장 (가변인자가 안전하다는 내용)
    // 가변인자에 아무것도 넣지말고, 꺼내서 쓰기만하면 안전!
    // lists 파라미터를 밖으로 노출해주지 마라! (return 또는 밖에 전달해주지마라)
//    @SuppressWarnings("unchecked") // 안에 모든 코드가 unchecked
    static <T> List<T> flatten(List<? extends T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<? extends T> list : lists)
            result.addAll(list);
        return result;
    }

    public static void main(String[] args) {
        List<Integer> flatList = flatten(
                List.of(1, 2), List.of(3, 4, 5), List.of(6,7));
        System.out.println(flatList);
    }
}
