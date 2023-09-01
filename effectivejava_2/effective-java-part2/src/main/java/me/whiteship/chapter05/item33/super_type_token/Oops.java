package me.whiteship.chapter05.item33.super_type_token;

import java.util.ArrayList;
import java.util.List;

class Oops {
    static Favorites2 f = new Favorites2();

    static <T> List<T> favoriteList() {
        TypeRef<List<T>> ref = new TypeRef<>() {};
        System.out.println(ref.getType()); // List<T>
        // ref.getType()이 두번호출해도 둘다 동일하다.

        // equals, hashCode가 같기 때문에 동일한 리스트가 리턴되어버린다.
        List<T> result = f.get(ref);
        if (result == null) {
            result = new ArrayList<T>();
            f.put(ref, result);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> ls = favoriteList();

        List<Integer> li = favoriteList();
        li.add(1);

        for (String s : ls) System.out.println(s);
    }
}
