package ru.job4j;

import java.util.ArrayList;
import java.util.List;

public class Gc {
    public static void main(String[] args) {
        List<User> users1 = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            users1.add(new User());
//            if (i == (i / 100) * 100) {
                System.out.println("to users1 added object № " + i);
//            }
        }
     }
}