package me.whiteship.chapter01.item03.enumtype;

// 열거 타입 방식의 싱글턴 - 바람직한 방법 (25쪽)
public enum Elvis {
    INSTANCE; // 태생적으로 new 인스턴스()해서 생성할 수 없다. (리플렉션에서도 리플렉션 내부에서 막아놨다.)

    public void leaveTheBuilding() {
        System.out.println("기다려 자기야, 지금 나갈께!");
    }

    // 이 메서드는 보통 클래스 바깥(다른 클래스)에 작성해야 한다!
    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}