## 아이템 32. 제네릭과 가변인수를 함께 쓸 때는 신중하라

### 1) 포스팅 정리
https://devfunny.tistory.com/582

### 2) 짚고넘어갈 부분
- prickTwo 는 항상 Object[] 타입 배열을 반환한다.
  - 우리가 지금까지 배운 내용! 
- pickTwo의 반환값을 attributes 에 저장하기 위해 String[] 로 형변환하는 곳에서 ClassCastException 발생
```java
package com.java.effective.item32;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main2 {
    public static void main(String[] args) {
        String[] attributes = pickTwo("AA", "BB", "CC");
    }

    static <T> T[] toArray(T...args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            // Unchecked generics array creation for varargs parameter
            case 0 : return toArray(a,b);
            case 1 : return toArray(a,c);
            case 2 : return toArray(b,c);
        }

        throw new AssertionError(); // 도달할 수 없음
    }
}
```

### 3) List.of()
```java
// 배열 대신 List를 이용해 안전하게 바꿘 PickTwo (196쪽)
public class SafePickTwo {
    static <T> List<T> pickTwo(T a, T b, T c) {
        switch(ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(a, b);
            case 1: return List.of(a, c);
            case 2: return List.of(b, c);
        }
        throw new AssertionError();
    }

    public static void main(String[] args) {
        List<String> attributes = pickTwo("좋은", "빠른", "저렴한");
        System.out.println(attributes);
    }
}
```

- List.of()는 a, b의 타입을 추론하여 가장 구체적이고 구체화된 타입을 사용한다.
- a가 String이고 b가 String이라면, result의 타입은 List<String>
- a가 String이고 b가 Integer라면, result의 타입은 List<Object>


#### List.of 구현로직
```
@SafeVarargs
@SuppressWarnings("varargs")
static <E> List<E> of(E... elements) {
    switch (elements.length) { // implicit null check of elements
        case 0:
            @SuppressWarnings("unchecked")
            var list = (List<E>) ImmutableCollections.EMPTY_LIST;
            return list;
        case 1:
            return new ImmutableCollections.List12<>(elements[0]);
        case 2:
            return new ImmutableCollections.List12<>(elements[0], elements[1]);
        default:
            return ImmutableCollections.listFromArray(elements);
    }
}
```

- 왜 length 별로 나눠져있을까?
  - case 0일때는 항상 같은 인스턴스를 반환한다. (EMPTY_LIST)
  - case 1, 2일때는 추가적인 배열이나 리스트를 생성하지 않고도 최적화할 수 있다.
  - case 3일때는 listFromArray()에서 배열을 복사하여 내부적으로 사용한다. 추가적인 배열 복사 작업이 있다.
    - `E[] tmp = (E[])new Object[input.length];`
