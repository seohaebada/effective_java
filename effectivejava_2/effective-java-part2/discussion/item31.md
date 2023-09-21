## 아이템 31. 한정적 와일드카드를 사용해 API 유연성을 높이라

### 1) 포스팅 정리
https://devfunny.tistory.com/579

### 생소한 타입선언
```
ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
...

BoxExample.<Integer>addBox(10, listOfIntegerBoxes);
```
1) `<Integer>`
- addBox를 호출할 때 사용되는 형식 인수(type argument)를 지정
  - 메서드 addBox가 어떤 형식의 데이터를 다루는지 명시

```
 private static <U> void addBox(U u, List<Box<U>> boxes) {
    Box<U> box = new Box<>();
    box.set(u);
    boxes.add(box);
}
```
- `addBox` 메서드에는 형식 매개변수 `<U>`
  - U 자리 표시자를 실제 데이터 형식으로 대체하는 것이다.
- `addBox(10, listOfIntegerBoxes)`에서 10은 `Integer` 형식의 데이터이므로,
  `<Integer>`는 메서드에게 Integer 타입을 사용한다고 알려주는 역할을 한다.
