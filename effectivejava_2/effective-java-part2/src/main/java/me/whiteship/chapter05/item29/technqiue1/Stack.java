package me.whiteship.chapter05.item29.technqiue1;

import me.whiteship.chapter05.item29.EmptyStackException;

import java.util.Arrays;
import java.util.List;

// E[]를 이용한 제네릭 스택 (170-174쪽)
// 왜 리스트로 안바꾸지? -> 자료구조들은 성능에 민감하므로 배열을 쓰 경우가 많다.
public class Stack<E> {
    private E[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    // 코드 29-3 배열을 사용한 코드를 제네릭으로 만드는 방법 1 (172쪽)
    // 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
    // 따라서 타입 안전성을 보장하지만,
    // 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!
    @SuppressWarnings("unchecked") // push 에서 E타입만 넣으므로
    public Stack() {
        // 제네릭 배열은 만들 수 없음
//        elements = new E[DEFAULT_INITIAL_CAPACITY];
        // 형변환은 이때 한번만 한다.
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // 코드 29-5 제네릭 Stack을 사용하는 맛보기 프로그램 (174쪽)
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        for (String arg : List.of("a", "b", "c"))
            stack.push(arg);

        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase());
    }
}
