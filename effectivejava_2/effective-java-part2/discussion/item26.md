## 아이템 26. 로 타입은 사용하지 말라.

### 1) 포스팅 정리
https://devfunny.tistory.com/563

### 공변성
1) 공변이란?
- 타입 'S', 'T' 가 있을때 'T'는 'S'의 하위타입이라고 하자.
  `C<T>` 는 `C<S>`의 하위타입인가? 라고 할때, 이게 성립되면 이는 공변적이라고 한다.
- 자바는 공변, 반공변을 지원하지 않는다.
  - `List<Object>`가 `List<String>`의 상위타입이 아니다.
- 예제코드
```
Stack<Number> stack = new Stack<Number>();
Collection<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
stack.pushAll(integers); // compile error!
```
  - `Collection<Integer>`는 `Collection<Number>`의 하위타입이 아니다.

### 런타임에 제네릭은 타입 정보 소거 (extends 라는 제약조건은 런타임시에도 남아있다.)
- extends와 같은 제약 조건은 런타임에도 남아있다. 
  - 컴파일러가 해당 제약 조건을 검사하여 적절한 타입 변환을 수행하거나 오류를 감지하기 위해서다.

### 책에서 아래 문장에 의문
> "런타임에는 제네릭 타입 정보가 지워지므로 instanceof 연산자는 비한정적 와일드카드 타입(<?>) 이외의 매개변수화 타입에는 적용할 수 없다."

- 예제로 확인
```java
public class InstanceofTest {
    public static void main(String[] args) {
        // 런타임에는 제네릭 타입 정보가 지워지므로 instanceof 연산자는
        // 비한정적 와일드카드 타입(<?>) 이외의 매개변수화 타입에는 적용할 수 없다.

        Set<String> strings = new HashSet<>();
        Set<Object> objects = new HashSet<>();
        Set<?> test = new HashSet<>();

        // 아래 전부 true
        if (strings instanceof Set) { // 로 타입
            System.out.println("strings true");
        }

        if (objects instanceof Set) { // 로 타입
            System.out.println("objects true");
        }

        if (test instanceof Set) { // 로 타입
            System.out.println("test true");
        }

        if (test instanceof Set<?>) {
            System.out.println("test true");
        }

        // 불가능
//        if (strings instanceof Set<Object>) {
//            System.out.println("strings true");
//        }

//        if (objects instanceof Set<String>) {
//            System.out.println("strings true");
//        }
    }
}
```

### wildcards 사용 : List<?>
- 이 제네릭 타입을 받는 List의 가지고있는 메서드만 사용한다는 의미, 타입과 연관된 add 이런건 안쓴다는 의미
- List<? extends A> la = lb; 얘도 null만 들어간다.

