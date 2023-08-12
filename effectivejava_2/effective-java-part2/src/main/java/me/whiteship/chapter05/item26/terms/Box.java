package me.whiteship.chapter05.item26.terms;

/**
 * 제네릭 타입 사용
 * 제네릭 클래스
 * @param <E>
 */
public class Box<E> {

    private E item;

    private void add(E e) {
        this.item = e;
    }

    private E get() {
        return this.item;
    }

    public static void main(String[] args) {
        // 실제 타입 매개변수
        Box<Integer> box = new Box<>();
        box.add(10);
        System.out.println(box.get() * 100);

        printBox(box);
    }

    /**
     * Box vs Box<?>(이게 조금더 안전한 코드)
     * Box<Object> 불가능 : Box<Integer>과 다르다.
     * @param box
     */
    private static void printBox(Box<?> box) {
        System.out.println(box.get());
    }

}
