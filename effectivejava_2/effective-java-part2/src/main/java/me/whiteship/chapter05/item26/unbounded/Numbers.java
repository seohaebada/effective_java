package me.whiteship.chapter05.item26.unbounded;

import java.util.HashSet;
import java.util.Set;

public class Numbers {

    /**
     * Set<?> vs Set
     * Set : 아무 컬렉션이나 넣을 수 있다.
     * -> s1.add("string"); s1.add(10); // 안정성이 깨진다.
     *
     * set<?> : 아무런 타입도 가능하다.
     * Set<String> set = new HashSet<>();
     * Set<?> mySet = set;
     *
     * 로 타입은 아무 타입이나 추가할 수 있는데, Set<?> 는 아무것도 넣을 수 없다. null 밖에 못넣는다.
     * @param s2
     * @return
     */
    static int numElementsInCommon(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Numbers.numElementsInCommon(Set.of(1, 2, 3), Set.of(1, 2)));
    }
}
