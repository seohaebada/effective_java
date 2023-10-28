## 아이템 33. 타입 안전 이종 컨테이너를 고려하라

### 1) 포스팅 정리
https://devfunny.tistory.com/585


### cast()
```
public class Class<T> {
	T cast(Object object);
}

...

@IntrinsicCandidate
public T cast(Object obj) {
    if (obj != null && !isInstance(obj))
        throw new ClassCastException(cannotCastMsg(obj));
    return (T) obj;
}
```