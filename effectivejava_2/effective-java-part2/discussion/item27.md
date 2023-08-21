## 아이템 27. 비검사 경고를 제거하라

### 1) 포스팅 정리
https://devfunny.tistory.com/573

### 2) 어노테이션 @Retention 속성인 RetentionPolicy
##### RetentionPolicy.SOURCE : 소스 코드(.java)까지 남아있는다.

[예제 : Lombok의 @Getter]
```
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface Getter {
    ...
}
```
- 컴파일될때 실제 getter 메서드가 바이트코드로 생성된다.

##### RetentionPolicy.CLASS : 클래스 파일(.class)까지 남아있는다.(= 바이트 코드)
[예제 : Lombok의 @NonNull]
```
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.CLASS)
@Documented
public @interface NonNull {
}
```
- @NonNull을 쓰면, 해당 파라미터를 사용한 메서드 시작 부분 또는 생성자의 바디 부분에 null 체크 로직을 삽입해준다.
  필드에 쓰면, 해당 필드에 값을 할당하는 어떤 생성된 메서드 내부에 null 체크 로직을 삽입해준다.
  (여기서, Source 속성이여도 되지 않을까? -> jar 파일에는 .class 파일만 있다.)
- .class 파일까지는 어노테이션이 살아있고, 런타임에서 클래스로더가 해당 클래스를 읽어오면 사라진다.
- jar 파일같은 경우에는 .class 파일만 포함되어있기 때문에 Source가 아닌 Class 사용이 필요한 때가 있다.

##### RetentionPolicy.RUNTIME : 런타임까지 남아있는다.(= 사실상 안 사라진다.)
[예제 : @Autowired]
```
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {
    boolean required() default true;
}

```
- 런타임시(스프링이 올라오는 실행중인 시점) 컴포넌트 스캔이 가능해야하기 때문이다.

### 3) 어노테이션 실무 적용 사례
> @LegacyOutput
