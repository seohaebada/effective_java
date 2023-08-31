package me.whiteship.chapter05.item31.typeinference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoxExample {

    private static <U> void addBox(U u, List<Box<U>> boxes) {
        Box<U> box = new Box<>();
        box.set(u);
        boxes.add(box);
    }

    private static <U> void outputBoxes(List<Box<U>> boxes) {
        int counter = 0;
        for (Box<U> box: boxes) {
            U boxContents = box.get();
            System.out.println("Box #" + counter + " contains [" +
                    boxContents.toString() + "]");
            counter++;
        }
    }

    private static void processStringList(List<String> stringList) {

    }


    public static void main(String[] args) {
        ArrayList<Box<Integer>> listOfIntegerBoxes = new ArrayList<>();
        // 타입 추론이 가능하므로 생략 가능 (제네릭 메서드 호출시)
        // 리턴타입 추론 (<Integer>)
        BoxExample.<Integer>addBox(10, listOfIntegerBoxes);
        BoxExample.addBox(20, listOfIntegerBoxes);
        BoxExample.addBox(30, listOfIntegerBoxes);
        BoxExample.outputBoxes(listOfIntegerBoxes);

        // Target Type
        List<String> stringlist = Collections.emptyList();
        List<Integer> integerlist = Collections.emptyList();
        // 리턴타입을 컴파일러가 추론해주는구나.
        BoxExample.processStringList(Collections.<String>emptyList());
    }
}
