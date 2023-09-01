package me.whiteship.chapter05.item33.super_type_token;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericTypeInfer {

    static class Super<T> {
        T value;
    }

    public static void main(String[] args) throws NoSuchFieldException {
        Super<String> stringSuper = new Super<>();
//        stringSuper.value = "aa";

        // 필드의 타입은? Object (제네릭은 런타임에 모두 Object)
        System.out.println(stringSuper.getClass().getDeclaredField("value").getType());

        // (new Super<String>(){}) : 익명 외부 클래스
        Type type = (new Super<String>(){}).getClass().getGenericSuperclass();
        ParameterizedType pType = (ParameterizedType) type;
        // 이 타입정보를 알수가 있다. (String)
        Type actualTypeArgument = pType.getActualTypeArguments()[0];
        System.out.println(actualTypeArgument);

    }
}
