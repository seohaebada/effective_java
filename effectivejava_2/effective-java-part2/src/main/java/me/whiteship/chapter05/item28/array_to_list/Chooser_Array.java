package me.whiteship.chapter05.item28.array_to_list;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// 코드 28-6 배열 기반 Chooser
public class Chooser_Array {
    // 여러 타입을 지원하기 위한 Object type 배열
    private final Object[] choiceList;

    public Chooser_Array(Collection choices) {
        choiceList = choices.toArray();
    }

    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList[rnd.nextInt(choiceList.length)];
    }

    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3, 4, 5, 6);
//        List<String> stringList = List.of("a", "b");

        // 어떠한 값이 들어올지를 모름
        Chooser_Array chooser = new Chooser_Array(intList);
//        Chooser_Array chooser = new Chooser_Array(stringList);

        for (int i = 0; i < 10; i++) {
            // 만약 숫자 배열이 아닐 경우 오류 발생
            // 타입 형변환을 안전하게 하고자 제네릭이 등장한것이다.
            Number choice = (Number) chooser.choose();
            System.out.println(choice);
        }
    }
}
