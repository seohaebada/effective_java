package me.whiteship.chapter05.item33.type_token;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Favorites {
    // Class 클래스는 제네릭 클래스다.
    // Class<String> : String만 씀
    // 임의의 타입들로 정의하고싶음 : Class<?> (비한정적 와일드카드 사용)
    private Map<Class<?>, Object> map = new HashMap<>();

    // 이중 컨테이너 (서로 다른 타입들을 넣을 수 있다.)
    // 그냥 Class로만 하면 f.put(String.class, 1)이 가능해져서 문제가 발생한다.
    // -> 이럴땐 key에 해당하는 곳에 타입을 선언해야한다. (Class<T>)
    public <T> void put(Class<T> clazz, T value) {
        this.map.put(Objects.requireNonNull(clazz), clazz.cast(value));
    }

    // 클래스 리터럴 (Integer.class)
    public <T> T get(Class<T> clazz) {
        return clazz.cast(this.map.get(clazz));
//        return (T) this.map.get(clazz);
    }

    public static void main(String[] args) {
        Favorites favorites = new Favorites();
        favorites.put(String.class, "keesun");
        favorites.put(Integer.class, 2);

        // 이런식으로 된다. 이렇게되면 값에 아무거나 보낼 수 있다.
        // 넣을때 (put()) clazz.cast(value) 로 하자.
        // 그나마 오류를 빨리 캐치하자. 꺼내올떄 말고 넣을때!
        favorites.put((Class)String.class, 2);

        // 이렇게하면 key가 중복
//        favorites.put(List.class, List.of(1, 2, 3));
//        favorites.put(List.class, List.of("a", "b", "c"));

        // 이건 문법 허용이 안됨 (타입을 가지고있는 리터럴이 없다. List<Integer>.class 가 없다)
        // 이걸 구분하기위해 슈퍼타입토큰이 등장
//        favorites.put(List<Integer>.class, List.of(1, 2, 3));
//        favorites.put(List<String>.class, List.of("a", "b", "c"));

//        List list = favorites.get(List.class);
//        list.forEach(System.out::println);
    }

}
