package me.whiteship.chapter05.item26.raw;

public class UseRawType<E> {

    private E e;

    public static void main(String[] args) {
        System.out.println(UseRawType.class);

        UseRawType<String> stringType = new UseRawType<>();

        System.out.println(stringType instanceof UseRawType);
        // 어차피 소거되므로 제네릭을 쓸 필요가 없다.
//        System.out.println(stringType instanceof UseRawType<String>);
    }
}
