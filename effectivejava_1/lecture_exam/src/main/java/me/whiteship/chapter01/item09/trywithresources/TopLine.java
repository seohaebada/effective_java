package me.whiteship.chapter01.item09.trywithresources;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TopLine {
    // 코드 9-3 try-with-resources - 자원을 회수하는 최선책! (48쪽)
    static String firstLineOfFile(String path) throws IOException {
        // 바이트코드를 보면 내부적으로 어떻게 수행되는지 알 수 있다.
        try (BufferedReader br = new BufferedReader(
                new FileReader(path))) {
            return br.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = args[0];
        System.out.println(firstLineOfFile(path));
    }
}
