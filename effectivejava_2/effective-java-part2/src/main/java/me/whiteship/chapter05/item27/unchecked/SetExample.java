package me.whiteship.chapter05.item27.unchecked;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        // 로 타입
        Set names = new HashSet();

        // 경고 해결
        Set<String> strings = new HashSet<>();
    }
}
