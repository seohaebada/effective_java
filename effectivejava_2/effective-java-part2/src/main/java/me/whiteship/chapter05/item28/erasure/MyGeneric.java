package me.whiteship.chapter05.item28.erasure;

import java.util.ArrayList;
import java.util.List;

public class MyGeneric {

    public static void main(String[] args) {
        // 실체화되지 않는다. <String>이 사라진다.
        List<String> names = new ArrayList<>();
        names.add("keesun");
        String name = names.get(0);
        System.out.println(name);

        // 실체화되지 않음 > 타입이 사라진다.
        // 아래와 같이 컴파일된다.
        List names2 = new ArrayList();
        names2.add("keesun");
        Object o = names2.get(0);
        String name2 = (String) o;
    }

}
