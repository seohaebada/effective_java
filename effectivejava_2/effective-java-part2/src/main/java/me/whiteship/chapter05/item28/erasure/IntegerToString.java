package me.whiteship.chapter05.item28.erasure;

import java.util.ArrayList;
import java.util.List;

public class IntegerToString {

    public static void main(String[] args) {
        // 공변
        // Object (상위), String (하위)
        // String->Object 타입 변환 가능
        Object[] anything = new String[10];
        // ArrayStoreException 발생함
        anything[0] = 1; // 문자열 배열에 숫자를 넣으므로 잘못된 코드다.(컴파일 오류로 잡히지 않음)
        // 왜 컴파일 오류로 안잡히나? 공변이기 때문에.

        // 불공변
        List<String> names = new ArrayList<>();
        // 아래는 넣을 수 없다. 아예 다른 타입이다.
//        List<Object> objects = names;

        // 실체화란? 런타임에 타입이 유지되는 것을 말한다.
        // 런타임에 타입이 유지가 되는가?
        // 배열은 런타임에 유지가 되고, 제네릭은 유지가 안된다.
        // 제네릭은 사라진다. List<String> names -> List names


//        // 제네릭과 배열을 같이 사용할 수 있다면...(가능하지 않음)
//        List<String>[] stringLists = new ArrayList<String>[1];
//        List<Integer> intList = List.of(42);
//        Object[] objects = stringLists;
//        objects[0] = intList;
        // stringLists[0] 에 intList가 들어가있음
//        String s = stringLists[0].get(0); // 데이터가 깨진다.
//        System.out.println(s);
    }
}
